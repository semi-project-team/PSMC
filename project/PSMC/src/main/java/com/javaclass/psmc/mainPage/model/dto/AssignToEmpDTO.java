package com.javaclass.psmc.mainPage.model.dto;

import com.javaclass.psmc.common.model.dto.EmployeeDTO;
import lombok.*;


public class AssignToEmpDTO {

    private EmployeeDTO employeeDTO;

    public AssignToEmpDTO(){}

    public AssignToEmpDTO(EmployeeDTO employeeDTO) {
        this.employeeDTO = employeeDTO;
    }

    public EmployeeDTO getEmployeeDTO() {
        return employeeDTO;
    }

    public void setEmployeeDTO(EmployeeDTO employeeDTO) {
        this.employeeDTO = employeeDTO;
    }

    @Override
    public String toString() {
        return "AssignToEmpDTO{" +
                "employeeDTO=" + employeeDTO +
                '}';
    }
}
