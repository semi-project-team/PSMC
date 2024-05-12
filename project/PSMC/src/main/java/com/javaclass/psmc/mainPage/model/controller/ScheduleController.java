package com.javaclass.psmc.mainPage.model.controller;

import com.javaclass.psmc.mainPage.model.dto.*;
import com.javaclass.psmc.user.model.dto.LoginUserDTO;
import com.javaclass.psmc.user.model.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Controller
public class ScheduleController {

    private final UserService userService;
    @Autowired
    public ScheduleController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/schedule/scheduler")
    public void scheduler(Model model, HttpServletRequest request){
        System.out.println("와주십숑 scheduler 입니다");
        String message = (String) request.getAttribute("message");
        model.addAttribute("message",message);
    }

    @GetMapping("/schedule")
    public String schedule(HttpSession session){
        LoginUserDTO loginUserDTO = (LoginUserDTO) session.getAttribute("auth");

        String pmCode = loginUserDTO.getPmCode();
        String role = loginUserDTO.getRole().toString();
        LocalDate today = LocalDate.now();
        LocalDate startOfWeek = today.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
        LocalDate endOfWeek = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));

        System.out.println("startOfWeek = " + startOfWeek);
        System.out.println("endOfWeek = " + endOfWeek);

        Map<String,Object> param = new HashMap<>();
        param.put("pmCode",pmCode);
        param.put("startDay",startOfWeek);
        param.put("endDay",endOfWeek);

        if(role.equals("[d]")){
            List<TtoMIDTO> dtimes = userService.todayMedi(param);
            param.put("dschedule",dtimes);
            System.out.println("dtimes = " + dtimes);
        }
        else{
            List<TheraToProDTO> ttimes = userService.todayThera(param);
            param.put("tschedule",ttimes);
        }

        session.setAttribute("param",param);


        return "forward:/schedule/scheduler";

    }

    @GetMapping(value = "/setSchedule",produces = "application/json; charset=UTF-8")
    @ResponseBody
    public Map<String,Object> setSchedule(HttpSession session){
        return (Map<String,Object>) session.getAttribute("param");
    }

    @GetMapping(value = "/alltime", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public Map<String,Object> getSchedule(HttpSession session){
        String pmCode = (String) ((Map<String,Object>) session.getAttribute("param")).get("pmCode");
        Map<String,Object> allSchedule = new HashMap<>();
        allSchedule.put("pmCode",pmCode);
        if(pmCode.charAt(0)=='d') {
            List<TtoMIDTO> times = userService.allTimes(pmCode);
            allSchedule.put("times",times);

        }
        else{
            List<TheraToProDTO> times =userService.allThera(pmCode);
            allSchedule.put("times",times);
        }

        return allSchedule;
    }

    @GetMapping("/schedule/getSchedule")
    public String getSchedule(@RequestParam String datepick,HttpSession session){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate dating = LocalDate.parse(datepick,formatter);
        System.out.println("dating here"+dating);
        // 오늘이 속한 주의 시작 날짜 계산하기 (월요일)
        LocalDate startOfWeek = dating.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));

        // 오늘이 속한 주의 끝 날짜 계산하기 (일요일)
        LocalDate endOfWeek = dating.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));

        Map<String, Object> param = (Map<String, Object>) session.getAttribute("param");
        param.put("startDay",startOfWeek);
        param.put("endDay",endOfWeek);

        List<TtoMIDTO> schedule = userService.todayMedi(param);
        param.put("schedule",schedule);

        session.setAttribute("param",param);

        return "/schedule/scheduler";
    }

    @PostMapping("/delete/{mediCode}")
    public String delete(@PathVariable int mediCode, HttpSession session){
        Map<String,String> delete = new HashMap<>();
        String pmCode= ((Map<String,String>)session.getAttribute("param")).get("pmCode");
        String role = String.valueOf(pmCode.charAt(0));
        if(role.equals("d")){
            delete.put("role","doctor");
        }else{
            delete.put("role","thera");
        }
        delete.put("code", String.valueOf(mediCode));
        System.out.println(delete.get("code"));
        int result = userService.softDelete(delete);

        return "redirect:/schedule";
    }

    @PostMapping("/update/{mediCode}")
    public String update(@RequestParam Map<String,Object> parameter,@PathVariable int mediCode,HttpSession session){

        parameter.put("code",mediCode);
        for (String key : parameter.keySet()) {
            Object value = parameter.get(key);
            System.out.println("Key: " + key + ", Value: " + value);
        }

        String role = String.valueOf(((LoginUserDTO)session.getAttribute("auth")).getPmCode().charAt(0));
        if(role.equals("d")){
            parameter.put("role","doctor");
        }
        else{
            parameter.put("role","thera");
        }
        int result = userService.mediInfoUpdate(parameter);


        return "redirect:/schedule";
    }

    @GetMapping(value = "/allProjects",produces = "application/json; charset=UTF-8")
    @ResponseBody
    public  Map<String,Object> allProjects(HttpSession session){
        String pmCode = ((LoginUserDTO)session.getAttribute("auth")).getPmCode();
        String role = String.valueOf(pmCode.charAt(0));
        Map<String,Object> param = new HashMap<>();
        param.put("pmCode",pmCode);
        if(role.equals("d")) {param.put("role","doctor");}
        else{ param.put("role","thera");}

        List<AllMediDTO> allMedi = userService.allMedi(param);
        List<AllTheraDTO> allThera = userService.allTheraInfo(param);


        System.out.println("allThera = " + allThera);
        System.out.println("allMedi = " + allMedi);

        param.put("allMedi",allMedi);
        param.put("allThera",allThera);

        return param;


    }

}
