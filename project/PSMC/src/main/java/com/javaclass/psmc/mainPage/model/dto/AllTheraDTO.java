package com.javaclass.psmc.mainPage.model.dto;

import com.javaclass.psmc.common.model.dto.TheraInfoDTO;
import lombok.*;

import java.util.List;

public class AllTheraDTO {
    private int projectNo;
    private List<TheraInfoDTO> theraInfoDTOS;

    public AllTheraDTO(){}

    public AllTheraDTO(int projectNo, List<TheraInfoDTO> theraInfoDTOS) {
        this.projectNo = projectNo;
        this.theraInfoDTOS = theraInfoDTOS;
    }

    public int getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(int projectNo) {
        this.projectNo = projectNo;
    }

    public List<TheraInfoDTO> getTheraInfoDTOS() {
        return theraInfoDTOS;
    }

    public void setTheraInfoDTOS(List<TheraInfoDTO> theraInfoDTOS) {
        this.theraInfoDTOS = theraInfoDTOS;
    }

    @Override
    public String toString() {
        return "AllTheraDTO{" +
                "projectNo=" + projectNo +
                ", theraInfoDTOS=" + theraInfoDTOS +
                '}';
    }
}
