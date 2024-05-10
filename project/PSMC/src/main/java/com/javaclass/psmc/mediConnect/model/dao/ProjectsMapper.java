package com.javaclass.psmc.mediConnect.model.dao;

import com.javaclass.psmc.mediConnect.model.dto.ShowAllProjectsDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProjectsMapper {
    List<ShowAllProjectsDTO> showAllProjects();

//    mapper

}
