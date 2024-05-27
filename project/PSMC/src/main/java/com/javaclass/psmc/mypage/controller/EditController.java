package com.javaclass.psmc.mypage.controller;

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
        model.addAttribute("profile", profileFroEditDTO);
        return "/mypage/edit";
    }

    @PostMapping("/memberUpdate")
    public String memberUpdate(@ModelAttribute EditDTO editDTO) {
        editService.updateEmployee(editDTO);
        editService.updateRegist(editDTO);
        // 수정이 완료되었을 때 이전 페이지로 리다이렉트
        return "redirect:/mypage/mypage";
    }

}
