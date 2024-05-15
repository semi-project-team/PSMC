package com.javaclass.psmc.auth.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaclass.psmc.auth.model.AuthDetails;
import com.javaclass.psmc.auth.model.dto.MyPatientDTO;
import com.javaclass.psmc.auth.model.dto.ProjectsDTO;
import com.javaclass.psmc.auth.model.dto.TheraProjectDTO;
import com.javaclass.psmc.common.model.dto.EmployeeDTO;
import com.javaclass.psmc.common.model.method.MakePhoneNumber;
import com.javaclass.psmc.common.model.method.MenuHandling;
import com.javaclass.psmc.common.model.method.TimePlus30;
import com.javaclass.psmc.mainPage.model.dto.ProfileDTO;
import com.javaclass.psmc.user.model.dto.LoginUserDTO;
import com.javaclass.psmc.user.model.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private TimePlus30 timePlus30 = new TimePlus30();
    private MakePhoneNumber makePhoneNumber = new MakePhoneNumber();
    private ObjectMapper objectMapper;
    private MenuHandling menuHandling=new MenuHandling();

    @Autowired
    public AuthController(UserService userService,ObjectMapper objectMapper){
        this.objectMapper=objectMapper;
        this.userService=userService;
    }

    @GetMapping("/login")
    public String loginSuccess(){
        return "forward:/auth/mainPage";
    }
    @GetMapping("/mainPage")
    public String login(HttpSession session, Model model) throws JsonProcessingException {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AuthDetails authDetails = (AuthDetails) authentication.getPrincipal();
        System.out.println("authDetails = " + authDetails);
        session.setAttribute("auth",authDetails.getLoginUserDTO());

        Map<String,Object> sender = new HashMap<>();
        String pmCode = authDetails.getLoginUserDTO().getPmCode();
        String role = String.valueOf(pmCode.charAt(0));
        if(role.equals("d")){
            System.out.println("d가 맞아");
            sender.put("role","doctor");
        }else{
            System.out.println("d가 아니야?");
            sender.put("role","thera");
        }

        model.addAttribute("role",role);
        sender.put("pmCode",pmCode);
        ProfileDTO profileDTO = userService.findEmployeeByPmCode(pmCode);
        System.out.println(profileDTO);
        model.addAttribute("profile",profileDTO);

        LocalDate today = LocalDate.now();
        System.out.println("today = " + today);
        sender.put("today",today);

        int day = userService.findDayNo(today.toString());
        System.out.println("day = " + day);
        menuHandling.setDay(day);
        menuHandling.setDate(today);


        model.addAttribute("day",day);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy.MM.dd");
        String formattedDate = today.format(formatter);


        model.addAttribute("ModiToday",formattedDate);

        if(role.equals("d")){
            List<ProjectsDTO> projects = userService.mediToday(sender);
            if(projects!=null) {
                for (ProjectsDTO p : projects) {
                    System.out.println("p가 왜 하나냐"+p);
                    p.setTime(timePlus30.timeFormat(String.valueOf(p.getResTimeDTOS().getTimeVal())));
                    System.out.println("projects 하나 = " + p);
                }
            }

            model.addAttribute("projects",projects);

        }else{
            List<TheraProjectDTO> projects = userService.theraToday(sender);
            System.out.println("projects tttt = " + projects);
            model.addAttribute("projects",projects);
        }

        List<MyPatientDTO> mypatients = userService.myPatient(sender);

        for(MyPatientDTO p : mypatients){
            p.setPhone(makePhoneNumber.formatPhoneNumber(p.getPhone()));
        }

        model.addAttribute("patient",objectMapper.writeValueAsString(mypatients));
        System.out.println("mypatients = " + mypatients);

        String message = (String) session.getAttribute("reservationMessage");
        StringBuilder messages = (StringBuilder) session.getAttribute("messages");
        session.removeAttribute("messages");
        session.removeAttribute("reservationMessage");

        model.addAttribute("reservationMessage",message);
        if(messages!=null) {
            model.addAttribute("reservationMessages", messages);
        }

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
