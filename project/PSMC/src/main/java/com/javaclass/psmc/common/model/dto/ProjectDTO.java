package com.javaclass.psmc.common.model.dto;

import lombok.*;

import java.time.LocalDateTime;


public class ProjectDTO {

    private int projectNo;
    private int patientNo;
    private LocalDateTime projectDate;
    private String projectStatus;
    private int injuryCode;

    public ProjectDTO(){}

    public ProjectDTO(int projectNo, int patientNo, LocalDateTime projectDate, String projectStatus, int injuryCode) {
        this.projectNo = projectNo;
        this.patientNo = patientNo;
        this.projectDate = projectDate;
        this.projectStatus = projectStatus;
        this.injuryCode = injuryCode;
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

    public LocalDateTime getProjectDate() {
        return projectDate;
    }

    public void setProjectDate(LocalDateTime projectDate) {
        this.projectDate = projectDate;
    }

    public String getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(String projectStatus) {
        this.projectStatus = projectStatus;
    }

    public int getInjuryCode() {
        return injuryCode;
    }

    public void setInjuryCode(int injuryCode) {
        this.injuryCode = injuryCode;
    }

    @Override
    public String toString() {
        return "ProjectDTO{" +
                "projectNo=" + projectNo +
                ", patientNo=" + patientNo +
                ", projectDate=" + projectDate +
                ", projectStatus='" + projectStatus + '\'' +
                ", injuryCode=" + injuryCode +
                '}';
    }
}
