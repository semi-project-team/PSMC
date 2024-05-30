package com.javaclass.psmc.mediConnect.model.dto;

import com.javaclass.psmc.common.model.dto.InjuryDTO;
import com.javaclass.psmc.common.model.dto.PatientDTO;
import lombok.*;



public class NewProjectShowDTO {

    private int projectNo;
    private String pmCode;
    private PatientDTO patientDTO;
    private InjuryDTO injuryDTO;

    public NewProjectShowDTO() {
    }

    public NewProjectShowDTO(int projectNo, String pmCode, PatientDTO patientDTO, InjuryDTO injuryDTO) {
        this.projectNo = projectNo;
        this.pmCode = pmCode;
        this.patientDTO = patientDTO;
        this.injuryDTO = injuryDTO;
    }

    public int getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(int projectNo) {
        this.projectNo = projectNo;
    }

    public String getPmCode() {
        return pmCode;
    }

    public void setPmCode(String pmCode) {
        this.pmCode = pmCode;
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
        return "NewProjectShowDTO{" +
                "projectNo=" + projectNo +
                ", pmCode='" + pmCode + '\'' +
                ", patientDTO=" + patientDTO +
                ", injuryDTO=" + injuryDTO +
                '}';
    }
}
