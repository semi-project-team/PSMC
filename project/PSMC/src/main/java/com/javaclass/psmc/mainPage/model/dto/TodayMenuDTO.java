package com.javaclass.psmc.mainPage.model.dto;

import com.javaclass.psmc.common.model.dto.MenuDTO;

import java.time.LocalDate;

public class TodayMenuDTO {

    private LocalDate date;
    private MenuDTO menuDTO;

    public TodayMenuDTO(){}

    public TodayMenuDTO(LocalDate date, MenuDTO menuDTO) {
        this.date = date;
        this.menuDTO = menuDTO;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public MenuDTO getMenuDTO() {
        return menuDTO;
    }

    public void setMenuDTO(MenuDTO menuDTO) {
        this.menuDTO = menuDTO;
    }

    @Override
    public String toString() {
        return "TodayMenuDTO{" +
                "date=" + date +
                ", menuDTO=" + menuDTO +
                '}';
    }
}
