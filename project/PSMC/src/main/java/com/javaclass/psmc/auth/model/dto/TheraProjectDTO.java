package com.javaclass.psmc.auth.model.dto;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;

public class TheraProjectDTO {

    private String theraCode;
    private LocalTime start;
    private LocalTime end;
    private String patientName;
    private int projectNo;
    private String injuryName;
    private Date theraDate;

    public TheraProjectDTO(){}

    public TheraProjectDTO(String theraCode, LocalTime start, LocalTime end, String patientName, int projectNo, String injuryName, Date theraDate) {
        this.theraCode = theraCode;
        this.start = start;
        this.end = end;
        this.patientName = patientName;
        this.projectNo = projectNo;
        this.injuryName = injuryName;
        this.theraDate = theraDate;
    }

    public String getTheraCode() {
        return theraCode;
    }

    public void setTheraCode(String theraCode) {
        this.theraCode = theraCode;
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

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public int getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(int projectNo) {
        this.projectNo = projectNo;
    }

    public String getInjuryName() {
        return injuryName;
    }

    public void setInjuryName(String injuryName) {
        this.injuryName = injuryName;
    }

    public Date getTheraDate() {
        return theraDate;
    }

    public void setTheraDate(Date theraDate) {
        this.theraDate = theraDate;
    }

    @Override
    public String toString() {
        return "TheraProjectDTO{" +
                "theraCode='" + theraCode + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", patientName='" + patientName + '\'' +
                ", projectNo=" + projectNo +
                ", injuryName='" + injuryName + '\'' +
                ", theraDate=" + theraDate +
                '}';
    }
}
