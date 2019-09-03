package com.example.demo.ProxyTest;


/**
 * @ClassName PersonFactory
 * @Description 动态代理
 * @Author feroctiy
 * @Date 2019/9/2 14:46
 * @Version 1.0
 */
public class PersonFactory implements PersonService {

    @Override
    public void createPerson() {
        System.out.println("创建对象成功");
    }
}
