package com.javaclass.psmc.common.model.dto;

import lombok.*;

import java.time.LocalDateTime;


public class TheraChatDTO {

    private int theraChatNo;
    private int theraLinkNo;
    private int projectNo;
    private String theraChatContent;
    private LocalDateTime theraChatBoardDate;

    public TheraChatDTO(){}

    public TheraChatDTO(int theraChatNo, int theraLinkNo, int projectNo, String theraChatContent, LocalDateTime theraChatBoardDate) {
        this.theraChatNo = theraChatNo;
        this.theraLinkNo = theraLinkNo;
        this.projectNo = projectNo;
        this.theraChatContent = theraChatContent;
        this.theraChatBoardDate = theraChatBoardDate;
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

    public int getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(int projectNo) {
        this.projectNo = projectNo;
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

    @Override
    public String toString() {
        return "TheraChatDTO{" +
                "theraChatNo=" + theraChatNo +
                ", theraLinkNo=" + theraLinkNo +
                ", projectNo=" + projectNo +
                ", theraChatContent='" + theraChatContent + '\'' +
                ", theraChatBoardDate=" + theraChatBoardDate +
                '}';
    }
}
