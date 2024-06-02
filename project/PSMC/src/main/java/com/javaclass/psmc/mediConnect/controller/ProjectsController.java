package com.javaclass.psmc.mediConnect.controller;

import com.javaclass.psmc.mediConnect.model.dto.NewProjectShowDTO;
import com.javaclass.psmc.mediConnect.model.dto.ShowAllProjectsDTO;
import com.javaclass.psmc.mediConnect.model.service.ProjectsService;
import com.javaclass.psmc.user.model.dto.LoginUserDTO;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ProjectsController {

    private final ProjectsService projectsService;

    @Autowired
    public ProjectsController(ProjectsService projectsService) {

        this.projectsService = projectsService;
    }

    @GetMapping("/MediConnect")
    public String mediConnectLink(HttpSession session, Model model) {

        LoginUserDTO loginUserDTO = (LoginUserDTO) session.getAttribute("auth");
        String pmCode = loginUserDTO.getPmCode();

        HashMap<String, String> param = new HashMap<>();
        param.put("pmCode", pmCode);

        String role = String.valueOf(pmCode.charAt(0));
        if (pmCode.charAt(0) == 'd') {
            param.put("role", "doctor");
        } else {
            param.put("role", "thera");
        }

        List<NewProjectShowDTO> projects = projectsService.showNewProjects(param);
        session.setAttribute("projectList", projects);


        model.addAttribute("pmCode",role);

        return "medi/projects";
    }

    @GetMapping(value = "/requestProject", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<NewProjectShowDTO> projectList(HttpSession session) {
        return (List<NewProjectShowDTO>) session.getAttribute("projectList");
    }

    @PostMapping("/deleteProjectBtn")
    public String deleteProjects(@RequestParam("projectCheckbox") List<Integer> projectCheckbox) {

        System.out.println("delete 여기");
        for(Integer i : projectCheckbox){
            System.out.println("i 값 확인 : " + i);
        }

        Map<String, List<Integer>> projectParam = new HashMap<>();
        projectParam.put("project", projectCheckbox);

        int result = projectsService.deleteProject(projectParam);

        return "redirect:/MediConnect";
    }

}
