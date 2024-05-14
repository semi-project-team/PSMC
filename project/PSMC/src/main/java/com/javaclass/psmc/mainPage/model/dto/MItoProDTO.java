package com.javaclass.psmc.mainPage.model.dto;

import lombok.*;

import java.sql.Date;

public class MItoProDTO {
    private int mediCode;
    private Date mediDate;
    private int day;
    ConnectProjectDTO connectProjectDTO;

    public MItoProDTO(){}

    public MItoProDTO(int mediCode, Date mediDate, int day, ConnectProjectDTO connectProjectDTO) {
        this.mediCode = mediCode;
        this.mediDate = mediDate;
        this.day = day;
        this.connectProjectDTO = connectProjectDTO;
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
        return "MItoProDTO{" +
                "mediCode=" + mediCode +
                ", mediDate=" + mediDate +
                ", day=" + day +
                ", connectProjectDTO=" + connectProjectDTO +
                '}';
    }
}
