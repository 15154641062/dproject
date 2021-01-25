package com.bh.dproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/branch")
public class TestController {
    @GetMapping("/test")
    public String test(){
        return "success";
    }
}
