package com.javaclass.psmc.common.model.dto;

import lombok.*;


public class AssignProjectDTO {

    private int projectNo;
    private String pmCode;

    public AssignProjectDTO(){}

    public AssignProjectDTO(int projectNo, String pmCode) {
        this.projectNo = projectNo;
        this.pmCode = pmCode;
    }

    public int getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(int projectNo) {
        this.projectNo = projectNo;
    }

    public String getPmCode() {
        return pmCode;
    }

    public void setPmCode(String pmCode) {
        this.pmCode = pmCode;
    }

    @Override
    public String toString() {
        return "AssignProjectDTO{" +
                "projectNo=" + projectNo +
                ", pmCode='" + pmCode + '\'' +
                '}';
    }
}


