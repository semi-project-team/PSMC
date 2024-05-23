package com.psmc.staff.model;

public class PositionDTO {

    private int position_code;
    private String position_name;

    public PositionDTO() {
    }

    public PositionDTO(int position_code, String position_name) {
        this.position_code = position_code;
        this.position_name = position_name;
    }

    public int getPosition_code() {
        return position_code;
    }

    public void setPosition_code(int position_code) {
        this.position_code = position_code;
    }

    public String getPosition_name() {
        return position_name;
    }

    public void setPosition_name(String position_name) {
        this.position_name = position_name;
    }

    @Override
    public String toString() {
        return "positionDTO{" +
                "position_code=" + position_code +
                ", position_name='" + position_name + '\'' +
                '}';
    }
}
