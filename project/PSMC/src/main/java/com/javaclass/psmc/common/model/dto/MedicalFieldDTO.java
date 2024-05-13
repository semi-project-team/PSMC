package com.javaclass.psmc.common.model.dto;

import lombok.*;


public class MedicalFieldDTO {

    private int fieldCode;
    private String fieldName;

    public MedicalFieldDTO(){}

    public MedicalFieldDTO(int fieldCode, String fieldName) {
        this.fieldCode = fieldCode;
        this.fieldName = fieldName;
    }

    public int getFieldCode() {
        return fieldCode;
    }

    public void setFieldCode(int fieldCode) {
        this.fieldCode = fieldCode;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    @Override
    public String toString() {
        return "MedicalFieldDTO{" +
                "fieldCode=" + fieldCode +
                ", fieldName='" + fieldName + '\'' +
                '}';
    }
}
