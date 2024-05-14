package com.javaclass.psmc.mainPage.model.dto;

import com.javaclass.psmc.common.model.dto.EmployeeDTO;
import lombok.*;


public class CreateToEmpDTO {
    private EmployeeDTO employeeDTO;

    public CreateToEmpDTO(){}

    public CreateToEmpDTO(EmployeeDTO employeeDTO) {
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
        return "CreateToEmpDTO{" +
                "employeeDTO=" + employeeDTO +
                '}';
    }
}
