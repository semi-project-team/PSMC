package com.javaclass.psmc.mainPage.model.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EditController {

    @GetMapping("/edit")
    public String edit() {
        return "/mypage/edit";
    }


}
