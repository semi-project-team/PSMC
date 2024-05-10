package com.javaclass.psmc.mediConnect.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProjectsController {

    @GetMapping("/MediConnect")
    public String projectList() {
        return "/doc/projects";
    }

}
