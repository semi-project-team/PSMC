package com.javaclass.psmc.common.model.dto;

import lombok.*;


public class EmployeeDTO {

    private String pmCode;
    private int empNo;
    private String phone;
    private String companyEmail;
    private String name;
    private int age;
    private int positionCode;
    private char gender;
    private String officeNum;
    private int fieldCode;

    public EmployeeDTO(){}

    public EmployeeDTO(String pmCode, int empNo, String phone, String companyEmail, String name, int age, int positionCode, char gender, String officeNum, int fieldCode) {
        this.pmCode = pmCode;
        this.empNo = empNo;
        this.phone = phone;
        this.companyEmail = companyEmail;
        this.name = name;
        this.age = age;
        this.positionCode = positionCode;
        this.gender = gender;
        this.officeNum = officeNum;
        this.fieldCode = fieldCode;
    }

    public String getPmCode() {
        return pmCode;
    }

    public void setPmCode(String pmCode) {
        this.pmCode = pmCode;
    }

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPositionCode() {
        return positionCode;
    }

    public void setPositionCode(int positionCode) {
        this.positionCode = positionCode;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getOfficeNum() {
        return officeNum;
    }

    public void setOfficeNum(String officeNum) {
        this.officeNum = officeNum;
    }

    public int getFieldCode() {
        return fieldCode;
    }

    public void setFieldCode(int fieldCode) {
        this.fieldCode = fieldCode;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "pmCode='" + pmCode + '\'' +
                ", empNo=" + empNo +
                ", phone='" + phone + '\'' +
                ", companyEmail='" + companyEmail + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", positionCode=" + positionCode +
                ", gender=" + gender +
                ", officeNum='" + officeNum + '\'' +
                ", fieldCode=" + fieldCode +
                '}';
    }
}
