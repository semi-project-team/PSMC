package com.javaclass.psmc.mypage.controller;

import com.javaclass.psmc.common.model.dto.EmployeeDTO;
import com.javaclass.psmc.common.model.dto.MemberRegistDTO;
import com.javaclass.psmc.mypage.model.dto.EditDTO;
import com.javaclass.psmc.mypage.model.dto.ProfileFroEditDTO;
import com.javaclass.psmc.mypage.model.service.EditService;
import com.javaclass.psmc.user.model.dto.LoginUserDTO;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class EditController {

    private final EditService editService;

    @Autowired
    public EditController(EditService editService) {
        this.editService = editService;
    }

    @GetMapping("/editPage")
    public String editPage(Model model, HttpSession session) {

        LoginUserDTO loginUserDTO = (LoginUserDTO) session.getAttribute("auth");
        String pmCode = loginUserDTO.getPmCode();

        

        ProfileFroEditDTO profileFroEditDTO = editService.findInfoForEdit(pmCode);

        model.addAttribute("profile",profileFroEditDTO);

        System.out.println("profileFroEditDTO = " + profileFroEditDTO);
        return "/mypage/edit";
    }

    @PostMapping ("/memberUpdate")
    public String memberUpdate(@ModelAttribute EditDTO editDTO) {


        int result1= editService.updateEmployee(editDTO);
        int result2 = editService.updateRegist(editDTO);

        return "redirect:/editPage";
    }


}
