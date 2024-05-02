package com.javaclass.psmc.user.model.dto;

import com.javaclass.psmc.common.UserRole;
import lombok.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@NoArgsConstructor@AllArgsConstructor@Getter@Setter@ToString
public class LoginUserDTO {

    private String registNo;
    private String id;
    private String password;
    private String pmCode;
    private UserRole userRole;

    public List<String> getRole(){
        if(this.userRole.getRole().length()>0){
            return Arrays.asList(this.userRole.getRole().split(","));
        }

        return new ArrayList<>();
    }
}
