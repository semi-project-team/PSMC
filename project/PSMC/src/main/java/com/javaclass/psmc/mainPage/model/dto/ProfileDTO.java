package com.javaclass.psmc.mainPage.model.dto;

import com.javaclass.psmc.common.model.dto.MedicalFieldDTO;
import com.javaclass.psmc.common.model.dto.PositionDTO;
import lombok.*;


public class ProfileDTO {

    private String pmCode;
    private String name;
    private int fieldCode;
    private int positionCode;
    private String officeNum;
    private String email;
    private PositionDTO positionDTO;
    private MedicalFieldDTO medicalFieldDTO;

    public ProfileDTO(){}

    public ProfileDTO(String pmCode, String name, int fieldCode, int positionCode, String officeNum, String email, PositionDTO positionDTO, MedicalFieldDTO medicalFieldDTO) {
        this.pmCode = pmCode;
        this.name = name;
        this.fieldCode = fieldCode;
        this.positionCode = positionCode;
        this.officeNum = officeNum;
        this.email = email;
        this.positionDTO = positionDTO;
        this.medicalFieldDTO = medicalFieldDTO;
    }

    public String getPmCode() {
        return pmCode;
    }

    public void setPmCode(String pmCode) {
        this.pmCode = pmCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFieldCode() {
        return fieldCode;
    }

    public void setFieldCode(int fieldCode) {
        this.fieldCode = fieldCode;
    }

    public int getPositionCode() {
        return positionCode;
    }

    public void setPositionCode(int positionCode) {
        this.positionCode = positionCode;
    }

    public String getOfficeNum() {
        return officeNum;
    }

    public void setOfficeNum(String officeNum) {
        this.officeNum = officeNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PositionDTO getPositionDTO() {
        return positionDTO;
    }

    public void setPositionDTO(PositionDTO positionDTO) {
        this.positionDTO = positionDTO;
    }

    public MedicalFieldDTO getMedicalFieldDTO() {
        return medicalFieldDTO;
    }

    public void setMedicalFieldDTO(MedicalFieldDTO medicalFieldDTO) {
        this.medicalFieldDTO = medicalFieldDTO;
    }

    @Override
    public String toString() {
        return "ProfileDTO{" +
                "pmCode='" + pmCode + '\'' +
                ", name='" + name + '\'' +
                ", fieldCode=" + fieldCode +
                ", positionCode=" + positionCode +
                ", officeNum='" + officeNum + '\'' +
                ", email='" + email + '\'' +
                ", positionDTO=" + positionDTO +
                ", medicalFieldDTO=" + medicalFieldDTO +
                '}';
    }
}
