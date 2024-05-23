package com.javaclass.psmc.mainPage.model.dto;

import lombok.*;


public class TheraJSONDTO {

    private String projectNo;
    private String date;
    private String pmCode;

    public TheraJSONDTO(){}

    public TheraJSONDTO(String projectNo, String date, String pmCode) {
        this.projectNo = projectNo;
        this.date = date;
        this.pmCode = pmCode;
    }

    public String getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPmCode() {
        return pmCode;
    }

    public void setPmCode(String pmCode) {
        this.pmCode = pmCode;
    }

    @Override
    public String toString() {
        return "TheraJSONDTO{" +
                "projectNo='" + projectNo + '\'' +
                ", date='" + date + '\'' +
                ", pmCode='" + pmCode + '\'' +
                '}';
    }
}
