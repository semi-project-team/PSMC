package com.javaclass.psmc.theraLink.model.dto;

import lombok.*;


public class TheraLinkPhotoDTO {

    private int theralinkPhotoNo;
    private String theralinkOriginName;
    private String theralinkSavedName;
    private String theralinkFilepath;
    private int theralinkNo;
    private String theralinkPhotoStatus;

    public TheraLinkPhotoDTO(){}

    public TheraLinkPhotoDTO(int theralinkPhotoNo, String theralinkOriginName, String theralinkSavedName, String theralinkFilepath, int theralinkNo, String theralinkPhotoStatus) {
        this.theralinkPhotoNo = theralinkPhotoNo;
        this.theralinkOriginName = theralinkOriginName;
        this.theralinkSavedName = theralinkSavedName;
        this.theralinkFilepath = theralinkFilepath;
        this.theralinkNo = theralinkNo;
        this.theralinkPhotoStatus = theralinkPhotoStatus;
    }

    public int getTheralinkPhotoNo() {
        return theralinkPhotoNo;
    }

    public void setTheralinkPhotoNo(int theralinkPhotoNo) {
        this.theralinkPhotoNo = theralinkPhotoNo;
    }

    public String getTheralinkOriginName() {
        return theralinkOriginName;
    }

    public void setTheralinkOriginName(String theralinkOriginName) {
        this.theralinkOriginName = theralinkOriginName;
    }

    public String getTheralinkSavedName() {
        return theralinkSavedName;
    }

    public void setTheralinkSavedName(String theralinkSavedName) {
        this.theralinkSavedName = theralinkSavedName;
    }

    public String getTheralinkFilepath() {
        return theralinkFilepath;
    }

    public void setTheralinkFilepath(String theralinkFilepath) {
        this.theralinkFilepath = theralinkFilepath;
    }

    public int getTheralinkNo() {
        return theralinkNo;
    }

    public void setTheralinkNo(int theralinkNo) {
        this.theralinkNo = theralinkNo;
    }

    public String getTheralinkPhotoStatus() {
        return theralinkPhotoStatus;
    }

    public void setTheralinkPhotoStatus(String theralinkPhotoStatus) {
        this.theralinkPhotoStatus = theralinkPhotoStatus;
    }

    @Override
    public String toString() {
        return "TheraLinkPhotoDTO{" +
                "theralinkPhotoNo=" + theralinkPhotoNo +
                ", theralinkOriginName='" + theralinkOriginName + '\'' +
                ", theralinkSavedName='" + theralinkSavedName + '\'' +
                ", theralinkFilepath='" + theralinkFilepath + '\'' +
                ", theralinkNo=" + theralinkNo +
                ", theralinkPhotoStatus='" + theralinkPhotoStatus + '\'' +
                '}';
    }
}
