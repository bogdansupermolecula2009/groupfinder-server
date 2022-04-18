package ru.heavyproject.groupfinder.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.heavyproject.groupfinder.server.entities.User;

@Controller
@RequestMapping ("/registration")
public class RegistrationController {

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

}
