package com.javaclass.psmc.mediConnect.model.dao;

import com.javaclass.psmc.mediConnect.model.dto.ShowAllProjectsDTO;
import com.javaclass.psmc.mediConnect.model.dto.ShowMediConnectDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ProjectsMapper {
    List<ShowAllProjectsDTO> showAllProjects();

    List<ShowMediConnectDTO> showAllBoards(Map<String, Object> parameter);

}
