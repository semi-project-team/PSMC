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


        String message = (String) request.getAttribute("message");

        String url = (String) request.getAttribute("url");

        String newURL = url.split("/")[1];

        return "forward:/"+newURL;
    }
}
