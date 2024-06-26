package com.javaclass.psmc.theraLink.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaclass.psmc.auth.model.dto.MyPatientDTO;
import com.javaclass.psmc.common.model.dto.InjuryDTO;
import com.javaclass.psmc.common.model.dto.TheraLinkDTO;
import com.javaclass.psmc.common.model.method.MakePhoneNumber;

import com.javaclass.psmc.mainPage.model.dto.ProfileDTO;
import com.javaclass.psmc.theraLink.model.dto.*;
import com.javaclass.psmc.user.model.dto.LoginUserDTO;
import com.javaclass.psmc.user.model.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

@Controller
public class TheraLinkController {

    @Value("${file.upload-dir}")
    private String uploadDir;

    private final UserService userService;
    private final ObjectMapper objectMapper;
    private final ResourceLoader resourceLoader;

    private MakePhoneNumber makePhoneNumber=new MakePhoneNumber();
    @Autowired
    public TheraLinkController(UserService userService,ObjectMapper objectMapper,ResourceLoader resourceLoader){

        this.objectMapper=objectMapper;
        this.userService = userService;
        this.resourceLoader=resourceLoader;
    }

    @GetMapping("/theraLink/{pageNo}")
    public String goFirstPage(HttpSession session, Model model, @PathVariable int pageNo, HttpServletRequest request){

        // 현재 회원 정보
        LoginUserDTO loginUserDTO = (LoginUserDTO) session.getAttribute("auth");
        String pmCode = loginUserDTO.getPmCode();
        Map<String,Object> sender = new HashMap<>();
        sender.put("pmCode",pmCode);

        // 의료진인지 치료사인지 확인
        if(pmCode.charAt(0)=='d'){
            sender.put("role","doctor");
        }else{
            sender.put("role","thera");
        }

        // form 을 통해 특정 조건의 프로젝트 조사
        Map<String,String> parameters = (Map<String, String>) request.getAttribute("param");


        if(!Objects.isNull(parameters)) {
            if (parameters.get("injury") != null) {
                sender.put("injuryCode", parameters.get("injury"));
            }
            if (parameters.get("patientName") != null) {
                sender.put("patientName", parameters.get("patientName"));
            }

        }

        List<MyPatientDTO> myPatients = userService.myPatient(sender);

        int totalData = myPatients.size();
        int totalPage = (int)(Math.ceil(totalData/5.0));
        if(totalPage==0){
            totalPage=1;
        }

        sender.put("pageNo",(pageNo-1)*5);

        List<MyPatientDTO> myPatientLimit = userService.myPatient(sender);



        /*번호 원하는 형태로 format*/
        for(MyPatientDTO p : myPatientLimit){
            p.setPhone(makePhoneNumber.formatPhoneNumber(p.getPhone()));
        }

        model.addAttribute("patients",myPatientLimit);


        model.addAttribute("totalData",totalData);
        model.addAttribute("totalPage",totalPage);

        int pageLimit = (pageNo-1)*5+1;
        model.addAttribute("pageLimit",pageLimit);
        model.addAttribute("pageNo",pageNo);


        ProfileDTO profileDTO = userService.findEmployeeByPmCode(pmCode);
        model.addAttribute("profile",profileDTO);


        // 해당 의료종사자의 전공 분야에 해당하는 부상 코드 전송
        List<InjuryDTO> injuryDTOS = userService.findInjuryByFieldCode(profileDTO.getFieldCode());
        model.addAttribute("injuryMap",injuryDTOS);

        return "theraLink/firstPage";
    }

    @GetMapping("/theraLink/open/{projectNo}/{pageNo}")
    public String goSecondPage(@PathVariable int projectNo,Model model,@PathVariable int pageNo){


        Map<String,Integer> sender = new HashMap<>();
        sender.put("projectNo",projectNo);

        List<BlogDTO> blogDTOS = userService.findAllBlogByProjectNo(sender);

        int totalData = blogDTOS.size();
        int totalPage = (int) Math.ceil(totalData/4.0);

        if(totalPage==0){
            totalPage=1;
        }
        int pageLimit  = (pageNo-1)*4;
        sender.put("pageNo",pageLimit);

        List<BlogDTO> blogDTOLimit = userService.findAllBlogByProjectNo(sender);

        model.addAttribute("theraLink",blogDTOLimit);

        model.addAttribute("projectNo",projectNo);
        model.addAttribute("totalPage",totalPage);
        model.addAttribute("pageNo",pageNo);
        return "theraLink/secondPage";
    }


