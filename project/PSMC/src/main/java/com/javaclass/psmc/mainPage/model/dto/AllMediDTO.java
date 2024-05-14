package com.javaclass.psmc.mainPage.model.dto;

import com.javaclass.psmc.common.model.dto.MediInfoDTO;
import lombok.*;

import java.util.List;

public class AllMediDTO {
    private int mediCode;
    private int projectNo;
    private List<MediInfoDTO> mediInfoDTOS;

    public AllMediDTO(){}

    public AllMediDTO(int mediCode, int projectNo, List<MediInfoDTO> mediInfoDTOS) {
        this.mediCode = mediCode;
        this.projectNo = projectNo;
        this.mediInfoDTOS = mediInfoDTOS;
    }

    public int getMediCode() {
        return mediCode;
    }

    public void setMediCode(int mediCode) {
        this.mediCode = mediCode;
    }

    public int getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(int projectNo) {
        this.projectNo = projectNo;
    }

    public List<MediInfoDTO> getMediInfoDTOS() {
        return mediInfoDTOS;
    }

    public void setMediInfoDTOS(List<MediInfoDTO> mediInfoDTOS) {
        this.mediInfoDTOS = mediInfoDTOS;
    }

    @Override
    public String toString() {
        return "AllMediDTO{" +
                "mediCode=" + mediCode +
                ", projectNo=" + projectNo +
                ", mediInfoDTOS=" + mediInfoDTOS +
                '}';
    }
}
