package com.javaclass.psmc.common.model.dto;

import lombok.*;


import java.time.LocalDateTime;


public class MediChatDTO {

    private int chatNo;
    private String contents;
    private int mediNo;
    private int projectNo;
    private LocalDateTime mediChatBoardDate;

    public MediChatDTO(){}

    public MediChatDTO(int chatNo, String contents, int mediNo, int projectNo, LocalDateTime mediChatBoardDate) {
        this.chatNo = chatNo;
        this.contents = contents;
        this.mediNo = mediNo;
        this.projectNo = projectNo;
        this.mediChatBoardDate = mediChatBoardDate;
    }

    public int getChatNo() {
        return chatNo;
    }

    public void setChatNo(int chatNo) {
        this.chatNo = chatNo;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public int getMediNo() {
        return mediNo;
    }

    public void setMediNo(int mediNo) {
        this.mediNo = mediNo;
    }

    public int getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(int projectNo) {
        this.projectNo = projectNo;
    }

    public LocalDateTime getMediChatBoardDate() {
        return mediChatBoardDate;
    }

    public void setMediChatBoardDate(LocalDateTime mediChatBoardDate) {
        this.mediChatBoardDate = mediChatBoardDate;
    }

    @Override
    public String toString() {
        return "MediChatDTO{" +
                "chatNo=" + chatNo +
                ", contents='" + contents + '\'' +
                ", mediNo=" + mediNo +
                ", projectNo=" + projectNo +
                ", mediChatBoardDate=" + mediChatBoardDate +
                '}';
    }
}
