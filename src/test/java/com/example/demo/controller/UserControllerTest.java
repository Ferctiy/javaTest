package com.example.demo.controller;

import com.example.demo.model.UserModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class UserControllerTest {
    private UserModel userModel;

    private MockMvc mvc;

    public void init() {
        mvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
        userModel = new UserModel();
        userModel.setId("1");
        userModel.setName("1");
        userModel.setAge("1");
    }

    @Test
    public void login() {
    }

    @Test
    public void exit() throws Exception {

        mvc.perform(MockMvcRequestBuilders.get("/exit").accept(MediaType.APPLICATION_JSON).requestAttr("1","1"))
                .andExpect(status().isOk())
                .andExpect(content().string((equalTo("hello"))));
    }
}