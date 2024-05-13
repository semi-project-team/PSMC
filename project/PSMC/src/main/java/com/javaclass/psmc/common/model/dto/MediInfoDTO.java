package com.javaclass.psmc.common.model.dto;

import lombok.*;

import java.sql.Date;
import java.time.LocalDateTime;

public class MediInfoDTO {

    private int mediCode;
    private Date mediDate;
    private int projectNo;
    private int timeCode;
    private LocalDateTime mediRegDate;
    private String mediStatus;

    public MediInfoDTO(){}

    public MediInfoDTO(int mediCode, Date mediDate, int projectNo, int timeCode, LocalDateTime mediRegDate, String mediStatus) {
        this.mediCode = mediCode;
        this.mediDate = mediDate;
        this.projectNo = projectNo;
        this.timeCode = timeCode;
        this.mediRegDate = mediRegDate;
        this.mediStatus = mediStatus;
    }

    public int getMediCode() {
        return mediCode;
    }

    public void setMediCode(int mediCode) {
        this.mediCode = mediCode;
    }

    public Date getMediDate() {
        return mediDate;
    }

    public void setMediDate(Date mediDate) {
        this.mediDate = mediDate;
    }

    public int getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(int projectNo) {
        this.projectNo = projectNo;
    }

    public int getTimeCode() {
        return timeCode;
    }

    public void setTimeCode(int timeCode) {
        this.timeCode = timeCode;
    }

    public LocalDateTime getMediRegDate() {
        return mediRegDate;
    }

    public void setMediRegDate(LocalDateTime mediRegDate) {
        this.mediRegDate = mediRegDate;
    }

    public String getMediStatus() {
        return mediStatus;
    }

    public void setMediStatus(String mediStatus) {
        this.mediStatus = mediStatus;
    }

    @Override
    public String toString() {
        return "MediInfoDTO{" +
                "mediCode=" + mediCode +
                ", mediDate=" + mediDate +
                ", projectNo=" + projectNo +
                ", timeCode=" + timeCode +
                ", mediRegDate=" + mediRegDate +
                ", mediStatus='" + mediStatus + '\'' +
                '}';
    }
}
