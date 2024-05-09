package com.javaclass.psmc.common.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
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
}
