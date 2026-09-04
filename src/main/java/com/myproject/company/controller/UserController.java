package com.myproject.company.controller;

import com.myproject.company.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String showLoginPage() {
        return "frmLogin";
    }

    // إضافة Mapping خاص بالصفحة الرئيسية
    @GetMapping("/main")
    public String showMainPage() {
        return "frmMain";
    }

    @PostMapping("/login")
    public String handleLogin(@RequestParam("username") String UserName,
                              @RequestParam("password") String Password) {

        boolean isSuccess = userService.login(UserName, Password);

        if (isSuccess) {
            return "redirect:/main"; // التوجيه المباشر إلى /main
        }

        return "redirect:/login?error=true";
    }
}