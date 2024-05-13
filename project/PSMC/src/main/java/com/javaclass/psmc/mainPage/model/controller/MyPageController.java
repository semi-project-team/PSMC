package com.javaclass.psmc.mainPage.model.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyPageController {

    @GetMapping("/mypage/mypage")
    public void mypage(){}
}
