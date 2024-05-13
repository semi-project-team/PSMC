package com.javaclass.psmc.common.model.dto;

import lombok.*;


public class InjuryDTO {

    private int injuryCode;
    private String injuryName;
    private int fieldCode;

    public InjuryDTO(){}

    public InjuryDTO(int injuryCode, String injuryName, int fieldCode) {
        this.injuryCode = injuryCode;
        this.injuryName = injuryName;
        this.fieldCode = fieldCode;
    }

    public int getInjuryCode() {
        return injuryCode;
    }

    public void setInjuryCode(int injuryCode) {
        this.injuryCode = injuryCode;
    }

    public String getInjuryName() {
        return injuryName;
    }

    public void setInjuryName(String injuryName) {
        this.injuryName = injuryName;
    }

    public int getFieldCode() {
        return fieldCode;
    }

    public void setFieldCode(int fieldCode) {
        this.fieldCode = fieldCode;
    }

    @Override
    public String toString() {
        return "InjuryDTO{" +
                "injuryCode=" + injuryCode +
                ", injuryName='" + injuryName + '\'' +
                ", fieldCode=" + fieldCode +
                '}';
    }
}
