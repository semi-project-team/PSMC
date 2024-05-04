package com.javaclass.psmc.user.controller;

import com.javaclass.psmc.common.model.dto.EmployeeDTO;
import com.javaclass.psmc.user.model.dto.IdDTO;
import com.javaclass.psmc.user.model.dto.SignupDTO;
import com.javaclass.psmc.user.model.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/member")
@Controller
public class RegisterController {

    private final UserService userService;
    private final HttpSession httpSession;

    @Autowired
    public RegisterController(UserService userService, HttpSession httpSession){
        this.userService=userService;
        this.httpSession = httpSession;
    }





    @GetMapping("/takeCode")
    public void stepTwo(){

    }

    @GetMapping("/registerReq")
    public void registerReq(){}

    @PostMapping("/signup")
    public ModelAndView signup(@ModelAttribute SignupDTO signup, ModelAndView mv, HttpSession session){
        EmployeeDTO e = (EmployeeDTO) session.getAttribute("employeeInfo");
        System.out.println(e);
        signup.setPmCode(e.getPmCode());
        signup.setRole(e.getPmCode().charAt(0)+"");

        int result = userService.registMember(signup);
        String message ="";
        if (result > 0) {
            message="회원가입성공 했습니다";

        }
        else{
            message="회원가입에 실패했습니다";
        }
        mv.setViewName("redirect:/common/signal");
        session.setAttribute("message",message);

        return mv;
    }



}
