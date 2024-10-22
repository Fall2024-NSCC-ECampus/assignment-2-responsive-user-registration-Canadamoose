package com.example.assignment2.controller;

import com.example.assignment2.entity.User;
import com.example.assignment2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/index")
    public String addUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/users")
    public String getUsers(Model model) {
        model.addAttribute("getUsers", userService.getUsers());
        return "users";
    }

    @GetMapping("/index")
    public String user(Model model) {
        model.addAttribute("addUser", new User());
        return "index";
    }
}
