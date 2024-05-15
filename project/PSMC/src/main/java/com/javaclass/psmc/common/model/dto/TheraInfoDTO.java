package com.javaclass.psmc.common.model.dto;

import lombok.*;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.LocalTime;


public class TheraInfoDTO {

    private int theraCode;
    private Date theraDate;
    private int projectNo;
    private LocalDateTime theraRegDate;
    private String theraStatus;
    private LocalTime start;
    private LocalTime end;

    public TheraInfoDTO(){}

    public TheraInfoDTO(int theraCode, Date theraDate, int projectNo, LocalDateTime theraRegDate, String theraStatus, LocalTime start, LocalTime end) {
        this.theraCode = theraCode;
        this.theraDate = theraDate;
        this.projectNo = projectNo;
        this.theraRegDate = theraRegDate;
        this.theraStatus = theraStatus;
        this.start = start;
        this.end = end;
    }

    public int getTheraCode() {
        return theraCode;
    }

    public void setTheraCode(int theraCode) {
        this.theraCode = theraCode;
    }

    public Date getTheraDate() {
        return theraDate;
    }

    public void setTheraDate(Date theraDate) {
        this.theraDate = theraDate;
    }

    public int getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(int projectNo) {
        this.projectNo = projectNo;
    }

    public LocalDateTime getTheraRegDate() {
        return theraRegDate;
    }

    public void setTheraRegDate(LocalDateTime theraRegDate) {
        this.theraRegDate = theraRegDate;
    }

    public String getTheraStatus() {
        return theraStatus;
    }

    public void setTheraStatus(String theraStatus) {
        this.theraStatus = theraStatus;
    }

    public LocalTime getStart() {
        return start;
    }

    public void setStart(LocalTime start) {
        this.start = start;
    }

    public LocalTime getEnd() {
        return end;
    }

    public void setEnd(LocalTime end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "TheraInfoDTO{" +
                "theraCode=" + theraCode +
                ", theraDate=" + theraDate +
                ", projectNo=" + projectNo +
                ", theraRegDate=" + theraRegDate +
                ", theraStatus='" + theraStatus + '\'' +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
