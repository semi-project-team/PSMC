package com.javaclass.psmc.mainPage.model.dto;

import lombok.*;

import java.sql.Date;
import java.sql.Time;

public class TheraToProDTO {

    private int theraCode;
    private Date theraDate;
    private Time start;
    private Time end;
    private int day;
    private ConnectProjectDTO connectProjectDTO;

    public TheraToProDTO(){}

    public TheraToProDTO(int theraCode, Date theraDate, Time start, Time end, int day, ConnectProjectDTO connectProjectDTO) {
        this.theraCode = theraCode;
        this.theraDate = theraDate;
        this.start = start;
        this.end = end;
        this.day = day;
        this.connectProjectDTO = connectProjectDTO;
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

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public ConnectProjectDTO getConnectProjectDTO() {
        return connectProjectDTO;
    }

    public void setConnectProjectDTO(ConnectProjectDTO connectProjectDTO) {
        this.connectProjectDTO = connectProjectDTO;
    }

    @Override
    public String toString() {
        return "TheraToProDTO{" +
                "theraCode=" + theraCode +
                ", theraDate=" + theraDate +
                ", start=" + start +
                ", end=" + end +
                ", day=" + day +
                ", connectProjectDTO=" + connectProjectDTO +
                '}';
    }
}
