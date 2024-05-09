package com.javaclass.psmc.common.model.dto;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProjectDTO {

    private int projectNo;
    private int patientNo;
    private LocalDateTime projectDate;
    private String projectStatus;
    private int injuryCode;

}
