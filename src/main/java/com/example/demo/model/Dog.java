package com.example.demo.model;

/**
 * @ClassName Dog
 * @Description TODO
 * @Author feroctiy
 * @Date 2019/8/19 18:31
 * @Version 1.0
 */
public class Dog {
    private int age;
    private String name;

    public Dog() {
    }

    public Dog(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
