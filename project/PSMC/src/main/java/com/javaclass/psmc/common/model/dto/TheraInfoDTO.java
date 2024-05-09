package com.javaclass.psmc.common.model.dto;

import lombok.*;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class TheraInfoDTO {

    private int theraCode;
    private Date theraDate;
    private int projectNo;
    private LocalDateTime theraRegDate;
    private String theraStatus;
    private Time start;
    private Time end;

}
