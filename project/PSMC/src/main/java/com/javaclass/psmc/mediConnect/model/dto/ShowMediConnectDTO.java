package com.javaclass.psmc.mediConnect.model.dto;

import com.javaclass.psmc.common.model.dto.AssignProjectDTO;
import com.javaclass.psmc.common.model.dto.CreateProjectDTO;
import com.javaclass.psmc.common.model.dto.EmployeeDTO;
import lombok.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

public class ShowMediConnectDTO {

    private int mediNo;
    private String mediTitle;
    private String mediContent;
    private LocalDateTime mediBoardDate;
    private int projectNo;
    private CreateProjectDTO createProjectDTO;

    private AssignProjectDTO assignProjectDTO;
    private EmployeeDTO employeeDTO;

    public ShowMediConnectDTO() {
    }

    public ShowMediConnectDTO(int mediNo, String mediTitle, String mediContent, LocalDateTime mediBoardDate, int projectNo, CreateProjectDTO createProjectDTO, AssignProjectDTO assignProjectDTO, EmployeeDTO employeeDTO) {
        this.mediNo = mediNo;
        this.mediTitle = mediTitle;
        this.mediContent = mediContent;
        this.mediBoardDate = mediBoardDate;
        this.projectNo = projectNo;
        this.createProjectDTO = createProjectDTO;
        this.assignProjectDTO = assignProjectDTO;
        this.employeeDTO = employeeDTO;
    }

    public int getMediNo() {
        return mediNo;
    }

    public void setMediNo(int mediNo) {
        this.mediNo = mediNo;
    }

    public String getMediTitle() {
        return mediTitle;
    }

    public void setMediTitle(String mediTitle) {
        this.mediTitle = mediTitle;
    }

    public String getMediContent() {
        return mediContent;
    }

    public void setMediContent(String mediContent) {
        this.mediContent = mediContent;
    }

    public LocalDateTime getMediBoardDate() {
        return mediBoardDate;
    }

    public void setMediBoardDate(LocalDateTime mediBoardDate) {
        this.mediBoardDate = mediBoardDate;
    }

    public int getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(int projectNo) {
        this.projectNo = projectNo;
    }

    public CreateProjectDTO getCreateProjectDTO() {
        return createProjectDTO;
    }

    public void setCreateProjectDTO(CreateProjectDTO createProjectDTO) {
        this.createProjectDTO = createProjectDTO;
    }

    public AssignProjectDTO getAssignProjectDTO() {
        return assignProjectDTO;
    }

    public void setAssignProjectDTO(AssignProjectDTO assignProjectDTO) {
        this.assignProjectDTO = assignProjectDTO;
    }

    public EmployeeDTO getEmployeeDTO() {
        return employeeDTO;
    }

    public void setEmployeeDTO(EmployeeDTO employeeDTO) {
        this.employeeDTO = employeeDTO;
    }

    @Override
    public String toString() {
        return "ShowMediConnectDTO{" +
                "mediNo=" + mediNo +
                ", mediTitle='" + mediTitle + '\'' +
                ", mediContent='" + mediContent + '\'' +
                ", mediBoardDate=" + mediBoardDate +
                ", projectNo=" + projectNo +
                ", createProjectDTO=" + createProjectDTO +
                ", assignProjectDTO=" + assignProjectDTO +
                ", employeeDTO=" + employeeDTO +
                '}';
    }
}
