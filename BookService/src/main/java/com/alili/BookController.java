package com.alili;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RefreshScope
@EnableDiscoveryClient
public class BookController {

    BookInfo book=new BookInfo("1","《Spring cloud从入门到上天》");

    private Map<String,BookInfo> books=new HashMap<>(){
        {put("1",book); }
    };

    @GetMapping("bookInfo/{id}")
    public  BookInfo getBookBorrowInfo(@PathVariable String id){
        BookInfo bookInfo= books.get(id);
       return  bookInfo;
    }
}
