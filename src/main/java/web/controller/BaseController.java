package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BaseController {

    @GetMapping("/")
    public String printWelcome() {
        List<String> messages = new ArrayList<>();
        messages.add("Hello!");

        //model.addAttribute("messages", messages);
        return "mainPage";
    }
}
