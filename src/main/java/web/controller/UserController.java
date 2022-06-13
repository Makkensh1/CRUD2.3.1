package web.controller;

import Exceptions.NoEntityException;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import services.UserServiceImpl;
import javax.servlet.annotation.WebServlet;

@Controller
@RequestMapping(value ="/users")
@WebServlet("/webapp")
public class UserController {
    @Autowired
    UserServiceImpl peopleService;

    @GetMapping(value = "/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "users/new";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") User user) {
        peopleService.addUser(user);
        return "users/userCreateSuccess";
    }


    @GetMapping(value ="/{id}")
    public String showUser(@PathVariable("id") long id, Model model) {

        try {
            User user = peopleService.getUser(id);
            model.addAttribute("User", user);
            return "users/userProfile";
        } catch (NoEntityException e) {
            model.addAttribute("User", id);
            return "users/DontExistUSer";
        }

    }
}
