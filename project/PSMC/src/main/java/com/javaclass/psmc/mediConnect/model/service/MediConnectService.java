package com.javaclass.psmc.mediConnect.model.service;

import com.javaclass.psmc.common.model.dto.EmployeeDTO;
import com.javaclass.psmc.mediConnect.model.dao.ProjectsMapper;
import com.javaclass.psmc.mediConnect.model.dto.ShowAllMediChatDTO;
import com.javaclass.psmc.mediConnect.model.dto.ShowAllProjectsDTO;
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


    public ShowAllProjectsDTO showPatientDetail(Map<String, Object> parameter) {

        return projectMapper.showPatientDetail(parameter);
    }

    public ShowMediConnectDTO showBoardDetail(Map<String, Object> parameter) {

        return projectMapper.showBoardDetail(parameter);
    }

    public EmployeeDTO showEmployee(Map<String, Object> parameter) {

        return projectMapper.showEmployee(parameter);
    }

    public List<ShowAllMediChatDTO> showMediChatDetail(Map<String, Object> parameter) {

        return projectMapper.showMediChatDetail(parameter);
    }

    public int registNewMessage(ShowAllMediChatDTO showAllMediChatDTO) {

        return projectMapper.registNewMessage(showAllMediChatDTO);
    }

    public int deleteChat(Map<String, List<Integer>> param) {

        return projectMapper.deleteChat(param);
    }

    public ShowAllMediChatDTO showNewChat(int mediNo) {

        return projectMapper.showNewChat(mediNo);
    }
}
