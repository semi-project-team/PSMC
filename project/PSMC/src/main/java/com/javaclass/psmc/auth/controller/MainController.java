package com.javaclass.psmc.auth.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping(value={"/","/main"})
    public String main(){


        return "/main";
    }


    @GetMapping("/common/signal")
    public void signal(Model model,HttpSession httpSession){
        model.addAttribute("message",httpSession.getAttribute("message"));
    }
}
