package com.javaclass.psmc.auth.model.dto;

public class MyPatientDTO {

    private int patientNo;
    private String patientName;
    private String phone;
    private int projectNo;

    public MyPatientDTO(){}

    public MyPatientDTO(int patientNo, String patientName, String phone, int projectNo) {
        this.patientNo = patientNo;
        this.patientName = patientName;
        this.phone = phone;
        this.projectNo = projectNo;
    }

    public int getPatientNo() {
        return patientNo;
    }

    public void setPatientNo(int patientNo) {
        this.patientNo = patientNo;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(int projectNo) {
        this.projectNo = projectNo;
    }

    @Override
    public String toString() {
        return "MyPatientDTO{" +
                "patientNo=" + patientNo +
                ", patientName='" + patientName + '\'' +
                ", phone='" + phone + '\'' +
                ", projectNo=" + projectNo +
                '}';
    }
}
