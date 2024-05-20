package com.javaclass.psmc.theraLink.controller;

import com.javaclass.psmc.auth.model.dto.MyPatientDTO;
import com.javaclass.psmc.common.model.method.MakePhoneNumber;

import com.javaclass.psmc.theraLink.model.dto.TheraLinkWithMonthDTO;
import com.javaclass.psmc.user.model.dto.LoginUserDTO;
import com.javaclass.psmc.user.model.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TheraLinkController {

    private final UserService userService;

    private MakePhoneNumber makePhoneNumber=new MakePhoneNumber();
    @Autowired
    public TheraLinkController(UserService userService){

        this.userService = userService;
    }

    @GetMapping("/theraLink")
    public String goFirstPage(HttpSession session, Model model, @PageableDefault(size = 5)Pageable pageable){

        LoginUserDTO loginUserDTO = (LoginUserDTO) session.getAttribute("auth");
        String pmCode = loginUserDTO.getPmCode();
        Map<String,Object> sender = new HashMap<>();
        sender.put("pmCode",pmCode);

        if(pmCode.charAt(0)=='d'){
            sender.put("role","doctor");
        }else{
            sender.put("role","thera");
        }
        List<MyPatientDTO> myPatients = userService.myPatient(sender);



        /*번호 원하는 형태로 format*/
        for(MyPatientDTO p : myPatients){
            p.setPhone(makePhoneNumber.formatPhoneNumber(p.getPhone()));
        }

        model.addAttribute("patients",myPatients);


        return "theraLink/firstPage";
    }

    @GetMapping("/theraLink/open/{projectNo}")
    public String goSecondPage(@PathVariable int projectNo,Model model){

        System.out.println("projectNo = " + projectNo);

        List<TheraLinkWithMonthDTO> theraLinkWithMonthDTOS = userService.findAllTheraLinkByProjectNo(projectNo);

        for(TheraLinkWithMonthDTO t : theraLinkWithMonthDTOS){
            System.out.println("theraLink data 확인중 = " + t);
            t.setDay(t.getTheraBoardDate().toString().split("-")[2]);
            System.out.println("t.getDay() = " + t.getDay());
        }

        model.addAttribute("theraLink",theraLinkWithMonthDTOS);

        return "/theraLink/secondPage";
    }
}
