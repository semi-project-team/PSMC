package com.javaclass.psmc.mainPage.model.dto;

import lombok.*;


public class TodayAllMediDTO {

    private int mediCode;
    private int timeCode;

    public TodayAllMediDTO(){}

    public TodayAllMediDTO(int mediCode, int timeCode) {
        this.mediCode = mediCode;
        this.timeCode = timeCode;
    }

    public int getMediCode() {
        return mediCode;
    }

    public void setMediCode(int mediCode) {
        this.mediCode = mediCode;
    }

    public int getTimeCode() {
        return timeCode;
    }

    public void setTimeCode(int timeCode) {
        this.timeCode = timeCode;
    }

    @Override
    public String toString() {
        return "TodayAllMediDTO{" +
                "mediCode=" + mediCode +
                ", timeCode=" + timeCode +
                '}';
    }
}
