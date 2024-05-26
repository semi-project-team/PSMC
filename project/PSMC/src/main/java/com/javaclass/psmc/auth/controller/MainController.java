package com.javaclass.psmc.auth.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaclass.psmc.auth.model.dto.FindIdDTO;
import com.javaclass.psmc.auth.model.dto.FindPasswordDTO;
import com.javaclass.psmc.auth.model.dto.MailTo;
import com.javaclass.psmc.auth.model.service.MailService;
import com.javaclass.psmc.user.model.dto.LoginUserDTO;
import com.javaclass.psmc.user.model.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@Controller
public class MainController {

    private final UserService userService;
    private final MailService mailService;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    public MainController(UserService userService,MailService mailService,PasswordEncoder passwordEncoder){
        this.userService=userService;
        this.mailService=mailService;
        this.passwordEncoder=passwordEncoder;
    }

    @GetMapping(value={"/","/main"})
    public String main(HttpSession session,Model model){

        String message = (String) session.getAttribute("message");
        session.removeAttribute("message");
        model.addAttribute("message",message);


        return "/main";
    }


    @GetMapping("/common/signal")
    public void signal(Model model,HttpSession httpSession){
        model.addAttribute("message",httpSession.getAttribute("message"));
        httpSession.removeAttribute("message");
    }

    @PostMapping(value = "/finddingId",produces = "application/json; charset=UTF-8")
    @ResponseBody
    public ResponseEntity<Map<String,String>> findId(@RequestBody FindIdDTO findIdDTO){
        LoginUserDTO loginUserDTO = userService.findId(findIdDTO);

        String id = null;
        Map<String,String> response =new HashMap<>();
        if(!Objects.isNull(loginUserDTO)) {
            id = loginUserDTO.getId();
            response.put("userId",id);
        }else{
            response.put("userId","User ID not found");
        }



        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/sendEmail")
    public String findPassword(@ModelAttribute FindPasswordDTO findPasswordDTO,HttpSession session){


        LoginUserDTO log = new LoginUserDTO();
        log = userService.findMemberForPassword(findPasswordDTO);
        String message = null;

        if(!Objects.isNull(log)) {
            MailTo mailTo = new MailTo();
            mailTo.setAddress(findPasswordDTO.getEmail());
            String title = "안녕하세요 PSMC 입니다 변경된 비밀번호로 로그인후 비밀번호를 변경하세요";

            mailTo.setTitle(title);
            String newPass = UUID.randomUUID().toString();
            mailTo.setMessage("비밀번호 : " + newPass);

            String transPass = passwordEncoder.encode(newPass);

            mailService.sendMail(mailTo);
            log.setPassword(transPass);

            int result= userService.updatePassword(log);

            message = "입력하신 이메일로 새로운 비밀번호를 전송 했습니다";
        }
        else{
            message = "입력하신 데이터의 사원은 존재하지 않습니다 입력값을 확인하세요";
        }

        session.setAttribute("message",message);

        return "redirect:/main";
    }


}
