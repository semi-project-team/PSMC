package com.psmc.staff.model;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    List<EmployeeDTO> findAllEmployee();

}