    @GetMapping("/theraLink/open/{projectNo}/{pageNo}/deleteTheraLink")
    public String deleteTheraLink(@RequestParam List<Integer> theraNo,@PathVariable int projectNo,@PathVariable int pageNo){




        Map<String,List<Integer>> theraNos = new HashMap<>();
        theraNos.put("thera",theraNo);
        int result = userService.deleteThearLink(theraNos);

        return "redirect:/theraLink/open/"+projectNo+"/"+pageNo;
    }

    @PostMapping(value = "/theraLink/blog",produces = "application/json; charset=UTF-8")
    @ResponseBody
    public TheraLinkForChatDTO showblog(@RequestBody String theraNum,HttpSession session) throws JsonProcessingException {


        JsonNode jsonNode = objectMapper.readTree(theraNum);
        String theraNo = jsonNode.get("theraNum").asText();


        TheraLinkForChatDTO theraChat = userService.getTheraChatBytheraNo(theraNo);


        if(!Objects.isNull(theraChat)) {
            String pmCode = ((LoginUserDTO) session.getAttribute("auth")).getPmCode();
            theraChat.setMe(pmCode);


        }
        return theraChat;

    }

    @PostMapping(value = "/theraLink/addMessage",produces = "application/json; charset=UTF-8")
    @ResponseBody
    public TheraLinkForChatDTO makeChat(@RequestBody MessageDTO messageDTO,HttpSession session){


        messageDTO.setPmCode(((LoginUserDTO)session.getAttribute("auth")).getPmCode());
        messageDTO.setTheraChatDate(LocalDateTime.now());
        int result = userService.makeTheraChat(messageDTO);

            TheraLinkForChatDTO theraLinkForChatDTO=userService.getTheraChatBytheraNo(messageDTO.getTheraNum());
            theraLinkForChatDTO.setMe(messageDTO.getPmCode());



            return theraLinkForChatDTO;
    }

    @PostMapping(value = "/theraLink/deleteChating",produces = "application/json; charset=UTF-8")
    @ResponseBody
    public TheraLinkForChatDTO deleteChat(@RequestBody ChatDeleteDTO chatDeleteDTO,HttpSession session){


        int result = userService.deleteChat(chatDeleteDTO);

        TheraLinkForChatDTO theraLinkForChatDTO = userService.getTheraChatBytheraNo(chatDeleteDTO.getTheraNum());

        if(!Objects.isNull(theraLinkForChatDTO)) {
            String pmCode = ((LoginUserDTO) session.getAttribute("auth")).getPmCode();
            theraLinkForChatDTO.setMe(pmCode);

        }




        return theraLinkForChatDTO;
    }


    // upload

    @PostMapping("/theraLink/theraUpload/{projectNo}")
    public ResponseEntity<Map<String, String>> fileUpload(@ModelAttribute RecieveDTO recieveDTO, @PathVariable int projectNo) throws IOException {
        List<MultipartFile> images = recieveDTO.getImages();

        File directory  = new File(uploadDir);
        if(!directory.exists()){
            directory.mkdirs();
        }




        TheraLinkDTO theraLinkDTO = new TheraLinkDTO();
        theraLinkDTO.setProjectNo(projectNo);
        theraLinkDTO.setTheraTitle(recieveDTO.getTheraTitle());
        theraLinkDTO.setTheraContents(recieveDTO.getContents());
        theraLinkDTO.setTheraBoardDate(LocalDateTime.now());

        int[] results = userService.makeTheraLink(theraLinkDTO);
        int theraLinkNo = results[1];

        if (!Objects.isNull(images)) {
//            String uploadDir = "static/common/postimg";
//            InputStream resourceStream = getClass().getClassLoader().getResourceAsStream(uploadDir);
//            if (resourceStream == null) {
//                File file = new File("src/main/resources/" + uploadDir);
//                if (!file.exists()) {
//                    file.mkdirs(); // 디렉토리 생성
//                }
//            }
//            String filepath = new File("src/main/resources/" + uploadDir).getAbsolutePath();
//


            List<TheraLinkPhotoDTO> theraLinkPhotoDTOS = new ArrayList<>();
            List<String> saveFiles = new ArrayList<>();
            for (MultipartFile im : images) {
                String originalFileName = im.getOriginalFilename();
                String ext = originalFileName.substring(originalFileName.lastIndexOf("."));
                String savedName = UUID.randomUUID().toString().replace("-", "") + ext;

                try{
                    im.transferTo(new File(directory+"/"+savedName));
                }catch (IOException e){
                    throw new  RuntimeException("파일 업로드 중 오류가 발생했습니다"+e);
                }

                String filepath = "/images/postimg/"+savedName;
                // 파일 저장 디렉토리 확인 및 생성
//                File saveFile = new File(filepath + File.separator + savedName);
//                im.transferTo(saveFile);

//                saveFiles.add(uploadDir + "/" + savedName); // 변경된 경로

                TheraLinkPhotoDTO newPhoto = new TheraLinkPhotoDTO();
                newPhoto.setTheralinkOriginName(originalFileName);
                newPhoto.setTheralinkSavedName(savedName);
                newPhoto.setTheralinkFilepath(filepath);
                newPhoto.setTheralinkNo(theraLinkNo);
                theraLinkPhotoDTOS.add(newPhoto);
                int result = userService.insertTheraLinkPhoto(newPhoto);
            }
        }

        Map<String, String> response = new HashMap<>();
        String url = "/theraLink/open/" + projectNo + "/1";
        response.put("redirectURL", url);

        return ResponseEntity.ok(response);
    }

