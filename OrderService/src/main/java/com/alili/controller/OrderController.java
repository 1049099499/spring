package com.alili.controller;

import com.alili.BookInfo;
import com.alili.OrderInfo;
import com.alili.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
public class OrderController {
    @Autowired
    RestTemplate template;

    OrderInfo orderInfo=new OrderInfo("1","1","1");

    private Map<String,OrderInfo> orderInfos=new HashMap<>(){
        {put(orderInfo.getId(),orderInfo); }
    };

    @GetMapping("orderInfo/{id}")
    public String getOrderInfo(@PathVariable String id){
        OrderInfo orderInfo=orderInfos.get("1");
        BookInfo bookInfo=template.getForObject("http://bookService/bookInfo/"+orderInfo.getBookId(),BookInfo.class);
        UserInfo userInfo=template.getForObject("http://userService/userInfo/"+orderInfo.getUserId(),UserInfo.class);
        return  userInfo.getName()+"借阅"+bookInfo.getName();
    }
}
