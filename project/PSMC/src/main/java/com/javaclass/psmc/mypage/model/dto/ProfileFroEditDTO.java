package com.javaclass.psmc.mypage.model.dto;

import com.javaclass.psmc.common.model.dto.EmployeeDTO;
import com.javaclass.psmc.common.model.dto.MemberRegistDTO;

public class ProfileFroEditDTO {

    private EmployeeDTO employeeDTO;
    private MemberRegistDTO memberRegistDTO;

    public ProfileFroEditDTO(){

    }

    public ProfileFroEditDTO(EmployeeDTO employeeDTO, MemberRegistDTO memberRegistDTO) {
        this.employeeDTO = employeeDTO;
        this.memberRegistDTO = memberRegistDTO;
    }

    public EmployeeDTO getEmployeeDTO() {
        return employeeDTO;
    }

    public void setEmployeeDTO(EmployeeDTO employeeDTO) {
        this.employeeDTO = employeeDTO;
    }

    public MemberRegistDTO getMemberRegistDTO() {
        return memberRegistDTO;
    }

    public void setMemberRegistDTO(MemberRegistDTO memberRegistDTO) {
        this.memberRegistDTO = memberRegistDTO;
    }

    @Override
    public String toString() {
        return "ProfileFroEditDTO{" +
                "employeeDTO=" + employeeDTO +
                ", memberRegistDTO=" + memberRegistDTO +
                '}';
    }
}
