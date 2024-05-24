package com.psmc.staff.model;

public class EmployeeToMedicalFieldDTO {

    private String pmCode;
    private int empNo;
    private String phone;
    private String email;
    private String name;
    private int age;
    private int positionCode;
    private String gender;
    private String officeNum;
    private int fieldCode;
    private MedicalFieldDTO medicalFieldDTO;
    private PositionDTO positionDTO;

    public EmployeeToMedicalFieldDTO() {
    }

    public EmployeeToMedicalFieldDTO(String pmCode, int empNo, String phone, String email, String name, int age, int positionCode, String gender, String officeNum, int fieldCode, MedicalFieldDTO medicalFieldDTO, PositionDTO positionDTO) {
        this.pmCode = pmCode;
        this.empNo = empNo;
        this.phone = phone;
        this.email = email;
        this.name = name;
        this.age = age;
        this.positionCode = positionCode;
        this.gender = gender;
        this.officeNum = officeNum;
        this.fieldCode = fieldCode;
        this.medicalFieldDTO = medicalFieldDTO;
        this.positionDTO = positionDTO;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
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

    public MedicalFieldDTO getMedicalFieldDTO() {
        return medicalFieldDTO;
    }

    public void setMedicalFieldDTO(MedicalFieldDTO medicalFieldDTO) {
        this.medicalFieldDTO = medicalFieldDTO;
    }

    public PositionDTO getPositionDTO() {
        return positionDTO;
    }

    public void setPositionDTO(PositionDTO positionDTO) {
        this.positionDTO = positionDTO;
    }

    @Override
    public String toString() {
        return "EmployeeToMedicalFieldDTO{" +
                "pmCode='" + pmCode + '\'' +
                ", empNo=" + empNo +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", positionCode=" + positionCode +
                ", gender='" + gender + '\'' +
                ", officeNum='" + officeNum + '\'' +
                ", fieldCode=" + fieldCode +
                ", medicalFieldDTO=" + medicalFieldDTO +
                ", positionDTO=" + positionDTO +
                '}';
    }
}
