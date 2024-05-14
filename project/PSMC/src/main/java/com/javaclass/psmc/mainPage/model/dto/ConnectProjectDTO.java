package com.javaclass.psmc.mainPage.model.dto;

import com.javaclass.psmc.common.model.dto.AssignProjectDTO;
import com.javaclass.psmc.common.model.dto.CreateProjectDTO;
import com.javaclass.psmc.common.model.dto.InjuryDTO;
import com.javaclass.psmc.common.model.dto.PatientDTO;
import lombok.*;


public class ConnectProjectDTO {

    private int projectNo;
    private CreateToEmpDTO create;
    private AssignToEmpDTO assign;
    private PatientDTO patientDTO;
    private InjuryDTO injuryDTO;

    public ConnectProjectDTO(){}

    public ConnectProjectDTO(int projectNo, CreateToEmpDTO create, AssignToEmpDTO assign, PatientDTO patientDTO, InjuryDTO injuryDTO) {
        this.projectNo = projectNo;
        this.create = create;
        this.assign = assign;
        this.patientDTO = patientDTO;
        this.injuryDTO = injuryDTO;
    }

    public int getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(int projectNo) {
        this.projectNo = projectNo;
    }

    public CreateToEmpDTO getCreate() {
        return create;
    }

    public void setCreate(CreateToEmpDTO create) {
        this.create = create;
    }

    public AssignToEmpDTO getAssign() {
        return assign;
    }

    public void setAssign(AssignToEmpDTO assign) {
        this.assign = assign;
    }

    public PatientDTO getPatientDTO() {
        return patientDTO;
    }

    public void setPatientDTO(PatientDTO patientDTO) {
        this.patientDTO = patientDTO;
    }

    public InjuryDTO getInjuryDTO() {
        return injuryDTO;
    }

    public void setInjuryDTO(InjuryDTO injuryDTO) {
        this.injuryDTO = injuryDTO;
    }

    @Override
    public String toString() {
        return "ConnectProjectDTO{" +
                "projectNo=" + projectNo +
                ", create=" + create +
                ", assign=" + assign +
                ", patientDTO=" + patientDTO +
                ", injuryDTO=" + injuryDTO +
                '}';
    }
}
