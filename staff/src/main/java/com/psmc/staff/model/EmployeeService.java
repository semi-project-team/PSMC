package com.psmc.staff.model;

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
    public List<EmployeeDTO> findAllEmployee() {

        return employeeMapper.findAllEmployee();
    }

    public List<EmployeeDTO> searchByParam(EmployeeDTO employeeDTO) {

        return employeeMapper.searchByParam(employeeDTO);
    }

    public List<EmployeeToMedicalFieldDTO> findMemberByFieldCode(Map<String, String> parameter) {

        return employeeMapper.findMemberByFieldCode(parameter);
    }
}
