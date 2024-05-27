package com.javaclass.psmc.mainPage.model.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaclass.psmc.common.model.dto.*;
import com.javaclass.psmc.common.model.method.FindTimeCode;
import com.javaclass.psmc.common.model.method.MakePhoneNumber;
import com.javaclass.psmc.common.model.method.MenuHandling;
import com.javaclass.psmc.mainPage.model.dto.*;
import com.javaclass.psmc.user.model.dto.LoginUserDTO;
import com.javaclass.psmc.user.model.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

@Controller
public class MyPageController {

    private MenuHandling menuHandling = new MenuHandling();
    private ObjectMapper objectMapper;
    private FindTimeCode findTimeCode = new FindTimeCode();
    private final ResourceLoader resourceLoader;
    private MakePhoneNumber makePhoneNumber = new MakePhoneNumber();

    private final UserService userService;
    @Autowired
    public MyPageController(UserService userService,ObjectMapper objectMapper,ResourceLoader resourceLoader){
        this.userService=userService;
        this.objectMapper=objectMapper;
        this.resourceLoader=resourceLoader;
    }

    @GetMapping("/mypage/mypage")
    public void mypage(HttpSession session, Model model){

        String message = (String) session.getAttribute("message");
        session.removeAttribute("message");
        model.addAttribute("message",message);

        LoginUserDTO loginUserDTO = (LoginUserDTO) session.getAttribute("auth");

        String pmCode = loginUserDTO.getPmCode();

        ProfileDTO profile= userService.findEmployeeByPmCode(pmCode);

        profile.setPhone(makePhoneNumber.formatPhoneNumber(profile.getPhone()));
        System.out.println(profile);

        model.addAttribute("profile",profile);
    }

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
    public String makeProject(@RequestParam Map<String,String> parameters,HttpSession session){

        String message = "환자 등록에 실패했습니다";
        LoginUserDTO loginUserDTO= (LoginUserDTO) session.getAttribute("auth");
        String pmCode = loginUserDTO.getPmCode();
        System.out.println("프로젝트 생성 시작");
        for (String key : parameters.keySet()) {
            Object value = parameters.get(key);
            System.out.println("Key: " + key + ", Value: " + value);
        }

        PatientDTO projectPatientDTO = new PatientDTO();

        projectPatientDTO.setPatientName(parameters.get("patientName"));
        projectPatientDTO.setAge(Integer.parseInt(parameters.get("age")));
        projectPatientDTO.setGender(parameters.get("gender"));
        projectPatientDTO.setHeight(Double.parseDouble(parameters.get("height")));
        projectPatientDTO.setWeight(Double.parseDouble(parameters.get("weight")));
        projectPatientDTO.setPhone(parameters.get("phone"));
        if(parameters.get("email")!=""){

            projectPatientDTO.setEmail(parameters.get("email"));
        }
        int[] results1 = userService.insertPatientAndGetPatientNo(projectPatientDTO);

        int result1 = results1[0];
        int patientNo = results1[1];
        System.out.println("patientNo = " + patientNo);

        if(result1>0){
            ProjectDTO newProject = new ProjectDTO();
            newProject.setPatientNo(patientNo);
            newProject.setProjectDate(LocalDateTime.now());
            newProject.setInjuryCode(Integer.parseInt(parameters.get("injuryCode")));
            int[] result2 = userService.insertProjectAndGetProjectNo(newProject);

            System.out.println("프로젝트 등록 성고?"+result2[0]);
            int projectNo = result2[1];
            System.out.println("projectNo = " + projectNo);

            if(result2[0]>0) {
                CreateProjectDTO createProjectDTO = new CreateProjectDTO(projectNo, pmCode);

                int result3 = userService.createProject(createProjectDTO);


                if(result3>0) {

                    System.out.println("createProject 등록 성공?");
                    String theraPmCode = parameters.get("theraPmCode");
                    int result4 = 0;
                    if (!theraPmCode.equals("none")) {
                        AssignProjectDTO assignProjectDTO = new AssignProjectDTO(projectNo, parameters.get("theraPmCode"));
                        result4 = userService.assignProject(assignProjectDTO);

                        if (result4 > 0) {
                            message = parameters.get("patientName") + " 환자를 등록 했습니다";
                        }


                    }
                    else{
                        message = parameters.get("patientName") + " 환자를 등록 했습니다";
                    }
                }
            }




        }

        session.setAttribute("reservationMessage",message);




        return "redirect:/auth/mainPage";
    }

    @PostMapping(value = "/findTherapyByInjuryCode",produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<EmployeeDTO> findTherapyByInjuryCode(@RequestBody String parameter) throws JsonProcessingException {

        JsonNode jsonNode = objectMapper.readTree(parameter);
        String injuryCode = jsonNode.get("injuryCode").asText();
        System.out.println("injuryCode = " + injuryCode);

        List<EmployeeDTO> employeeDTOS = userService.findEmployeeByInjuryCode(injuryCode);

        return employeeDTOS;
    }

    @PostMapping(value = "/uploadProfileImage",produces = "application/json; charset=UTF-8")
    @ResponseBody
    public ResponseEntity uploadfileimage(@RequestParam MultipartFile file,HttpSession session) throws IOException {
        System.out.println("들어온 이미지 이름"+file.getOriginalFilename());

        LoginUserDTO log = ((LoginUserDTO) session.getAttribute("auth"));
        String pmCode = log.getPmCode();
        Resource resource =resourceLoader.getResource("classpath:static/common/employeeimg");
        String filepath=null;

        if(!resource.exists()){
            String root = "src/main/resources/static/common/employeeimg";
            File file1 = new File(root);
            boolean valid=file1.mkdirs();

            System.out.println("valid = " + valid);

            filepath=file1.getAbsolutePath();
        }else{
            filepath=resourceLoader.getResource("classpath:static/common/employeeimg").getFile().getAbsolutePath();
        }

        String originName = file.getOriginalFilename();

        String ext = originName.substring(originName.lastIndexOf("."));
        String savedName = UUID.randomUUID().toString().replace("-","")+ext;

        file.transferTo(new File(filepath+"/"+savedName));

        EmployeePhotoDTO savePhoto = new EmployeePhotoDTO();

        savePhoto.setPmCode(pmCode);
        savePhoto.setEmployeeSavedName(savedName);
        savePhoto.setEmployeeFilepath(filepath);
        savePhoto.setEmployeeOriginName(originName);

        ProfileDTO profileDTO = userService.findEmployeeByPmCode(pmCode);
        if(profileDTO.getEmployeePhotoDTO().getEmployeeSavedName()!=null){
            int result1 = userService.updateEmployeePhoto(savePhoto);
        }else{
            int result2 = userService.insertEmployeePhoto(savePhoto);
        }




        return ResponseEntity.ok(savePhoto);
    }



}
