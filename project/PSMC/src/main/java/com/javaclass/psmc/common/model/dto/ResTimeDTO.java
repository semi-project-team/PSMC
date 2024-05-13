package com.javaclass.psmc.common.model.dto;

import lombok.*;

import java.sql.Time;

public class ResTimeDTO {

    private int timeCode;
    private Time timeVal;

    public ResTimeDTO(){}

    public ResTimeDTO(int timeCode, Time timeVal) {
        this.timeCode = timeCode;
        this.timeVal = timeVal;
    }

    public int getTimeCode() {
        return timeCode;
    }

    public void setTimeCode(int timeCode) {
        this.timeCode = timeCode;
    }

    public Time getTimeVal() {
        return timeVal;
    }

    public void setTimeVal(Time timeVal) {
        this.timeVal = timeVal;
    }

    @Override
    public String toString() {
        return "ResTimeDTO{" +
                "timeCode=" + timeCode +
                ", timeVal=" + timeVal +
                '}';
    }
}
