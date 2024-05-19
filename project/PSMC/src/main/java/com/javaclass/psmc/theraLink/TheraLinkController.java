package com.javaclass.psmc.theraLink;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TheraLinkController {

    @GetMapping("/theraLink")
    public String goFirstPage(){

        return "/theraLink/firstPage";
    }

    @GetMapping("/theraLink/open")
    public String goSecondPage(){
        return "/theraLink/secondPage";
    }
}
