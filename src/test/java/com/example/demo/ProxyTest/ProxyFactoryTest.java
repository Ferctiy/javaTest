package com.example.demo.ProxyTest;

import org.junit.Test;

public class ProxyFactoryTest {

    /**
     * 测试动态代理
     */
    @Test
    public void testProxy(){
        PersonFactory personFactory =  new PersonFactory();
        personFactory.createPerson();
        System.out.println(" ========================== ");
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(personFactory);
        PersonService proxy = (PersonService)  proxyFactory.getProxy();
        proxy.createPerson();

    }

}