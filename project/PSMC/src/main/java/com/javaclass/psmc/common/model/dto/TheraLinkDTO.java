package com.javaclass.psmc.common.model.dto;

import lombok.*;

import java.time.LocalDateTime;


public class TheraLinkDTO {

    private int projectNo;
    private int theraLinkNo;
    private String title;
    private String contents;
    private String theraStatus;
    private LocalDateTime theraBoardDate;

    public TheraLinkDTO(){}

    public TheraLinkDTO(int projectNo, int theraLinkNo, String title, String contents, String theraStatus, LocalDateTime theraBoardDate) {
        this.projectNo = projectNo;
        this.theraLinkNo = theraLinkNo;
        this.title = title;
        this.contents = contents;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
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
                ", title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                ", theraStatus='" + theraStatus + '\'' +
                ", theraBoardDate=" + theraBoardDate +
                '}';
    }
}
