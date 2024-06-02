package com.javaclass.psmc.auth.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaclass.psmc.auth.model.AuthDetails;
import com.javaclass.psmc.auth.model.dto.*;
import com.javaclass.psmc.common.model.dto.EmployeeDTO;
import com.javaclass.psmc.common.model.dto.InjuryDTO;
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

        /*권한 정보 불러오기*/
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AuthDetails authDetails = (AuthDetails) authentication.getPrincipal();


        /*권한 정보 session 에 저장하기*/
        session.setAttribute("auth",authDetails.getLoginUserDTO());

        /*d 와 t 권한 분리*/
        Map<String,Object> sender = new HashMap<>();
        String pmCode = authDetails.getLoginUserDTO().getPmCode();
        String role = String.valueOf(pmCode.charAt(0));
        if(role.equals("d")){

            sender.put("role","doctor");
        }else{

            sender.put("role","thera");
        }
        model.addAttribute("role",role);
        sender.put("pmCode",pmCode);

        /*mainpage profile 정보 받아오기*/
        ProfileDTO profileDTO = userService.findEmployeeByPmCode(pmCode);

        model.addAttribute("profile",profileDTO);

        /*모달 페이지 용 injury db 불러오기*/
        List<InjuryDTO> injuryDTOS = userService.findInjuryByFieldCode(profileDTO.getFieldCode());
        model.addAttribute("injuryMap",injuryDTOS);


        /*최신 채팅*/
        List<MiniMediConnectDTO> miniMedi = userService.showFourMedi(sender);
        model.addAttribute("miniMedi", miniMedi);

        List<MiniTheraLinkDTO> miniThera = userService.showFourThera(sender);
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        if(!miniThera.isEmpty()){
            for(MiniTheraLinkDTO t : miniThera){
                t.setTransDate(t.getChatBoardDate().format(formatter1));
            }
        }

        model.addAttribute("miniThera",miniThera);

        /*Today schedule 보여주기*/
        LocalDate today = LocalDate.now();

        sender.put("today",today);

        int day = userService.findDayNo(today.toString());

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

                    p.setTime(timePlus30.timeFormat(String.valueOf(p.getResTimeDTOS().getTimeVal())));

                }
            }

            model.addAttribute("projects",projects);

        }else{
            List<TheraProjectDTO> projects = userService.theraToday(sender);

            model.addAttribute("projects",projects);
        }

        List<MyPatientDTO> mypatients = userService.myPatient(sender);

        for(MyPatientDTO p : mypatients){
            p.setPhone(makePhoneNumber.formatPhoneNumber(p.getPhone()));
        }

        model.addAttribute("patient",objectMapper.writeValueAsString(mypatients));


        String message = (String) session.getAttribute("reservationMessage");
        StringBuilder messages = (StringBuilder) session.getAttribute("messages");
        session.removeAttribute("messages");
        session.removeAttribute("reservationMessage");

        model.addAttribute("reservationMessage",message);
        if(messages!=null) {
            model.addAttribute("reservationMessages", messages);
        }

        return "auth/login";
    }

    @GetMapping("/fail")
    public String loginFail(Model model,@RequestParam String message){

        model.addAttribute("message",message);

        return "auth/fail";
    }

    @PostMapping("/takeCode")
    public String takeCode(@RequestParam String pmCode, @RequestParam String empNo, HttpSession httpSession){
        Map<String,String> param = new HashMap<>();
        param.put("pmCode",pmCode);
        param.put("empNo",empNo);
        List<EmployeeDTO> employee = userService.findMember(param);

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

                httpSession.setAttribute("pmCode",pmCode);
                return "redirect:/member/registerReq";
            }

        }

    }




}
