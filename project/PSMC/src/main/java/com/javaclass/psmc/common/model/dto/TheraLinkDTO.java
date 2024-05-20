package com.javaclass.psmc.common.model.dto;

import lombok.*;

import java.time.LocalDateTime;


public class TheraLinkDTO {

    private int projectNo;
    private int theraLinkNo;
    private String theraTitle;
    private String theraContents;
    private String theraStatus;
    private LocalDateTime theraBoardDate;

    public TheraLinkDTO(){}

    public TheraLinkDTO(int projectNo, int theraLinkNo, String theraTitle, String theraContents, String theraStatus, LocalDateTime theraBoardDate) {
        this.projectNo = projectNo;
        this.theraLinkNo = theraLinkNo;
        this.theraTitle = theraTitle;
        this.theraContents = theraContents;
        this.theraStatus = theraStatus;
        this.theraBoardDate = theraBoardDate;
    }

    public int getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(int projectNo) {
        this.projectNo = projectNo;
    }

    public int getTheraLinkNo() {
        return theraLinkNo;
    }

    public void setTheraLinkNo(int theraLinkNo) {
        this.theraLinkNo = theraLinkNo;
    }

    public String getTheraTitle() {
        return theraTitle;
    }

    public void setTheraTitle(String theraTitle) {
        this.theraTitle = theraTitle;
    }

    public String getTheraContents() {
        return theraContents;
    }

    public void setTheraContents(String theraContents) {
        this.theraContents = theraContents;
    }

    public String getTheraStatus() {
        return theraStatus;
    }

    public void setTheraStatus(String theraStatus) {
        this.theraStatus = theraStatus;
    }

    public LocalDateTime getTheraBoardDate() {
        return theraBoardDate;
    }

    public void setTheraBoardDate(LocalDateTime theraBoardDate) {
        this.theraBoardDate = theraBoardDate;
    }

    @Override
    public String toString() {
        return "TheraLinkDTO{" +
                "projectNo=" + projectNo +
                ", theraLinkNo=" + theraLinkNo +
                ", theraTitle='" + theraTitle + '\'' +
                ", theraContents='" + theraContents + '\'' +
                ", theraStatus='" + theraStatus + '\'' +
                ", theraBoardDate=" + theraBoardDate +
                '}';
    }
}
