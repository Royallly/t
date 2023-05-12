package com.sutest512.controller;

import com.sutest512.entity.User;
import com.sutest512.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")
public class HelloController {

    @Autowired
    private UserService userService;

    @GetMapping("/isSpringStarted")
    public String hello() {
        return "Started";
    }


    @GetMapping("/user-list")
    public String userList(Model model) {
        List<User> userList = userService.findAll();
        model.addAttribute("userList", userList);
        return "testFront";
    }

}
