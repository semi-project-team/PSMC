package com.javaclass.psmc.mainPage.model.controller;

import com.javaclass.psmc.common.model.dto.MediInfoDTO;
import com.javaclass.psmc.common.model.dto.MenuDTO;
import com.javaclass.psmc.common.model.method.MenuHandling;
import com.javaclass.psmc.mainPage.model.dto.TodayMenuDTO;
import com.javaclass.psmc.user.model.dto.LoginUserDTO;
import com.javaclass.psmc.user.model.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Map;

@Controller
public class MyPageController {

    private MenuHandling menuHandling = new MenuHandling();

    private final UserService userService;
    @Autowired
    public MyPageController(UserService userService){
        this.userService=userService;
    }

    @GetMapping("/mypage/mypage")
    public void mypage(){}

    @GetMapping(value = "/todayMenu",produces = "application/json; charset=UTF-8")
    @ResponseBody
    public TodayMenuDTO menus(){
        System.out.println("메뉴 비동 컨트롤러");
        LocalDateTime today = LocalDateTime.now();

        int day = userService.findDayNo(today.toString());

        TodayMenuDTO menus = userService.menu(day);
        menus.setDate(menuHandling.getDate());


        return menus;


    }
    @GetMapping(value = "minusday",produces = "application/json; charset=UTF-8")
    @ResponseBody
    public TodayMenuDTO minus(){
        int day = menuHandling.minusDay();
        TodayMenuDTO menus = userService.menu(day);
        menus.setDate(menuHandling.getDate());
        return menus;
    }
    @GetMapping(value = "/plusday", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public TodayMenuDTO plus(){
        int day = menuHandling.plusDay();
        TodayMenuDTO menus = userService.menu(day);
       
        menus.setDate(menuHandling.getDate());

        return menus;
    }

    @PostMapping("/reservation")
    public String reservation(@RequestParam Map<String,String> parameters, HttpSession session){
        String pmCode = ((LoginUserDTO)session.getAttribute("auth")).getPmCode();
        int result=0;
        String message="";
        if(pmCode.charAt(0)=='d'){
            MediInfoDTO mediInfoDTO = new MediInfoDTO();
            System.out.println(parameters.get("projectNo"));
            System.out.println(parameters.get("date"));
            System.out.println(parameters.get("timeCode"));
            System.out.println(parameters.get("contents"));
            mediInfoDTO.setProjectNo(Integer.parseInt(parameters.get("projectNo")));
            mediInfoDTO.setTimeCode(Integer.parseInt(parameters.get("timeCode")));
            mediInfoDTO.setMediDate(Date.valueOf(parameters.get("date")));
            mediInfoDTO.setMediRegDate(LocalDateTime.now());


            result = userService.makeMediInfo(mediInfoDTO);


        }else{



        }

        if(result>0){
            message="예약 등록 했습니다";
        }
        else{
            message="예약 등록에 실패했습니다";
        }

        session.setAttribute("reservationMessage",message);


        return "redirect:/auth/mainPage";
    }



}
