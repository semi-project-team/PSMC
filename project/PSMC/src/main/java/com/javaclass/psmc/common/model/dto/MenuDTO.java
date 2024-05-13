package com.javaclass.psmc.common.model.dto;

import lombok.*;


public class MenuDTO {

    private int dayNo;
    private String menuName;

    public MenuDTO(){}

    public MenuDTO(int dayNo, String menuName) {
        this.dayNo = dayNo;
        this.menuName = menuName;
    }

    public int getDayNo() {
        return dayNo;
    }

    public void setDayNo(int dayNo) {
        this.dayNo = dayNo;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    @Override
    public String toString() {
        return "MenuDTO{" +
                "dayNo=" + dayNo +
                ", menuName='" + menuName + '\'' +
                '}';
    }
}
