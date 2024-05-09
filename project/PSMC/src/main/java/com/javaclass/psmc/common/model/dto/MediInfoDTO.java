package com.javaclass.psmc.common.model.dto;

import lombok.*;

import java.sql.Date;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MediInfoDTO {

    private int mediCode;
    private Date mediDate;
    private int projectNo;
    private int timeCode;
    private LocalDateTime mediRegDate;
    private String mediStatus;
}
