package com.javaclass.psmc.mediConnect.controller;

import com.javaclass.psmc.mediConnect.model.dto.ShowAllProjectsDTO;
import com.javaclass.psmc.mediConnect.model.service.ProjectsService;
import com.javaclass.psmc.user.model.dto.LoginUserDTO;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ProjectsController {

    private final ProjectsService projectsService;

    @Autowired
    public ProjectsController(ProjectsService projectsService) {

        this.projectsService = projectsService;
    }

    @GetMapping("/MediConnect")
    public String mediConnectLink(HttpSession session) {

        LoginUserDTO loginUserDTO = (LoginUserDTO) session.getAttribute("auth");
        String pmCode = loginUserDTO.getPmCode();

        List<ShowAllProjectsDTO> projects = projectsService.showAllProjects(pmCode);
        session.setAttribute("projectList", projects);

        return "/doc/projects";
    }

    @GetMapping(value = "/requestProject", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<ShowAllProjectsDTO> projectList(HttpSession session) {
        return (List<ShowAllProjectsDTO>) session.getAttribute("projectList");
    }

}
