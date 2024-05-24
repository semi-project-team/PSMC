package com.psmc.staff.model;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface EmployeeMapper {
    List<EmployeeDTO> findAllEmployee();

    List<EmployeeDTO> searchByParam(EmployeeDTO employeeDTO);

    List<EmployeeToMedicalFieldDTO> findMemberByFieldCode(Map<String, String> parameter);
}

