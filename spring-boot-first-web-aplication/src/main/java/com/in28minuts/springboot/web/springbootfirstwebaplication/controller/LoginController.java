package com.in28minuts.springboot.web.springbootfirstwebaplication.controller;

import com.in28minuts.springboot.web.springbootfirstwebaplication.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController {

    @Autowired
    LoginService loginService = new LoginService();


    @RequestMapping(value="/access", method = RequestMethod.GET)
    public String showLoginPage(ModelMap model){
        return "access";
    }

    @RequestMapping(value = "/access", method = RequestMethod.POST)
    public String accessMessage(ModelMap modelMap, @RequestParam String name, @RequestParam String password){

        if (loginService.isValidLogin(name, password)){
            modelMap.put("name", name);
            modelMap.put("password", password);
            return "welcome";
        }else{
            modelMap.put("errorMessage", "Invalid Credentials");
            return "access";
        }
    }
}
