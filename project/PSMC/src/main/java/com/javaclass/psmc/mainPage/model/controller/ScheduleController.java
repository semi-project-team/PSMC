package com.javaclass.psmc.mainPage.model.controller;

import com.javaclass.psmc.mainPage.model.dto.TheraToProDTO;
import com.javaclass.psmc.mainPage.model.dto.TtoMIDTO;
import com.javaclass.psmc.user.model.dto.LoginUserDTO;
import com.javaclass.psmc.user.model.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ScheduleController {

    private final UserService userService;
    @Autowired
    public ScheduleController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/schedule/scheduler")
    public void scheduler(){}

    @GetMapping("/schedule")
    public String schedule(HttpSession session){
        LoginUserDTO loginUserDTO = (LoginUserDTO) session.getAttribute("auth");

        String pmCode = loginUserDTO.getPmCode();
        String role = loginUserDTO.getRole().toString();
        System.out.println("오긴 했니");
        System.out.println(role);
        LocalDate today = LocalDate.now();
        LocalDate startOfWeek = today.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
        LocalDate endOfWeek = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));

        Map<String,Object> param = new HashMap<>();
        param.put("pmCode",pmCode);
        param.put("startDay",startOfWeek);
        param.put("endDay",endOfWeek);

        if(role.equals("[d]")){
        List<TtoMIDTO> dtimes = userService.todayMedi(param);
        param.put("schedule",dtimes);
            System.out.println(dtimes);
        }
//        else{
//            List<TheraToProDTO> ttimes = userService.todayThera(param);
//        }

        session.setAttribute("param",param);


        return "/schedule/scheduler";

    }

    @GetMapping(value = "/setSchedule",produces = "application/json; charset=UTF-8")
    @ResponseBody
    public Map<String,Object> setSchedule(HttpSession session){
        return (Map<String,Object>) session.getAttribute("param");
    }

    @GetMapping(value = "/alltime", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<TtoMIDTO> getSchedule(HttpSession session){
        String pmCode = (String) ((Map<String,Object>) session.getAttribute("param")).get("pmCode");
        List<TtoMIDTO> times = userService.allTimes(pmCode);

        System.out.println(times);
        return times;

    }

}
