package com.in28minuts.springboot.web.springbootfirstwebaplication.controller;

import com.in28minuts.springboot.web.springbootfirstwebaplication.services.LoginService;
import com.in28minuts.springboot.web.springbootfirstwebaplication.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Date;


@Controller
@SessionAttributes("name")
public class ToDoController {

    @Autowired
    TodoService todoService;

    @RequestMapping(value = "/list-todos", method = RequestMethod.GET)
    public String showTodos(ModelMap model) {
        String name = (String) model.get("name");
        model.put("todos", todoService.retrieveTodos("Jackson"));
        return "list-todos";
    }

    @RequestMapping(value = "/add-todos", method = RequestMethod.GET)
    public String todos(ModelMap model) {
        return "todo";
    }

    @RequestMapping(value = "/add-todos", method = RequestMethod.POST)
    public String addTodos(ModelMap model, @RequestParam String desc) {
        todoService.addTodo((String) model.get("name"), desc, new Date(), false);
        return "redirect:/list-todos";
    }

    @RequestMapping(value = "/list-todos-other-user", method = RequestMethod.GET)
    public String listTodosOtherUser(ModelMap model) {
        return "list-todo-other-user";
    }

    @RequestMapping(value = "/list-todos-other-user", method = RequestMethod.POST)
    public String showOtherUserTodos(ModelMap model, @RequestParam String otheruser) {
        model.put("todos", todoService.retrieveTodos(otheruser));
        model.put("name", otheruser);
        return "list-todos";
    }
}


