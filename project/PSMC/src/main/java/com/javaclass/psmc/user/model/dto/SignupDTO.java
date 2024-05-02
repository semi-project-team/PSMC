package com.javaclass.psmc.user.model.dto;

import lombok.*;

@NoArgsConstructor@AllArgsConstructor@Setter@Getter@ToString
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
}
