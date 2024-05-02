package com.javaclass.psmc.user.controller;


import com.javaclass.psmc.user.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/user")
public class UserController {

    private UserService userService;
    @Autowired
    public UserController(UserService userService){
        this.userService=userService;
    }

    @GetMapping("/signup")
    public String term(){
        return "member/term";
    }






}
