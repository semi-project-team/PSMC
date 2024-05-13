package com.javaclass.psmc.user.model.dto;

import lombok.*;


public class SignupDTO {

    private int registNo;
    private String id;
    private String password;
    private String phone;
    private String pmCode;
    private String email;
    private String birth;
    private String employeeStatus;
    private String role;

    public SignupDTO(){}

    public SignupDTO(int registNo, String id, String password, String phone, String pmCode, String email, String birth, String employeeStatus, String role) {
        this.registNo = registNo;
        this.id = id;
        this.password = password;
        this.phone = phone;
        this.pmCode = pmCode;
        this.email = email;
        this.birth = birth;
        this.employeeStatus = employeeStatus;
        this.role = role;
    }

    public int getRegistNo() {
        return registNo;
    }

    public void setRegistNo(int registNo) {
        this.registNo = registNo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPmCode() {
        return pmCode;
    }

    public void setPmCode(String pmCode) {
        this.pmCode = pmCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getEmployeeStatus() {
        return employeeStatus;
    }

    public void setEmployeeStatus(String employeeStatus) {
        this.employeeStatus = employeeStatus;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "SignupDTO{" +
                "registNo=" + registNo +
                ", id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", pmCode='" + pmCode + '\'' +
                ", email='" + email + '\'' +
                ", birth='" + birth + '\'' +
                ", employeeStatus='" + employeeStatus + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
