package com.javaclass.psmc.staff.model.service;

import com.javaclass.psmc.common.model.dto.MedicalFieldDTO;
import com.javaclass.psmc.staff.model.dao.EmployeeMapper;
import com.javaclass.psmc.staff.model.dto.EmployeeFieldPositionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {
    private final EmployeeMapper employeeMapper;

    @Autowired
    public EmployeeService(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }
    public List<EmployeeFieldPositionDTO> findAllEmployee() {

        return employeeMapper.findAllEmployee();
    }

    public List<EmployeeFieldPositionDTO> searchByParam(EmployeeFieldPositionDTO employeeDTO) {

        return employeeMapper.searchByParam(employeeDTO);
    }

    public List<EmployeeFieldPositionDTO> findMemberByFieldCode(Map<String, String> parameter) {

        return employeeMapper.findMemberByFieldCode(parameter);
    }

    public List<MedicalFieldDTO> findAllField() {

        return employeeMapper.findAllField();
    }
}