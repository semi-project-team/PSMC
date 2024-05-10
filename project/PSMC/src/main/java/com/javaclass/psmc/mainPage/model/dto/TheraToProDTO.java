package com.javaclass.psmc.mainPage.model.dto;

import lombok.*;

import java.sql.Date;
import java.sql.Time;
@NoArgsConstructor@AllArgsConstructor@Setter@Getter@ToString
public class TheraToProDTO {

    private int theraCode;
    private Date theraDate;
    private Time start;
    private Time end;
    private ConnectProjectDTO connectProjectDTO;
}
