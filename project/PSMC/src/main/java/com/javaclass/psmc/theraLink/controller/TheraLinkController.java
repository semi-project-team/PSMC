package com.javaclass.psmc.theraLink.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaclass.psmc.auth.model.dto.MyPatientDTO;
import com.javaclass.psmc.common.model.method.MakePhoneNumber;

import com.javaclass.psmc.theraLink.model.dto.MessageDTO;
import com.javaclass.psmc.theraLink.model.dto.TheraLinkForChatDTO;
import com.javaclass.psmc.theraLink.model.dto.TheraLinkWithMonthDTO;
import com.javaclass.psmc.user.model.dto.LoginUserDTO;
import com.javaclass.psmc.user.model.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Controller
public class TheraLinkController {

    private final UserService userService;
    private final ObjectMapper objectMapper;

    private MakePhoneNumber makePhoneNumber=new MakePhoneNumber();
    @Autowired
    public TheraLinkController(UserService userService,ObjectMapper objectMapper){

        this.objectMapper=objectMapper;
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


    @GetMapping("/theraLink/open/{projectNo}/deleteTheraLink")
    public String deleteTheraLink(@RequestParam List<Integer> theraNo,@PathVariable int projectNo){


        System.out.println("왜 여기로 안오지");
        System.out.println("theraNo = " + theraNo);

        Map<String,List<Integer>> theraNos = new HashMap<>();
        theraNos.put("thera",theraNo);
        int result = userService.deleteThearLink(theraNos);

        return "redirect:/theraLink/open/"+projectNo;
    }

    @PostMapping(value = "/theraLink/blog",produces = "application/json; charset=UTF-8")
    @ResponseBody
    public TheraLinkForChatDTO showblog(@RequestBody String theraNum,HttpSession session) throws JsonProcessingException {
        System.out.println("theraNum = " + theraNum);

        JsonNode jsonNode = objectMapper.readTree(theraNum);
        String theraNo = jsonNode.get("theraNum").asText();


        TheraLinkForChatDTO theraChat = userService.getTheraChatBytheraNo(theraNo);


        System.out.println(theraChat.getTheraTitle());
        if(!Objects.isNull(theraChat)) {
            String pmCode = ((LoginUserDTO) session.getAttribute("auth")).getPmCode();
            theraChat.setMe(pmCode);
            System.out.println("theraChat = " + theraChat);

        }
        return theraChat;

    }

    @PostMapping(value = "/theraLink/addMessage",produces = "application/json; charset=UTF-8")
    @ResponseBody
    public TheraLinkForChatDTO makeChat(@RequestBody MessageDTO messageDTO,HttpSession session){
        System.out.println("messageDTO = " + messageDTO);

        messageDTO.setPmCode(((LoginUserDTO)session.getAttribute("auth")).getPmCode());
        messageDTO.setTheraChatDate(LocalDateTime.now());
        int result = userService.makeTheraChat(messageDTO);

            TheraLinkForChatDTO theraLinkForChatDTO=userService.getTheraChatBytheraNo(messageDTO.getTheraNum());
            theraLinkForChatDTO.setMe(messageDTO.getPmCode());

        System.out.println("theraLinkForChatDTO 왜 두개가 나오지 = " + theraLinkForChatDTO);

            return theraLinkForChatDTO;
    }
}
