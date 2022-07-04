package com.test.controller;

import com.test.exceptions.NoEntityException;
import com.test.model.User;
import com.test.services.UserServiceImpl;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.annotation.WebServlet;

@Controller
@RequestMapping(value = "/users")
public class UserController {
    private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/new")
    public String newUser(@ModelAttribute("user") User user) {
        System.out.println("создание пользователя инициировано");
        return "users/new";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        System.out.println("Пользователь создан");
        return "users/userCreateSuccess";
    }


    @GetMapping(value = "/{id}")
    public String showUser(@PathVariable("id") long id, @NotNull Model model) throws NoEntityException {
            User user = userService.getUser(id);
            model.addAttribute("user", user);
            return "users/userProfile";
    }
}