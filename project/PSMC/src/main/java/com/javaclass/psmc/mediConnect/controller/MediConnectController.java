package com.javaclass.psmc.mediConnect.controller;

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

    @GetMapping("/doc/mediConnect/{projectNo}")
    public String mediConnectPage(@PathVariable int projectNo, Model model, HttpSession session) {

        LoginUserDTO loginUserDTO = (LoginUserDTO) session.getAttribute("auth");
        String pmCode = loginUserDTO.getPmCode();

        Map<String,Object> parameter = new HashMap<>();
        parameter.put("pmCode",pmCode);
        parameter.put("projectNo",projectNo);

        List<ShowMediConnectDTO> boards = mediConnectService.showAllBoards(parameter);

        model.addAttribute("boards", boards);

        return "/doc/mediConnect";
    }

    @PostMapping("/doc/delteBtn")
    public String deleteBoard(@RequestParam List<Integer> no) {

        mediConnectService.deleteBoard(no);

        return "redirect:/doc/mediConnect";
    }

}
