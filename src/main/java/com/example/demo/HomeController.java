package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
public class HomeController {

    @RequestMapping("/")
    public String home(){
        return "index";
    }

}