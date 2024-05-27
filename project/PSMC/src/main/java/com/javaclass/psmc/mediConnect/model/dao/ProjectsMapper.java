package com.javaclass.psmc.mediConnect.model.dao;

import com.javaclass.psmc.common.model.dto.EmployeeDTO;
import com.javaclass.psmc.mediConnect.model.dto.ShowAllMediChatDTO;
import com.javaclass.psmc.mediConnect.model.dto.ShowAllProjectsDTO;
import com.javaclass.psmc.mediConnect.model.dto.ShowMediConnectDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface ProjectsMapper {
    List<ShowAllProjectsDTO> showAllProjects(String pmCode);

    List<ShowMediConnectDTO> showAllBoards(Map<String, Object> parameter);

    int deleteBoard(Map<String,List<Integer>> postCheckbox);

    int deleteProjects(Map<String, List<Integer>> projectParam);

    ShowAllProjectsDTO showPatientDetail(Map<String, Object> parameter);

    ShowMediConnectDTO showBoardDetail(Map<String, Object> parameter);

    EmployeeDTO showEmployee(Map<String, Object> parameter);

    List<ShowAllMediChatDTO> showMediChatDetail(Map<String, Object> parameter);

    int registNewMessage(ShowAllMediChatDTO showAllMediChatDTO);

    int deleteChat(Map<String, List<Integer>> param);


//    List<ShowMediConnectDTO> showBoardDetail(Map<String, Object> parameter);
}
