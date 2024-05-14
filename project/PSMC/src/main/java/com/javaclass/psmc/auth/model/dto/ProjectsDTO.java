package com.javaclass.psmc.auth.model.dto;

import com.javaclass.psmc.common.model.dto.ResTimeDTO;
import lombok.*;

import java.util.Arrays;
import java.util.List;

public class ProjectsDTO {
    private String mediCode;
    private int projectNo;
    private ResTimeDTO resTimeDTOS;
    private String patientName;
    private String injuryName;
    private String[] time;

    public ProjectsDTO(){}

    public ProjectsDTO(String mediCode, int projectNo, ResTimeDTO resTimeDTOS, String patientName, String injuryName, String[] time) {
        this.mediCode = mediCode;
        this.projectNo = projectNo;
        this.resTimeDTOS = resTimeDTOS;
        this.patientName = patientName;
        this.injuryName = injuryName;
        this.time = time;
    }

    public String getMediCode() {
        return mediCode;
    }

    public void setMediCode(String mediCode) {
        this.mediCode = mediCode;
    }

    public int getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(int projectNo) {
        this.projectNo = projectNo;
    }

    public ResTimeDTO getResTimeDTOS() {
        return resTimeDTOS;
    }

    public void setResTimeDTOS(ResTimeDTO resTimeDTOS) {
        this.resTimeDTOS = resTimeDTOS;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getInjuryName() {
        return injuryName;
    }

    public void setInjuryName(String injuryName) {
        this.injuryName = injuryName;
    }

    public String[] getTime() {
        return time;
    }

    public void setTime(String[] time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "ProjectsDTO{" +
                "mediCode='" + mediCode + '\'' +
                ", projectNo=" + projectNo +
                ", resTimeDTOS=" + resTimeDTOS +
                ", patientName='" + patientName + '\'' +
                ", injuryName='" + injuryName + '\'' +
                ", time=" + Arrays.toString(time) +
                '}';
    }
}
