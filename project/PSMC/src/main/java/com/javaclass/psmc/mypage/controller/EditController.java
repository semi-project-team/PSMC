package com.javaclass.psmc.mypage.controller;

import com.javaclass.psmc.common.model.method.MakePhoneNumber;
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
    private MakePhoneNumber makePhoneNumber = new MakePhoneNumber();

    @Autowired
    public EditController(EditService editService) {
        this.editService = editService;
    }

    @GetMapping("/editPage")
    public String editPage(Model model, HttpSession session) {
        LoginUserDTO loginUserDTO = (LoginUserDTO) session.getAttribute("auth");
        String pmCode = loginUserDTO.getPmCode();
        ProfileFroEditDTO profileFroEditDTO = editService.findInfoForEdit(pmCode);

        profileFroEditDTO.getEmployeeDTO().setPhone(makePhoneNumber.formatPhoneNumber(profileFroEditDTO.getEmployeeDTO().getPhone()));
        profileFroEditDTO.getEmployeeDTO().setOfficeNum(makePhoneNumber.formatPhoneNumber(profileFroEditDTO.getEmployeeDTO().getOfficeNum()));
        model.addAttribute("profile", profileFroEditDTO);
        return "mypage/edit";
    }

    @PostMapping("/memberUpdate")
    public String memberUpdate(@ModelAttribute EditDTO editDTO,HttpSession session) {
        int result1 = editService.updateEmployee(editDTO);
        int result2 = editService.updateRegist(editDTO);

        String message = null;

        if (result1 > 0 && result2 > 0) {
            message = "수정을 완료하였습니다.";
        }else {
            message = "수정에 실패하였습니다.";
        }
        session.setAttribute("message", message);

        // 수정이 완료되었을 때 이전 페이지로 리다이렉트
        return "redirect:/mypage/mypage";
    }

}
