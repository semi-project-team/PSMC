package com.javaclass.psmc.user.model.dto;

import com.javaclass.psmc.common.UserRole;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class LoginUserDTO implements Serializable {

    private String registNo;
    private String id;
    private String password;
    private String pmCode;
    private UserRole userRole;

    public LoginUserDTO(){}

    public LoginUserDTO(String registNo, String id, String password, String pmCode, UserRole userRole) {
        this.registNo = registNo;
        this.id = id;
        this.password = password;
        this.pmCode = pmCode;
        this.userRole = userRole;
    }

    public String getRegistNo() {
        return registNo;
    }

    public void setRegistNo(String registNo) {
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

    public String getPmCode() {
        return pmCode;
    }

    public void setPmCode(String pmCode) {
        this.pmCode = pmCode;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }


    @Override
    public String toString() {
        return "LoginUserDTO{" +
                "registNo='" + registNo + '\'' +
                ", id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", pmCode='" + pmCode + '\'' +
                ", userRole=" + userRole +
                '}';
    }

    public List<String> getRole(){
        if(this.userRole.getRole().length()>0){
            return Arrays.asList(this.userRole.getRole().split(","));
        }

        return new ArrayList<>();
    }
}
