package com.example.demo.component;

import com.example.demo.utils.RedisPrefix;
import com.example.demo.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Field;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @ClassName RedisCache
 * @Description TODO
 * @Author feroctiy
 * @Date 2019/8/29 9:10
 * @Version 1.0
 */
@Component
public class RedisCache<TValue> {
    private static final String FORMATTER_KEY_TYPE = "#%s#%s#";
    private static final String FORMATTER_KEY_ENTRY = "#%s#%s#%s#";
    private static final Logger logger = LoggerFactory.getLogger(RedisCache.class);

    private final RedisTemplate<String, TValue> redisTemplate;

    @Autowired
    public RedisCache(RedisTemplate<String, TValue> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    private RedisPrefix redisPrefix;

    public void setRedisPrefix(RedisPrefix redisPrefix) {
        this.redisPrefix = redisPrefix;
    }

    /**
     * 设置单个缓存对象
     *
     * @param key
     * @param value
     */
    public void set(Class<TValue> cls,String key, TValue value) {
        Objects.requireNonNull(value);
        ValueOperations< String, TValue > operations = redisTemplate.opsForValue();
        operations.set(addKeyPrefix(cls, key), value);
    }

    /**
     * 取得单个缓存对象
     * @param key
     * @return
     */
    public Optional<TValue> get(Class<TValue> cls,String key) {
        if (!StringUtils.isEmpty(key)) {
            TValue value =  redisTemplate.opsForValue().get(addKeyPrefix(cls, key));
            return Optional.ofNullable(value);
        }
        return Optional.empty();
    }

    /**
     * 获取列表中的单个对象
     * @param valueType
     * @param getter
     * @return
     */
    public Optional<TValue> getListItem(Class<TValue> valueType, Function<TValue, Boolean> getter) {
        return this.getListItems(valueType, getter).stream().findFirst();
    }

    /**
     * 获取列表
     * @param cls
     * @param getter
     * @return
     */
    public List<TValue> getListItems(Class<TValue> cls, Function<TValue,Boolean> getter){
        String key = addKeyPrefix(cls,null);
        ListOperations<String,TValue> operations = redisTemplate.opsForList();
        long sum;
        if (0 < (sum = operations.size(key))) {
            return operations.range(key, 0, sum).stream().filter(getter::apply).collect(toList());
        }
        return Collections.emptyList();
    }

    /**
     * 元素追加
     * @param valueType
     * @param comparer
     * @param values
     */
    public void append(Class<TValue> cls, TValue... values) {
        Objects.requireNonNull(values);
        this.append(cls, Arrays.asList(values));
    }

    /**
     * 元素追加
     * @param valueType
     * @param comparer
     * @param value
     */
    public void append(Class<TValue> cls, TValue value) {
        Objects.requireNonNull(value);
        this.append(cls, Collections.singleton(value));
    }

    /**
     * 元素追加
     * @param valueType
     * @param values
     */
    public void append(Class<TValue> cls, Collection<TValue> values){
        Objects.requireNonNull(values);
        if (CollectionUtils.isEmpty(values)){
            return;
        }
        String key = addKeyPrefix(cls,null);
        ListOperations<String,TValue> operations = redisTemplate.opsForList();

        long sum;
        if((sum =operations.size(key)) == 0){
            operations.rightPushAll(key,values);
            return;
        }
        List<TValue> currentValues =operations.range(key,0,sum);
        values.stream().filter(Objects::nonNull).forEach(value->{
            Optional<TValue> optional = currentValues.stream().filter(current -> compare(current, value)).findFirst();
            if (!optional.isPresent()){
                operations.rightPush(key,value);
            }else {
                operations.set(key, currentValues.indexOf(optional.get()), value);
            }
        });

    }

    /**
     * 添加前缀
     *
     * @param prefix
     * @param key
     * @return
     */
    private String addKeyPrefix(Class<TValue> cls, String key) {
        if (StringUtils.isEmpty(key)) {
            return String.format(FORMATTER_KEY_TYPE, redisPrefix.getName(),cls.getName());
        } else {
            return String.format(FORMATTER_KEY_ENTRY, redisPrefix.getName(),cls.getName(), key);
        }
    }

    /**
     * 比较id
     * @param t1
     * @param t2
     * @return
     */
    private boolean compare(Object t1, Object t2) {
        Class< ? > type;
        if (t1 != null && t2 != null && (type = t1.getClass()) == t2.getClass()) {
            if (t1 instanceof String) {
                return t1.equals(t2);
            }
            List< Field > fields = Stream.concat(Arrays.stream(type.getDeclaredFields()), Arrays.stream(type.getSuperclass().getDeclaredFields())).collect(toList());
            Optional< Field > optional;
            if ((optional = fields.stream().filter(a -> "id".equals(a.getName())).findFirst()).isPresent()) {
                Field idField = optional.get();
                try {
                    idField.setAccessible(true);
                    Object id1, id2;
                    if ((id1 = idField.get(t1)) != null && (id2 = idField.get(t2)) != null) {
                        return id1.equals(id2);
                    }
                } catch (Exception ignored) {

                }
            }
        }
        return t1 == t2;
    }
}
