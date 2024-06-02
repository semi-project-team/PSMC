package com.javaclass.psmc.mainPage.model.controller;

import com.javaclass.psmc.common.model.method.MakePhoneNumber;
import com.javaclass.psmc.mypage.model.dto.ChangePassWordDTO;
import com.javaclass.psmc.user.model.dto.LoginUserDTO;
import com.javaclass.psmc.user.model.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ChangeController {


    private final PasswordEncoder passwordEncoder;
    private final UserService userService;


    @Autowired
    public ChangeController(PasswordEncoder passwordEncoder,UserService userService){
        this.userService=userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/change")
    public String change(HttpSession session, Model model) {

        String message = (String) session.getAttribute("message");
        session.removeAttribute("message");
        model.addAttribute("message",message);
        return "mypage/change";
    }


    @PostMapping("/changePassWord")
    public String changePass(@ModelAttribute ChangePassWordDTO changePassWordDTO, HttpSession session){

        LoginUserDTO loginUserDTO = (LoginUserDTO) session.getAttribute("auth");



        String id = changePassWordDTO.getUserId();
        String checkid = loginUserDTO.getId();


        if(!id.equals(checkid)){
            session.setAttribute("message","아이디가 일치 하지 않습니다");
            return "redirect:/change";
        }


        boolean valid = passwordEncoder.matches(changePassWordDTO.getCurrentPassword(),loginUserDTO.getPassword());
        if(!valid){
            session.setAttribute("message","비밀번호가 일치하지 않습니다");
            return "redirect:/change";
        }

        if(!changePassWordDTO.getNewPassword().equals(changePassWordDTO.getConfirmPassword())){
            session.setAttribute("message","변경한 비밀번호가 일치하지 않습니다");
            return "redirect:/change";
        }

        loginUserDTO.setPassword(passwordEncoder.encode(changePassWordDTO.getNewPassword()));

        int result = userService.updatePassword(loginUserDTO);


        if(!(result>0)){
            session.setAttribute("message","비밀번호 변경에 실패했습니다");
            return "redirect:/change";
        }

        session.setAttribute("message","비밀번호 변경에 성공했습니다");


        return "redirect:/mypage/mypage";


    }

}
