package com.javaclass.psmc.common.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Enumeration;
@Controller
@RequestMapping("/error")
public class ExceptionController {

    @GetMapping("/date")
    public String sendNullMessage(HttpServletRequest request){
        System.out.println("왜 여기로는 안와?");

        String message = (String) request.getAttribute("message");
        System.out.println("message = " + message);
        String url = (String) request.getAttribute("url");
        System.out.println("url = " + url);
        String newURL = url.split("/")[1];
        System.out.println("newURL = " + newURL);
        return "forward:/"+newURL;
    }
}
