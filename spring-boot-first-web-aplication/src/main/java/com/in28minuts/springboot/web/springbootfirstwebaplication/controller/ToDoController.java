package com.in28minuts.springboot.web.springbootfirstwebaplication.controller;

import com.in28minuts.springboot.web.springbootfirstwebaplication.model.Todo;
import com.in28minuts.springboot.web.springbootfirstwebaplication.services.LoginService;
import com.in28minuts.springboot.web.springbootfirstwebaplication.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomBooleanEditor;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
@SessionAttributes("name")
public class ToDoController {

    @Autowired
    TodoService todoService;

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));


    }

    @RequestMapping(value = "/list-todos", method = RequestMethod.GET)
    public String showTodos(ModelMap model) {
        String name = getLoggedInUserName(model);
        model.put("todos", todoService.retrieveTodos("Jackson"));
        return "list-todos";
    }

    private String getLoggedInUserName(ModelMap model) {
        return getName(model);
    }

    private String getName(ModelMap model) {
        return (String) model.get("name");
    }

    @RequestMapping(value = "/add-todos", method = RequestMethod.GET)
    public String todos(ModelMap model) {
        model.addAttribute("todo", new Todo(0, getLoggedInUserName(model), "Default desc", new Date(), false));
        return "todo";
    }

    @RequestMapping(value = "/add-todos", method = RequestMethod.POST)
    public String addTodos(ModelMap model, @Valid Todo todo, BindingResult result) {

        if (result.hasErrors()){
            return "todo";
        }
        todoService.addTodo(getLoggedInUserName(model), todo.getDesc(), todo.getTargetDate(), false);
        return "redirect:/list-todos";
    }
    @RequestMapping(value = "/delete-todos", method = RequestMethod.GET)
    public String deleteTodos(@RequestParam Integer id) {
        todoService.deleteTodo(id);
        return "redirect:/list-todos";
    }

    @RequestMapping(value = "/update-todos", method = RequestMethod.GET)
    public String ShowUpdateTodoPage(@RequestParam Integer id, ModelMap modelMap) {
        Todo todo = todoService.retrieveTodo(id);
        modelMap.put("todo", todo );
        return "todo";
    }
    @RequestMapping(value = "/update-todos", method = RequestMethod.POST)
    public String updateTodos(ModelMap model, @Valid Todo todo, BindingResult result) {

        if (result.hasErrors()){
            return "todo";
        }
        todo.setUser((String) model.get("name"));

        todoService.updateTodo(todo);
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


