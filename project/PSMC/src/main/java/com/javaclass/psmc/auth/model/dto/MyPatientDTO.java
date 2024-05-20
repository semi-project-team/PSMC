package com.javaclass.psmc.auth.model.dto;

public class MyPatientDTO {

    private int patientNo;
    private String patientName;
    private String phone;
    private int projectNo;
    private String email;
    private int age;
    private String injuryName;

    public MyPatientDTO(){}

    public MyPatientDTO(int patientNo, String patientName, String phone, int projectNo, String email, int age, String injuryName) {
        this.patientNo = patientNo;
        this.patientName = patientName;
        this.phone = phone;
        this.projectNo = projectNo;
        this.email = email;
        this.age = age;
        this.injuryName = injuryName;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getInjuryName() {
        return injuryName;
    }

    public void setInjuryName(String injuryName) {
        this.injuryName = injuryName;
    }

    @Override
    public String toString() {
        return "MyPatientDTO{" +
                "patientNo=" + patientNo +
                ", patientName='" + patientName + '\'' +
                ", phone='" + phone + '\'' +
                ", projectNo=" + projectNo +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", injuryName='" + injuryName + '\'' +
                '}';
    }
}
