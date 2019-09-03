package com.example.demo.ProxyTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName ProxyFactory
 * @Description TODO
 * @Author feroctiy
 * @Date 2019/9/2 14:49
 * @Version 1.0
 */
public class ProxyFactory implements InvocationHandler {

    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("==============方法之前============== ");
        Object result =   method.invoke(target,args);
        System.out.println("==============方法之后============== ");
        return result;
    }

    /**
     * 创建代理对象
     * @return
     */
    public Object getProxy(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }
}
