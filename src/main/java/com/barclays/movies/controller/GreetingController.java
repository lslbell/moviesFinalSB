package com.barclays.movies.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/greeting")
public class GreetingController {

    @GetMapping
    public String get(Model model) {
        model.addAttribute("message", "Lewis");

        return "greeting";
    }

}
