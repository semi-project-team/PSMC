package com.javaclass.psmc.theraLink.model.dto;

import com.javaclass.psmc.common.model.dto.TheraChatDTO;
import com.javaclass.psmc.common.model.dto.TheraLinkDTO;
import lombok.*;

import java.time.LocalDate;
import java.util.List;


public class TheraLinkWithMonthDTO {

    private int theraLinkNo;
    private int projectNo;
    private String theraTitle;
    private String theraContents;
    private String theraStatus;
    private LocalDate theraBoardDate;
    private String month;
    private int comment;
    private String day;
    private List<TheraChatDTO> theraChatDTOS;
    private List<TheraLinkPhotoDTO> theraLinkPhotoDTOS;

    public TheraLinkWithMonthDTO(){}

    public TheraLinkWithMonthDTO(int theraLinkNo, int projectNo, String theraTitle, String theraContents, String theraStatus, LocalDate theraBoardDate, String month, int comment, String day, List<TheraChatDTO> theraChatDTOS, List<TheraLinkPhotoDTO> theraLinkPhotoDTOS) {
        this.theraLinkNo = theraLinkNo;
        this.projectNo = projectNo;
        this.theraTitle = theraTitle;
        this.theraContents = theraContents;
        this.theraStatus = theraStatus;
        this.theraBoardDate = theraBoardDate;
        this.month = month;
        this.comment = comment;
        this.day = day;
        this.theraChatDTOS = theraChatDTOS;
        this.theraLinkPhotoDTOS = theraLinkPhotoDTOS;
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

    public LocalDate getTheraBoardDate() {
        return theraBoardDate;
    }

    public void setTheraBoardDate(LocalDate theraBoardDate) {
        this.theraBoardDate = theraBoardDate;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getComment() {
        return comment;
    }

    public void setComment(int comment) {
        this.comment = comment;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public List<TheraChatDTO> getTheraChatDTOS() {
        return theraChatDTOS;
    }

    public void setTheraChatDTOS(List<TheraChatDTO> theraChatDTOS) {
        this.theraChatDTOS = theraChatDTOS;
    }

    public List<TheraLinkPhotoDTO> getTheraLinkPhotoDTOS() {
        return theraLinkPhotoDTOS;
    }

    public void setTheraLinkPhotoDTOS(List<TheraLinkPhotoDTO> theraLinkPhotoDTOS) {
        this.theraLinkPhotoDTOS = theraLinkPhotoDTOS;
    }

    @Override
    public String toString() {
        return "TheraLinkWithMonthDTO{" +
                "theraLinkNo=" + theraLinkNo +
                ", projectNo=" + projectNo +
                ", theraTitle='" + theraTitle + '\'' +
                ", theraContents='" + theraContents + '\'' +
                ", theraStatus='" + theraStatus + '\'' +
                ", theraBoardDate=" + theraBoardDate +
                ", month='" + month + '\'' +
                ", comment=" + comment +
                ", day='" + day + '\'' +
                ", theraChatDTOS=" + theraChatDTOS +
                ", theraLinkPhotoDTOS=" + theraLinkPhotoDTOS +
                '}';
    }
}
