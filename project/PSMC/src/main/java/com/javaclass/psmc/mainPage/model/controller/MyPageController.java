package com.javaclass.psmc.mainPage.model.controller;

import com.javaclass.psmc.common.model.dto.MenuDTO;
import com.javaclass.psmc.user.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

@Controller
public class MyPageController {

    private final UserService userService;
    @Autowired
    public MyPageController(UserService userService){
        this.userService=userService;
    }

    @GetMapping("/mypage/mypage")
    public void mypage(){}

    @GetMapping(value = "/todayMenu",produces = "application/json; charset=UTF-8")
    @ResponseBody
    public MenuDTO menus(){
        System.out.println("메뉴 비동 컨트롤러");
        LocalDateTime today = LocalDateTime.now();

        MenuDTO menus = userService.menu(today.toString());
        System.out.println(menus);

        return menus;


    }

}
