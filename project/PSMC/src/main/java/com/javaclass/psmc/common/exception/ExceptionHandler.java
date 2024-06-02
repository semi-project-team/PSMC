package com.javaclass.psmc.common.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.format.DateTimeParseException;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(DateTimeParseException.class)
    public String nullPoint(HttpServletRequest request){

        String noDate = "날짜를 입력하세요";
        request.setAttribute("url",request.getRequestURI());
        request.setAttribute("message",noDate);


        return "forward:/error/date";

    }


}
