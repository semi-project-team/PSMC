package com.javaclass.psmc.auth.model.dto;

import com.javaclass.psmc.common.model.dto.MediChatDTO;
import com.javaclass.psmc.common.model.dto.MediConnectDTO;
import com.javaclass.psmc.common.model.dto.PatientDTO;

import java.time.LocalDateTime;

public class MiniMediConnectDTO {

    private int chatNo;
    private String contents;
    private LocalDateTime mediChatBoardDate;
    private MediConnectDTO mediConnectDTO;
    private PatientDTO patientDTO;

    public MiniMediConnectDTO() {
    }

    public MiniMediConnectDTO(int chatNo, String contents, LocalDateTime mediChatBoardDate, MediConnectDTO mediConnectDTO, PatientDTO patientDTO) {
        this.chatNo = chatNo;
        this.contents = contents;
        this.mediChatBoardDate = mediChatBoardDate;
        this.mediConnectDTO = mediConnectDTO;
        this.patientDTO = patientDTO;
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

    public LocalDateTime getMediChatBoardDate() {
        return mediChatBoardDate;
    }

    public void setMediChatBoardDate(LocalDateTime mediChatBoardDate) {
        this.mediChatBoardDate = mediChatBoardDate;
    }

    public MediConnectDTO getMediConnectDTO() {
        return mediConnectDTO;
    }

    public void setMediConnectDTO(MediConnectDTO mediConnectDTO) {
        this.mediConnectDTO = mediConnectDTO;
    }

    public PatientDTO getPatientDTO() {
        return patientDTO;
    }

    public void setPatientDTO(PatientDTO patientDTO) {
        this.patientDTO = patientDTO;
    }

    @Override
    public String toString() {
        return "MiniMediConnectDTO{" +
                "chatNo=" + chatNo +
                ", contents='" + contents + '\'' +
                ", mediChatBoardDate=" + mediChatBoardDate +
                ", mediConnectDTO=" + mediConnectDTO +
                ", patientDTO=" + patientDTO +
                '}';
    }
}
