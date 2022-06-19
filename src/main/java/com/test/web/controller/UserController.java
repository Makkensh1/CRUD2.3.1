package com.test.web.controller;

import com.test.exceptions.NoEntityException;
import com.test.model.User;
import com.test.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.annotation.WebServlet;

@Controller
@RequestMapping(value = "/users")
@WebServlet("/webapp")
@ComponentScan(value = "services")
public class UserController {
    private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/new")
    public String newUser(@ModelAttribute("user") User user) {
//        model.addAttribute("user", new User());
//        System.out.println("создание пользователя инициировано");
        return "users/new";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        System.out.println("Пользователь создан");
        return "users/userCreateSuccess";
    }


    @GetMapping(value = "/{id}")
    public String showUser(@PathVariable("id") long id, Model model) {

        try {
            model.addAttribute("user", userService.getUser(id));
            return "users/userProfile";
        } catch (NoEntityException e) {
            model.addAttribute("User", id);
            return "users/DontExistUSer";
        }

    }
}
