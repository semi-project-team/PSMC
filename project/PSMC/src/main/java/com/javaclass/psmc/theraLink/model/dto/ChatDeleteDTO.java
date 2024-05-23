package com.javaclass.psmc.theraLink.model.dto;

import lombok.*;

import java.util.List;

public class ChatDeleteDTO {

    private List<String> deleteNum;
    private String theraNum;

    public ChatDeleteDTO(){}

    public ChatDeleteDTO(List<String> deleteNum, String theraNum) {
        this.deleteNum = deleteNum;
        this.theraNum = theraNum;
    }

    public List<String> getDeleteNum() {
        return deleteNum;
    }

    public void setDeleteNum(List<String> deleteNum) {
        this.deleteNum = deleteNum;
    }

    public String getTheraNum() {
        return theraNum;
    }

    public void setTheraNum(String theraNum) {
        this.theraNum = theraNum;
    }

    @Override
    public String toString() {
        return "ChatDeleteDTO{" +
                "deleteNum=" + deleteNum +
                ", theraNum='" + theraNum + '\'' +
                '}';
    }
}
