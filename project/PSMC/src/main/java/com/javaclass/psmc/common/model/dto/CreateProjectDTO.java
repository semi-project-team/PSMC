package com.javaclass.psmc.common.model.dto;

import lombok.*;


public class CreateProjectDTO {

    private int projectNo;
    private String pmCode;

    public CreateProjectDTO(){}

    public CreateProjectDTO(int projectNo, String pmCode) {
        this.projectNo = projectNo;
        this.pmCode = pmCode;
    }

    public int getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(int projectNo) {
        this.projectNo = projectNo;
    }

    @Override
    public String toString() {
        return "CreateProjectDTO{" +
                "projectNo=" + projectNo +
                ", pmCode='" + pmCode + '\'' +
                '}';
    }

    public String getPmCode() {
        return pmCode;
    }

    public void setPmCode(String pmCode) {
        this.pmCode = pmCode;
    }
}
