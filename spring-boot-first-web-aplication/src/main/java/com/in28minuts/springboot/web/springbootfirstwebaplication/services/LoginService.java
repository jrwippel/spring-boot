package com.in28minuts.springboot.web.springbootfirstwebaplication.services;

import org.springframework.stereotype.Component;

@Component
public class LoginService {

    public boolean isValidLogin(String name, String password){
        return name.equalsIgnoreCase("Jackson") && password.equals("teste");
    }
}
