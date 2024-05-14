package com.javaclass.psmc.mainPage.model.dto;

import lombok.*;

import java.sql.Time;
import java.util.List;

public class TtoMIDTO {
    private int timeCode;
    private Time timeVal;
    private List<MItoProDTO> mItoProDTOS;

    public TtoMIDTO(){}

    public TtoMIDTO(int timeCode, Time timeVal, List<MItoProDTO> mItoProDTOS) {
        this.timeCode = timeCode;
        this.timeVal = timeVal;
        this.mItoProDTOS = mItoProDTOS;
    }

    public int getTimeCode() {
        return timeCode;
    }

    public void setTimeCode(int timeCode) {
        this.timeCode = timeCode;
    }

    public Time getTimeVal() {
        return timeVal;
    }

    public void setTimeVal(Time timeVal) {
        this.timeVal = timeVal;
    }

    public List<MItoProDTO> getmItoProDTOS() {
        return mItoProDTOS;
    }

    public void setmItoProDTOS(List<MItoProDTO> mItoProDTOS) {
        this.mItoProDTOS = mItoProDTOS;
    }

    @Override
    public String toString() {
        return "TtoMIDTO{" +
                "timeCode=" + timeCode +
                ", timeVal=" + timeVal +
                ", mItoProDTOS=" + mItoProDTOS +
                '}';
    }
}