    // update

    @PostMapping("/theraLink/theraModi/{projectNo}")
    public ResponseEntity<Map<String, String>> modifyBlog(@ModelAttribute RecieveDTO recieveDTO, @PathVariable int projectNo) throws IOException {


        List<MultipartFile> images = recieveDTO.getImages();

        int result1 = userService.killAllpictureByTheralinkNo(recieveDTO.getTheralinkNo());

        TheraLinkDTO theraLinkDTO = new TheraLinkDTO();
        theraLinkDTO.setTheraLinkNo(recieveDTO.getTheralinkNo());
        theraLinkDTO.setTheraTitle(recieveDTO.getTheraTitle());
        theraLinkDTO.setTheraContents(recieveDTO.getContents());

        int result = userService.updateTheraLink(theraLinkDTO);

        File directory  = new File(uploadDir);
        if(!directory.exists()){
            directory.mkdirs();
        }


        if (!Objects.isNull(images)) {

            String uploadDir = "static/common/postimg";
            InputStream resourceStream = getClass().getClassLoader().getResourceAsStream(uploadDir);
            if (resourceStream == null) {
                File file = new File("src/main/resources/" + uploadDir);
                if (!file.exists()) {
                    file.mkdirs(); // 디렉토리 생성
                }
            }


            List<TheraLinkPhotoDTO> theraLinkPhotoDTOS = new ArrayList<>();
            List<String> saveFiles = new ArrayList<>();
            for (MultipartFile im : images) {
                String originalFileName = im.getOriginalFilename();
                String ext = originalFileName.substring(originalFileName.lastIndexOf("."));
                String savedName = UUID.randomUUID().toString().replace("-", "") + ext;

                // 파일 저장 디렉토리 확인 및 생성
//                File saveFile = new File(filepath + File.separator + savedName);
//                im.transferTo(saveFile);

                try{
                    im.transferTo(new File(directory+"/"+savedName));
                }catch (IOException e){
                    throw new  RuntimeException("파일 업로드 중 오류가 발생했습니다"+e);
                }


                String filepath = "/images/postimg/"+savedName;
//                saveFiles.add(uploadDir + "/" + savedName); // 변경된 경로

                TheraLinkPhotoDTO newPhoto = new TheraLinkPhotoDTO();
                newPhoto.setTheralinkOriginName(originalFileName);
                newPhoto.setTheralinkSavedName(savedName);
                newPhoto.setTheralinkFilepath(filepath);
                newPhoto.setTheralinkNo(recieveDTO.getTheralinkNo());
                theraLinkPhotoDTOS.add(newPhoto);
                int result2 = userService.insertTheraLinkPhoto(newPhoto);
            }
        }

        Map<String, String> response = new HashMap<>();
        String url = "/theraLink/open/" + projectNo + "/1";
        response.put("redirectURL", url);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/theraLink/patientSearch")
    public String patientSearch(@RequestParam Map<String,String> parameters,HttpServletRequest request){

            request.setAttribute("param",parameters);

        return "forward:/theraLink/"+1;
    }

}
