package com.glsid.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class BourseRestService {

    @Value("${me}")
    private String message;
    @GetMapping("/message")
    public String tellMe(){
        System.out.println("------------------------");
        System.out.println("c'est moi qui repond");
        System.out.println("------------------------");
        return message;
    }
}
