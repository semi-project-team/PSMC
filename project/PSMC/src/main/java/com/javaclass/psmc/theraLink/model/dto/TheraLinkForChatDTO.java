package com.javaclass.psmc.theraLink.model.dto;


import lombok.*;

import java.util.List;

public class TheraLinkForChatDTO {

    private String me;
    private int theraLinkNo;
    private String theraTitle;
    private String theraContents;
    private String employeeSavedName;
    private List<TheraChatForBlogDTO> theraChatForBlogDTOS;
    private List<TheraLinkPhotoDTO> theraLinkPhotoDTOS;

    public  TheraLinkForChatDTO(){}

    public TheraLinkForChatDTO(String me, int theraLinkNo, String theraTitle, String theraContents, String employeeSavedName, List<TheraChatForBlogDTO> theraChatForBlogDTOS, List<TheraLinkPhotoDTO> theraLinkPhotoDTOS) {
        this.me = me;
        this.theraLinkNo = theraLinkNo;
        this.theraTitle = theraTitle;
        this.theraContents = theraContents;
        this.employeeSavedName = employeeSavedName;
        this.theraChatForBlogDTOS = theraChatForBlogDTOS;
        this.theraLinkPhotoDTOS = theraLinkPhotoDTOS;
    }

    public String getMe() {
        return me;
    }

    public void setMe(String me) {
        this.me = me;
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

    public String getEmployeeSavedName() {
        return employeeSavedName;
    }

    public void setEmployeeSavedName(String employeeSavedName) {
        this.employeeSavedName = employeeSavedName;
    }

    public List<TheraChatForBlogDTO> getTheraChatForBlogDTOS() {
        return theraChatForBlogDTOS;
    }

    public void setTheraChatForBlogDTOS(List<TheraChatForBlogDTO> theraChatForBlogDTOS) {
        this.theraChatForBlogDTOS = theraChatForBlogDTOS;
    }

    public List<TheraLinkPhotoDTO> getTheraLinkPhotoDTOS() {
        return theraLinkPhotoDTOS;
    }

    public void setTheraLinkPhotoDTOS(List<TheraLinkPhotoDTO> theraLinkPhotoDTOS) {
        this.theraLinkPhotoDTOS = theraLinkPhotoDTOS;
    }

    @Override
    public String toString() {
        return "TheraLinkForChatDTO{" +
                "me='" + me + '\'' +
                ", theraLinkNo=" + theraLinkNo +
                ", theraTitle='" + theraTitle + '\'' +
                ", theraContents='" + theraContents + '\'' +
                ", employeeSavedName='" + employeeSavedName + '\'' +
                ", theraChatForBlogDTOS=" + theraChatForBlogDTOS +
                ", theraLinkPhotoDTOS=" + theraLinkPhotoDTOS +
                '}';
    }
}
