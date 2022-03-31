package com.in28minuts.springboot.web.springbootfirstwebaplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @RequestMapping("/login")
    private String loginMessage(){
        return "login";
    }
}
