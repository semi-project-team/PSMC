package com.javaclass.psmc.mainPage.model.dto;

import lombok.*;

import java.time.LocalTime;
import java.util.List;


public class TodayAllTheraDTO {

    private LocalTime start;
    private LocalTime end;
    private int theraCode;
    private List<Integer> code;

    public TodayAllTheraDTO(){}

    public TodayAllTheraDTO(LocalTime start, LocalTime end, int theraCode, List<Integer> code) {
        this.start = start;
        this.end = end;
        this.theraCode = theraCode;
        this.code = code;
    }

    public LocalTime getStart() {
        return start;
    }

    public void setStart(LocalTime start) {
        this.start = start;
    }

    public LocalTime getEnd() {
        return end;
    }

    public void setEnd(LocalTime end) {
        this.end = end;
    }

    public int getTheraCode() {
        return theraCode;
    }

    public void setTheraCode(int theraCode) {
        this.theraCode = theraCode;
    }

    public List<Integer> getCode() {
        return code;
    }

    public void setCode(List<Integer> code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "TodayAllTheraDTO{" +
                "start=" + start +
                ", end=" + end +
                ", theraCode=" + theraCode +
                ", code=" + code +
                '}';
    }
}
