package com.javaclass.psmc.mediConnect.model.service;

import com.javaclass.psmc.mediConnect.model.dao.ProjectsMapper;
import com.javaclass.psmc.mediConnect.model.dto.ShowMediConnectDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MediConnectService {

    private final ProjectsMapper projectMapper;

    @Autowired
    public MediConnectService(ProjectsMapper projectsMapper) {
        this.projectMapper = projectsMapper;
    }

    public List<ShowMediConnectDTO> showAllBoards(Map<String, Object> parameter) {

        return projectMapper.showAllBoards(parameter);
    }

    public int deleteBoard(Map<String,List<Integer>> postCheckbox) {

        return projectMapper.deleteBoard(postCheckbox);

    }
}
