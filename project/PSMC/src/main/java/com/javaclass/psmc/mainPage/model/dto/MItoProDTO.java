package com.javaclass.psmc.mainPage.model.dto;

import lombok.*;

import java.sql.Date;
@NoArgsConstructor@AllArgsConstructor@Setter@Getter@ToString
public class MItoProDTO {
    private int mediCode;
    private Date mediDate;
    private int day;
    ConnectProjectDTO connectProjectDTO;
}
