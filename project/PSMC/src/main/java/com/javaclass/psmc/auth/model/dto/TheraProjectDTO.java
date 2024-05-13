package com.javaclass.psmc.auth.model.dto;

import java.sql.Date;
import java.sql.Time;

public class TheraProjectDTO {

    private Time start;
    private Time end;
    private String patientName;
    private int projectNo;
    private String injuryName;
    private Date theraDate;

    public TheraProjectDTO(){}

    public TheraProjectDTO(Time start, Time end, String patientName, int projectNo, String injuryName, Date theraDate) {
        this.start = start;
        this.end = end;
        this.patientName = patientName;
        this.projectNo = projectNo;
        this.injuryName = injuryName;
        this.theraDate = theraDate;
    }

    public Time getStart() {
        return start;
    }

    public void setStart(Time start) {
        this.start = start;
    }

    public Time getEnd() {
        return end;
    }

    public void setEnd(Time end) {
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
                "start=" + start +
                ", end=" + end +
                ", patientName='" + patientName + '\'' +
                ", projectNo=" + projectNo +
                ", injuryName='" + injuryName + '\'' +
                ", theraDate=" + theraDate +
                '}';
    }
}
