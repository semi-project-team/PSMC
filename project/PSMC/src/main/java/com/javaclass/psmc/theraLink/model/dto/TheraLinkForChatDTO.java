package com.javaclass.psmc.theraLink.model.dto;


import lombok.*;

import java.util.List;

public class TheraLinkForChatDTO {

    private String me;
    private int theraLinkNo;
    private String theraTitle;
    private String theraContents;
    private List<TheraChatForBlogDTO> theraChatForBlogDTOS;

    public  TheraLinkForChatDTO(){}

    public TheraLinkForChatDTO(String me, int theraLinkNo, String theraTitle, String theraContents, List<TheraChatForBlogDTO> theraChatForBlogDTOS) {
        this.me = me;
        this.theraLinkNo = theraLinkNo;
        this.theraTitle = theraTitle;
        this.theraContents = theraContents;
        this.theraChatForBlogDTOS = theraChatForBlogDTOS;
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

    public List<TheraChatForBlogDTO> getTheraChatForBlogDTOS() {
        return theraChatForBlogDTOS;
    }

    public void setTheraChatForBlogDTOS(List<TheraChatForBlogDTO> theraChatForBlogDTOS) {
        this.theraChatForBlogDTOS = theraChatForBlogDTOS;
    }

    @Override
    public String toString() {
        return "TheraLinkForChatDTO{" +
                "me='" + me + '\'' +
                ", theraLinkNo=" + theraLinkNo +
                ", theraTitle='" + theraTitle + '\'' +
                ", theraContents='" + theraContents + '\'' +
                ", theraChatForBlogDTOS=" + theraChatForBlogDTOS +
                '}';
    }
}
