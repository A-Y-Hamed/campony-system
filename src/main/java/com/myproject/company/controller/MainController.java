package com.myproject.company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/home")
    public String showMainPage() {
        return "main"; // يفتح ملف main.html
    }

}