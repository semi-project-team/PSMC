package com.javaclass.psmc.auth.controller;

import com.javaclass.psmc.common.model.dto.EmployeeDTO;
import com.javaclass.psmc.user.model.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    @Autowired
    public AuthController(UserService userService){
        this.userService=userService;
    }
    @GetMapping("/login")
    public String login(){
        return "/main";
    }

    @GetMapping("/fail")
    public ModelAndView loginFail(ModelAndView mv,@RequestParam String message){
        mv.addObject("message",message);
        mv.setViewName("/auth/fail");
        return mv;
    }

    @PostMapping("/takeCode")
    public String takeCode(@RequestParam String pmCode, @RequestParam String empNo, Model model, HttpSession httpSession){
        System.out.println("여기로는 오기는 하냐");
        Map<String,String> param = new HashMap<>();
        param.put("pmCode",pmCode);
        param.put("empNo",empNo);
        List<EmployeeDTO> employee = userService.findMember(param);

        if(employee.isEmpty()){
            model.addAttribute("message","코드를 잘못입력하셨습니다. 다시 입력하세요");
            return "redirect:/member/takeCode";

        }
        else{
            httpSession.setAttribute("employeeInfo",employee.get(0));
            return "redirect:/member/registerReq";


        }
    }

}
