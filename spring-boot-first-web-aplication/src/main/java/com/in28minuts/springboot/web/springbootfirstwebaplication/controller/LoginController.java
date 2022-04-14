package com.in28minuts.springboot.web.springbootfirstwebaplication.controller;

import com.in28minuts.springboot.web.springbootfirstwebaplication.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("name")
public class LoginController {

    @Autowired
    LoginService loginService = new LoginService();


    @RequestMapping(value="/", method = RequestMethod.GET)
    public String showLoginPage(ModelMap model){
        model.put("name", "Jackson");
        return "welcome";
    }

}
