package com.javaclass.psmc.auth.controller;

import com.javaclass.psmc.auth.model.AuthDetails;
import com.javaclass.psmc.common.model.dto.EmployeeDTO;
import com.javaclass.psmc.user.model.dto.LoginUserDTO;
import com.javaclass.psmc.user.model.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;



    @Autowired
    public AuthController(UserService userService){
        this.userService=userService;
    }
    @GetMapping("/login")
    public String login(HttpSession session){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AuthDetails authDetails = (AuthDetails) authentication.getPrincipal();
        session.setAttribute("auth",authDetails.getLoginUserDTO());

        return "/auth/login";
    }

    @GetMapping("/fail")
    public ModelAndView loginFail(ModelAndView mv,@RequestParam String message){
        mv.addObject("message",message);
        mv.setViewName("/auth/fail");
        return mv;
    }

    @PostMapping("/takeCode")
    public String takeCode(@RequestParam String pmCode, @RequestParam String empNo, HttpSession httpSession){
        Map<String,String> param = new HashMap<>();
        param.put("pmCode",pmCode);
        param.put("empNo",empNo);
        List<EmployeeDTO> employee = userService.findMember(param);
        System.out.println("takeCode 여기");
        if(employee.isEmpty()){
            httpSession.setAttribute("message","잘못된 코드입니다. 코드를 확인하세요");
            return "redirect:/member/takeCode";

        }
        else{
            LoginUserDTO loginUserDTO = userService.findMemberByPmCode(employee.get(0).getPmCode());
            httpSession.setAttribute("employeeInfo",employee.get(0));
            if(!Objects.isNull(loginUserDTO)){
                httpSession.setAttribute("message","이미 가입한 사원입니다");
                return "redirect:/member/takeCode";

            }
            else{

                return "redirect:/member/registerReq";
            }

        }

    }



}
