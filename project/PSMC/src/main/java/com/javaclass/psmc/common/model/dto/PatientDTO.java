package com.javaclass.psmc.common.model.dto;

import lombok.*;

public class PatientDTO {

    private int patientNo;
    private String patientName;
    private int age;
    private String gender;
    private double height;
    private double weight;
    private String phone;
    private String agree;
    private String email;

    public PatientDTO(){}

    public PatientDTO(int patientNo, String patientName, int age, String gender, double height, double weight, String phone, String agree, String email) {
        this.patientNo = patientNo;
        this.patientName = patientName;
        this.age = age;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        this.phone = phone;
        this.agree = agree;
        this.email = email;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAgree() {
        return agree;
    }

    public void setAgree(String agree) {
        this.agree = agree;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "PatientDTO{" +
                "patientNo=" + patientNo +
                ", patientName='" + patientName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", phone='" + phone + '\'' +
                ", agree='" + agree + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
