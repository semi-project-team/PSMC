package com.javaclass.psmc.common.model.dto;

import lombok.*;

import java.time.LocalDateTime;


public class MediConnectDTO {

    private int mediNo;
    private String mediTitle;
    private String mediContent;
    private int projectNo;
    private String mediStatus;
    private LocalDateTime mediBoardDate;

    public MediConnectDTO(){}

    public MediConnectDTO(int mediNo, String mediTitle, String mediContent, int projectNo, String mediStatus, LocalDateTime mediBoardDate) {
        this.mediNo = mediNo;
        this.mediTitle = mediTitle;
        this.mediContent = mediContent;
        this.projectNo = projectNo;
        this.mediStatus = mediStatus;
        this.mediBoardDate = mediBoardDate;
    }

    public int getMediNo() {
        return mediNo;
    }

    public void setMediNo(int mediNo) {
        this.mediNo = mediNo;
    }

    public String getMediTitle() {
        return mediTitle;
    }

    public void setMediTitle(String mediTitle) {
        this.mediTitle = mediTitle;
    }

    public String getMediContent() {
        return mediContent;
    }

    public void setMediContent(String mediContent) {
        this.mediContent = mediContent;
    }

    public int getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(int projectNo) {
        this.projectNo = projectNo;
    }

    public String getMediStatus() {
        return mediStatus;
    }

    public void setMediStatus(String mediStatus) {
        this.mediStatus = mediStatus;
    }

    public LocalDateTime getMediBoardDate() {
        return mediBoardDate;
    }

    public void setMediBoardDate(LocalDateTime mediBoardDate) {
        this.mediBoardDate = mediBoardDate;
    }

    @Override
    public String toString() {
        return "MediConnectDTO{" +
                "mediNo=" + mediNo +
                ", mediTitle='" + mediTitle + '\'' +
                ", mediContent='" + mediContent + '\'' +
                ", projectNo=" + projectNo +
                ", mediStatus='" + mediStatus + '\'' +
                ", mediBoardDate=" + mediBoardDate +
                '}';
    }
}
