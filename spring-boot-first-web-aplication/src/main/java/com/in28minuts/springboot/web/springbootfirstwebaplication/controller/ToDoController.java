package com.in28minuts.springboot.web.springbootfirstwebaplication.controller;

import com.in28minuts.springboot.web.springbootfirstwebaplication.services.LoginService;
import com.in28minuts.springboot.web.springbootfirstwebaplication.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ToDoController {

    @Autowired
    TodoService todoService;


    @RequestMapping(value="/list-todos", method = RequestMethod.GET)
    public String showTodos(ModelMap model){
        model.put("todos", todoService.retrieveTodos("in28Minutes"));
        return "list-todos";
    }


}
