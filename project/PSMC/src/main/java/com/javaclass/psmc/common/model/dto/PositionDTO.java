package com.javaclass.psmc.common.model.dto;

import lombok.*;

public class PositionDTO {

    private int positionCode;
    private String positionName;

    public PositionDTO(){}

    public PositionDTO(int positionCode, String positionName) {
        this.positionCode = positionCode;
        this.positionName = positionName;
    }

    public int getPositionCode() {
        return positionCode;
    }

    public void setPositionCode(int positionCode) {
        this.positionCode = positionCode;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    @Override
    public String toString() {
        return "PositionDTO{" +
                "positionCode=" + positionCode +
                ", positionName='" + positionName + '\'' +
                '}';
    }
}
