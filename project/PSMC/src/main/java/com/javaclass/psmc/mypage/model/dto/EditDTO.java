package com.javaclass.psmc.mypage.model.dto;

public class EditDTO {

    private String name;
    private String id;
    private String email;
    private String companyEmail;
    private String phone;
    private String officeNum;
    private String pmCode;

    public EditDTO() {
    }

    public EditDTO(String name, String id, String email, String companyEmail, String phone, String officeNum, String pmCode) {
        this.name = name;
        this.id = id;
        this.email = email;
        this.companyEmail = companyEmail;
        this.phone = phone;
        this.officeNum = officeNum;
        this.pmCode = pmCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOfficeNum() {
        return officeNum;
    }

    public void setOfficeNum(String officeNum) {
        this.officeNum = officeNum;
    }

    public String getPmCode() {
        return pmCode;
    }

    public void setPmCode(String pmCode) {
        this.pmCode = pmCode;
    }

    @Override
    public String toString() {
        return "EditDTO{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", companyEmail='" + companyEmail + '\'' +
                ", phone='" + phone + '\'' +
                ", officeNum='" + officeNum + '\'' +
                ", pmCode='" + pmCode + '\'' +
                '}';
    }
}