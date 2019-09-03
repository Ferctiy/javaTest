package com.example.demo.component;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//@SpringBootTest
//@RunWith(SpringRunner.class)
public class UploadTest {

    @Test
    public void uploadTest(){
        System.out.println(Upload.instance.getAcceptType()+Upload.instance.getMaxFileSize());
    }

}