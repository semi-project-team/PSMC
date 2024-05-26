package com.javaclass.psmc.auth.model.dto;

import lombok.*;

@NoArgsConstructor@AllArgsConstructor@Getter@Setter@ToString
public class FindPasswordDTO {

    private String pmCode;
    private String empNo;
    private String userId;
    private String email;
    private String password;
}
