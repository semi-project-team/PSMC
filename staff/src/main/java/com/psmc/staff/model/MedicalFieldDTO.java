package com.psmc.staff.model;

public class MedicalFieldDTO {

    private int field_code;
    private String field_name;

    public MedicalFieldDTO() {
    }

    public MedicalFieldDTO(int field_code, String field_name) {
        this.field_code = field_code;
        this.field_name = field_name;
    }

    public int getField_code() {
        return field_code;
    }

    public void setField_code(int field_code) {
        this.field_code = field_code;
    }

    public String getField_name() {
        return field_name;
    }

    public void setField_name(String field_name) {
        this.field_name = field_name;
    }

    @Override
    public String toString() {
        return "medical_fieldDTO{" +
                "field_code=" + field_code +
                ", field_name='" + field_name + '\'' +
                '}';
    }
}
