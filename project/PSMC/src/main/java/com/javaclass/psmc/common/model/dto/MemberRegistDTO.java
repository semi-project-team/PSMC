package com.javaclass.psmc.common.model.dto;

import lombok.*;


public class MemberRegistDTO {

    private int registNo;
    private String id;
    private String password;
    private String phone;
    private String email;
    private String birth;
    private String employeeStatus;
    private String role;
    private String pmCode;

    public MemberRegistDTO(){}

    public MemberRegistDTO(int registNo, String id, String password, String phone, String email, String birth, String employeeStatus, String role, String pmCode) {
        this.registNo = registNo;
        this.id = id;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.birth = birth;
        this.employeeStatus = employeeStatus;
        this.role = role;
        this.pmCode = pmCode;
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

    public String getPmCode() {
        return pmCode;
    }

    public void setPmCode(String pmCode) {
        this.pmCode = pmCode;
    }

    @Override
    public String toString() {
        return "MemberRegistDTO{" +
                "registNo=" + registNo +
                ", id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", birth='" + birth + '\'' +
                ", employeeStatus='" + employeeStatus + '\'' +
                ", role='" + role + '\'' +
                ", pmCode='" + pmCode + '\'' +
                '}';
    }
}
