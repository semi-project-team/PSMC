package com.javaclass.psmc.theraLink.model.dto;

import lombok.*;

import java.time.LocalDateTime;

public class TheraChatForBlogDTO {

    private int theraChatNo;
    private int theraLinkNo;
    private String pmCode;
    private String theraChatContent;
    private LocalDateTime theraChatBoardDate;
    private String theraChatStatus;
    private String name;
    private String employeeFilepath;

    public TheraChatForBlogDTO(){}

    public TheraChatForBlogDTO(int theraChatNo, int theraLinkNo, String pmCode, String theraChatContent, LocalDateTime theraChatBoardDate, String theraChatStatus, String name, String employeeFilepath) {
        this.theraChatNo = theraChatNo;
        this.theraLinkNo = theraLinkNo;
        this.pmCode = pmCode;
        this.theraChatContent = theraChatContent;
        this.theraChatBoardDate = theraChatBoardDate;
        this.theraChatStatus = theraChatStatus;
        this.name = name;
        this.employeeFilepath = employeeFilepath;
    }

    public int getTheraChatNo() {
        return theraChatNo;
    }

    public void setTheraChatNo(int theraChatNo) {
        this.theraChatNo = theraChatNo;
    }

    public int getTheraLinkNo() {
        return theraLinkNo;
    }

    public void setTheraLinkNo(int theraLinkNo) {
        this.theraLinkNo = theraLinkNo;
    }

    public String getPmCode() {
        return pmCode;
    }

    public void setPmCode(String pmCode) {
        this.pmCode = pmCode;
    }

    public String getTheraChatContent() {
        return theraChatContent;
    }

    public void setTheraChatContent(String theraChatContent) {
        this.theraChatContent = theraChatContent;
    }

    public LocalDateTime getTheraChatBoardDate() {
        return theraChatBoardDate;
    }

    public void setTheraChatBoardDate(LocalDateTime theraChatBoardDate) {
        this.theraChatBoardDate = theraChatBoardDate;
    }

    public String getTheraChatStatus() {
        return theraChatStatus;
    }

    public void setTheraChatStatus(String theraChatStatus) {
        this.theraChatStatus = theraChatStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmployeeFilepath() {
        return employeeFilepath;
    }

    public void setEmployeeFilepath(String employeeFilepath) {
        this.employeeFilepath = employeeFilepath;
    }

    @Override
    public String toString() {
        return "TheraChatForBlogDTO{" +
                "theraChatNo=" + theraChatNo +
                ", theraLinkNo=" + theraLinkNo +
                ", pmCode='" + pmCode + '\'' +
                ", theraChatContent='" + theraChatContent + '\'' +
                ", theraChatBoardDate=" + theraChatBoardDate +
                ", theraChatStatus='" + theraChatStatus + '\'' +
                ", name='" + name + '\'' +
                ", employeeFilepath='" + employeeFilepath + '\'' +
                '}';
    }
}
