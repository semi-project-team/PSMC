package com.javaclass.psmc.mediConnect.model.dto;

import com.javaclass.psmc.common.model.dto.AssignProjectDTO;
import com.javaclass.psmc.common.model.dto.CreateProjectDTO;
import com.javaclass.psmc.common.model.dto.InjuryDTO;
import com.javaclass.psmc.common.model.dto.PatientDTO;
import lombok.*;

import java.util.List;

public class ShowAllProjectsDTO {

    private int projectNo;
    private int patientNo;
    private InjuryDTO injuryDTO;
    private PatientDTO patientDTO;
    private CreateProjectDTO createProjectDTO;
    private AssignProjectDTO assignProjectDTO;

    public ShowAllProjectsDTO() {
    }

    public ShowAllProjectsDTO(int projectNo, int patientNo, InjuryDTO injuryDTO, PatientDTO patientDTO, CreateProjectDTO createProjectDTO, AssignProjectDTO assignProjectDTO) {
        this.projectNo = projectNo;
        this.patientNo = patientNo;
        this.injuryDTO = injuryDTO;
        this.patientDTO = patientDTO;
        this.createProjectDTO = createProjectDTO;
        this.assignProjectDTO = assignProjectDTO;
    }

    public int getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(int projectNo) {
        this.projectNo = projectNo;
    }

    public int getPatientNo() {
        return patientNo;
    }

    public void setPatientNo(int patientNo) {
        this.patientNo = patientNo;
    }

    public InjuryDTO getInjuryDTO() {
        return injuryDTO;
    }

    public void setInjuryDTO(InjuryDTO injuryDTO) {
        this.injuryDTO = injuryDTO;
    }

    public PatientDTO getPatientDTO() {
        return patientDTO;
    }

    public void setPatientDTO(PatientDTO patientDTO) {
        this.patientDTO = patientDTO;
    }

    public CreateProjectDTO getCreateProjectDTO() {
        return createProjectDTO;
    }

    public void setCreateProjectDTO(CreateProjectDTO createProjectDTO) {
        this.createProjectDTO = createProjectDTO;
    }

    public AssignProjectDTO getAssignProjectDTO() {
        return assignProjectDTO;
    }

    public void setAssignProjectDTO(AssignProjectDTO assignProjectDTO) {
        this.assignProjectDTO = assignProjectDTO;
    }

    @Override
    public String toString() {
        return "ShowAllProjectsDTO{" +
                "projectNo=" + projectNo +
                ", patientNo=" + patientNo +
                ", injuryDTO=" + injuryDTO +
                ", patientDTO=" + patientDTO +
                ", createProjectDTO=" + createProjectDTO +
                ", assignProjectDTO=" + assignProjectDTO +
                '}';
    }
}
