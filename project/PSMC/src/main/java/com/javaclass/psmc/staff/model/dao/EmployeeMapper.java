package com.javaclass.psmc.staff.model.dao;

import com.javaclass.psmc.common.model.dto.MedicalFieldDTO;
import com.javaclass.psmc.staff.model.dto.EmployeeFieldPositionDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
@Mapper
public interface EmployeeMapper {
    List<EmployeeFieldPositionDTO> findAllEmployee();

    List<EmployeeFieldPositionDTO> searchByParam(EmployeeFieldPositionDTO employeeDTO);

    List<EmployeeFieldPositionDTO> findMemberByFieldCode(Map<String, String> parameter);

    List<MedicalFieldDTO> findAllField();
}