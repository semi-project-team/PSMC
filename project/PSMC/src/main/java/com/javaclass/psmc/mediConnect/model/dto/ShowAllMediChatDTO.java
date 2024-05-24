package com.javaclass.psmc.mediConnect.model.dto;

import com.javaclass.psmc.common.model.dto.AssignProjectDTO;
import com.javaclass.psmc.common.model.dto.CreateProjectDTO;
import com.javaclass.psmc.common.model.dto.EmployeeDTO;
import com.javaclass.psmc.common.model.dto.MemberRegistDTO;

import java.time.LocalDateTime;

public class ShowAllMediChatDTO {

    private int chatNo;
    private String contents;
    private int mediNo;
    private String pmCode;
    private LocalDateTime mediChatBoardDate;
    private String mediChatStatus;
    private EmployeeDTO employeeDTO;
    private MemberRegistDTO memberRegistDTO;

    public ShowAllMediChatDTO() {
    }

    public ShowAllMediChatDTO(int chatNo, String contents, int mediNo, String pmCode, LocalDateTime mediChatBoardDate, String mediChatStatus, EmployeeDTO employeeDTO, MemberRegistDTO memberRegistDTO) {
        this.chatNo = chatNo;
        this.contents = contents;
        this.mediNo = mediNo;
        this.pmCode = pmCode;
        this.mediChatBoardDate = mediChatBoardDate;
        this.mediChatStatus = mediChatStatus;
        this.employeeDTO = employeeDTO;
        this.memberRegistDTO = memberRegistDTO;
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

    public String getPmCode() {
        return pmCode;
    }

    public void setPmCode(String pmCode) {
        this.pmCode = pmCode;
    }

    public LocalDateTime getMediChatBoardDate() {
        return mediChatBoardDate;
    }

    public void setMediChatBoardDate(LocalDateTime mediChatBoardDate) {
        this.mediChatBoardDate = mediChatBoardDate;
    }

    public String getMediChatStatus() {
        return mediChatStatus;
    }

    public void setMediChatStatus(String mediChatStatus) {
        this.mediChatStatus = mediChatStatus;
    }

    public EmployeeDTO getEmployeeDTO() {
        return employeeDTO;
    }

    public void setEmployeeDTO(EmployeeDTO employeeDTO) {
        this.employeeDTO = employeeDTO;
    }

    public MemberRegistDTO getMemberRegistDTO() {
        return memberRegistDTO;
    }

    public void setMemberRegistDTO(MemberRegistDTO memberRegistDTO) {
        this.memberRegistDTO = memberRegistDTO;
    }

    @Override
    public String toString() {
        return "ShowAllMediChatDTO{" +
                "chatNo=" + chatNo +
                ", contents='" + contents + '\'' +
                ", mediNo=" + mediNo +
                ", pmCode='" + pmCode + '\'' +
                ", mediChatBoardDate=" + mediChatBoardDate +
                ", mediChatStatus='" + mediChatStatus + '\'' +
                ", employeeDTO=" + employeeDTO +
                ", memberRegistDTO=" + memberRegistDTO +
                '}';
    }

}
