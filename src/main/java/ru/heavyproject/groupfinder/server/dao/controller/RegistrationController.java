package ru.heavyproject.groupfinder.server.dao.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.heavyproject.groupfinder.server.entities.User;
import ru.heavyproject.groupfinder.server.service.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping ("/")
@Slf4j
public class RegistrationController {

    @Autowired
    UserService userService;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String registrationPost (@ModelAttribute("userForm") @Valid User user, BindingResult result) {
        UserDetails userFromBase = userService.loadUserByUsername(user.getUsername());
        if (userFromBase != null) {
            result.rejectValue("username", null, "There is already an account registered with that user name");
        }

        if (result.hasErrors()) {
            return "registration";
        }

        userService.save(user);
        return "redirect:/login";

    }

}
