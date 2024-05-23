package com.psmc.staff.configuration;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping(value = {"/",  "/main"})
    public String main(Model model) {


        return "/employee/list";
    }
}
