package com.test.controller;

import com.test.exceptions.NoEntityException;
import com.test.model.User;
import com.test.services.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.annotation.WebServlet;
import java.sql.SQLException;

@Controller
@RequestMapping(value = "/users")
@Slf4j
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
        try {
            userService.addUser(user);
            log.info("User created", user.getEmail());
            return "users/userCreateSuccess";
        } catch (SQLException e) {
            return  null; //TODO добавить страницу с ошибкой
        }

    }


    @GetMapping(value = "/{id}")
    public String showUser(@PathVariable("id") long id, @NotNull Model model) throws NoEntityException {
            User user = userService.getUser(id);
            model.addAttribute("user", user);
            return "users/userProfile";
    }
}