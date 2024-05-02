package com.javaclass.psmc.user.model.dto;

import lombok.*;

@NoArgsConstructor@AllArgsConstructor@Getter@Setter@ToString
public class SignUpDTO {

    private int registNo;
    private String id;
    private String password;
    private String phone;
    private String email;
    private String birth;
    private String employeeStatus;
}
