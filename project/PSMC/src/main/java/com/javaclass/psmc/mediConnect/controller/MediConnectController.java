package com.javaclass.psmc.mediConnect.controller;

import com.javaclass.psmc.common.model.dto.EmployeeDTO;
import com.javaclass.psmc.mediConnect.model.dto.ShowAllProjectsDTO;
import com.javaclass.psmc.mediConnect.model.dto.ShowMediConnectDTO;
import com.javaclass.psmc.mediConnect.model.service.MediConnectService;
import com.javaclass.psmc.user.model.dto.LoginUserDTO;
import jakarta.servlet.http.HttpSession;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.PatchExchange;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MediConnectController {

    private final MediConnectService mediConnectService;

    @Autowired
    public MediConnectController(MediConnectService mediConnectService) {
        this.mediConnectService = mediConnectService;
    }

    @GetMapping("/medi/mediConnect/{projectNo}")
    public String mediConnectPage(@PathVariable int projectNo, Model model, HttpSession session) {

        LoginUserDTO loginUserDTO = (LoginUserDTO) session.getAttribute("auth");
        String pmCode = loginUserDTO.getPmCode();

        Map<String,Object> parameter = new HashMap<>();
        parameter.put("pmCode",pmCode);
        parameter.put("projectNo",projectNo);

        List<ShowMediConnectDTO> boards = mediConnectService.showAllBoards(parameter);

        session.setAttribute("projectNo",projectNo);
        model.addAttribute("boards", boards);

        return "/medi/mediConnect";
    }

    @PostMapping("/deleteBtn")
    public String deleteBoard(@RequestParam("postCheckbox") List<Integer> postCheckbox, HttpSession session) {

        for(Integer i : postCheckbox){
            System.out.println("i 값확실 : "+i);
        }

        Map<String,List<Integer>> paramPost = new HashMap<>();
        paramPost.put("post", postCheckbox);

        int projectNo = (int) session.getAttribute("projectNo");
        int result =mediConnectService.deleteBoard(paramPost);

        return "redirect:/medi/mediConnect/"+projectNo;

    }

    @GetMapping("/medi/mediConnectDetail/{mediNo}")
    public String showBoardDetail(@PathVariable int mediNo, Model model, HttpSession session) {


        LoginUserDTO loginUserDTO = (LoginUserDTO) session.getAttribute("auth");
        String pmCode = loginUserDTO.getPmCode();

        int projectNo = (int) session.getAttribute("projectNo");

        Map<String, Object> parameter = new HashMap<>();
        parameter.put("pmCode",pmCode);
        parameter.put("mediNo", mediNo);
        parameter.put("projectNo", projectNo);

        ShowMediConnectDTO mediConnect = mediConnectService.showBoardDetail(parameter);
        ShowAllProjectsDTO patient = mediConnectService.showPatientDetail(parameter);
        EmployeeDTO employee = mediConnectService.showEmployee(parameter);

        model.addAttribute("boardDetail", mediConnect);
        model.addAttribute("patientDetail", patient);
        model.addAttribute("employeeDetail", employee);

        return "/medi/mediConnectDetail";
    }

}
