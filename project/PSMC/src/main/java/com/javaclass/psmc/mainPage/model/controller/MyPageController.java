package com.javaclass.psmc.mainPage.model.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaclass.psmc.common.model.dto.MediInfoDTO;
import com.javaclass.psmc.common.model.dto.TheraInfoDTO;
import com.javaclass.psmc.common.model.method.FindTimeCode;
import com.javaclass.psmc.common.model.method.MenuHandling;
import com.javaclass.psmc.mainPage.model.dto.*;
import com.javaclass.psmc.user.model.dto.LoginUserDTO;
import com.javaclass.psmc.user.model.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.sql.Date;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MyPageController {

    private MenuHandling menuHandling = new MenuHandling();
    private ObjectMapper objectMapper;
    private FindTimeCode findTimeCode = new FindTimeCode();

    private final UserService userService;
    @Autowired
    public MyPageController(UserService userService,ObjectMapper objectMapper){
        this.userService=userService;
        this.objectMapper=objectMapper;
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

            if(result>0){
                message="예약 등록 했습니다";
            }
            else{
                message="예약 등록에 실패했습니다";
            }


        }else{
            System.out.println(parameters.get("projectNo"));
            System.out.println(parameters.get("date"));
            System.out.println(parameters.get("contents"));
            System.out.println(parameters.get("start"));
            System.out.println(parameters.get("end"));

            LocalTime start = LocalTime.parse(parameters.get("start"));
            LocalTime end = LocalTime.parse(parameters.get("end"));


            Map<String,Object> sender = new HashMap<>();
            sender.put("pmCode",pmCode);
            sender.put("date",parameters.get("date"));
            sender.put("start",parameters.get("start"));
            sender.put("end",parameters.get("end"));
            List<TodayAllTheraDTO> todayThera = userService.checkTheraByStartAndEnd(sender);

            List<Integer> timecode = findTimeCode.CantTimeCode(start,end);

            List<TodayAllMediDTO> todayMedi = new ArrayList<>();
            if(!timecode.isEmpty()){
                sender.put("code",timecode);
                sender.put("projectNo",parameters.get("projectNo"));
                todayMedi = userService.todayMediByPRNo(sender);
            }





            if(todayThera.isEmpty() && todayMedi.isEmpty()){

                TheraInfoDTO theraInfoDTO = new TheraInfoDTO();
                theraInfoDTO.setTheraDate(Date.valueOf(parameters.get("date")));
                theraInfoDTO.setProjectNo(Integer.parseInt(parameters.get("projectNo")));
                theraInfoDTO.setTheraRegDate(LocalDateTime.now());
                System.out.println("이젠 시간 맞지?"+LocalTime.parse(parameters.get("start")));
                theraInfoDTO.setStart(LocalTime.parse(parameters.get("start")));
                theraInfoDTO.setEnd(LocalTime.parse(parameters.get("end")));
                result = userService.makeTheraInfo(theraInfoDTO);
                if(result>0){
                    message="예약 등록했습니다";

                }else{
                    message="예약등록에 실패했습니다";
                }
            }else{

                StringBuilder words = new StringBuilder();
                if(!todayThera.isEmpty()){
                    words.append("겹치는 재활일정 : \n");
                    for(TodayAllTheraDTO t : todayThera){
                    String timeRange = t.getStart() +" ~ " + t.getEnd();
                    words.append(timeRange+",");
                    }
                }
                if(!todayMedi.isEmpty()){
                    words.append("겹치는 치료일정 : \n");
                    for(TodayAllMediDTO m : todayMedi){
                        String timeRange = findTimeCode.startCode(m.getTimeCode()) +" ~ " +findTimeCode.endCode(m.getTimeCode()) ;
                        words.append(timeRange+",");
                    }
                }
                System.out.println("words = " + words);
                session.setAttribute("messages",words);

            }



        }


        session.setAttribute("reservationMessage",message);


        return "redirect:/auth/mainPage";
    }

    @PostMapping(value = "/sendAllMedi",produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<TodayAllMediDTO> checkTimeCode(@RequestBody String selectDate, HttpSession session) throws JsonProcessingException {
        System.out.println("selectDate = " + selectDate);
        JsonNode jsonNode =objectMapper.readTree(selectDate);
        String date = jsonNode.get("selectDate").asText();
        System.out.println("date 날짜 변환되었나= " + date);
        Map<String,String> parameter = new HashMap<>();
        parameter.put("date",date);
        String pmCode = ((LoginUserDTO)session.getAttribute("auth")).getPmCode();
        parameter.put("pmCode",pmCode);
        List<TodayAllMediDTO> todayAllMedi = userService.todayAllMedi(parameter);

        for (TodayAllMediDTO today : todayAllMedi){
            System.out.println("today 오늘 mediInfo 다 = " + today);
        }
        return todayAllMedi;
    }
    @PostMapping(value = "/sendThera",produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<TodayAllTheraDTO> checkTimeCodeByThera(@RequestBody TheraJSONDTO theraJSONDTO,HttpSession session){
        System.out.println("시간바궜냐 그만 바꿔라"+theraJSONDTO);

        LoginUserDTO loginUserDTO = ((LoginUserDTO) session.getAttribute("auth"));
        String pmCode = loginUserDTO.getPmCode();
        theraJSONDTO.setPmCode(pmCode);

        List<TodayAllTheraDTO> todayTheraByPRNo = userService.todayTheraByPRNo(theraJSONDTO);

        for(TodayAllTheraDTO t : todayTheraByPRNo){
            List<Integer> code = findTimeCode.CantTimeCode(t.getStart(),t.getEnd());
            System.out.println("code = " + code);
            t.setCode(code);
        }
        return todayTheraByPRNo;
    }

    @PostMapping("/makeProject")
    public String makeProject(@RequestParam Map<String,String> parameters){

        System.out.println("프로젝트 생성 시작");
        for (String key : parameters.keySet()) {
            Object value = parameters.get(key);
            System.out.println("Key: " + key + ", Value: " + value);
        }



        return "redirect:/auth/mainPage";
    }



}
