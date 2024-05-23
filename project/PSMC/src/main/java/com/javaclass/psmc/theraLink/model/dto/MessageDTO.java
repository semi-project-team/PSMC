package com.javaclass.psmc.theraLink.model.dto;

import lombok.*;

import java.time.LocalDateTime;


public class MessageDTO {

    private String theraNum;
    private String theraChatContent;
    private LocalDateTime theraChatDate;
    private String pmCode;

    public MessageDTO(){}

    public MessageDTO(String theraNum, String theraChatContent, LocalDateTime theraChatDate, String pmCode) {
        this.theraNum = theraNum;
        this.theraChatContent = theraChatContent;
        this.theraChatDate = theraChatDate;
        this.pmCode = pmCode;
    }

    public String getTheraNum() {
        return theraNum;
    }

    public void setTheraNum(String theraNum) {
        this.theraNum = theraNum;
    }

    public String getTheraChatContent() {
        return theraChatContent;
    }

    public void setTheraChatContent(String theraChatContent) {
        this.theraChatContent = theraChatContent;
    }

    public LocalDateTime getTheraChatDate() {
        return theraChatDate;
    }

    public void setTheraChatDate(LocalDateTime theraChatDate) {
        this.theraChatDate = theraChatDate;
    }

    public String getPmCode() {
        return pmCode;
    }

    public void setPmCode(String pmCode) {
        this.pmCode = pmCode;
    }

    @Override
    public String toString() {
        return "MessageDTO{" +
                "theraNum='" + theraNum + '\'' +
                ", theraChatContent='" + theraChatContent + '\'' +
                ", theraChatDate=" + theraChatDate +
                ", pmCode='" + pmCode + '\'' +
                '}';
    }
}
