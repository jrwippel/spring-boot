package com.in28minuts.springboot.web.springbootfirstwebaplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController {

    @RequestMapping("/login")
    public String loginMessage(){
        return "login";
    }

    @RequestMapping("/access")
    public String accessMessage(@RequestParam String name, ModelMap modelMap){
        modelMap.put("name", name);
        return "access";
    }
}
