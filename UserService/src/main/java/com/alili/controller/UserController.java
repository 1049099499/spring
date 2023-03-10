package com.alili.controller;

import com.alili.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    ApplicationContext context;

    @Value("${email}")
    private  String email;

    @GetMapping("config/{configKey}")
    public  String GetConfig(@PathVariable String configKey){
        return context.getEnvironment().getProperty(configKey)+"的email是："+email;
    }

    @GetMapping("userInfo/{id}")
    public  UserInfo getUserInfo(@PathVariable String id){
        UserInfo userInfo =  new UserInfo();
        userInfo.setId("1");
        userInfo.setName("alili");
        return  userInfo;
    }
}
