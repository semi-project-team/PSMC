package com.javaclass.psmc.mediConnect.model.service;

import com.javaclass.psmc.mediConnect.model.dao.ProjectsMapper;
import com.javaclass.psmc.mediConnect.model.dto.ShowAllProjectsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProjectsService {

    private final ProjectsMapper projectsMapper;

    @Autowired
    public ProjectsService(ProjectsMapper projectsMapper) {

        this.projectsMapper = projectsMapper;
    }
    public List<ShowAllProjectsDTO> showAllProjects(String pmCode) {

        return projectsMapper.showAllProjects(pmCode);
    }

    public int deleteProject(Map<String, List<Integer>> projectParam) {

        return projectsMapper.deleteProjects(projectParam);
    }

//    service

}
