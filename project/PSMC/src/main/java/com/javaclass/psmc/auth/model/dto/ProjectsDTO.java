package com.javaclass.psmc.auth.model.dto;

import com.javaclass.psmc.common.model.dto.ResTimeDTO;
import lombok.*;

import java.util.List;
@NoArgsConstructor@AllArgsConstructor@Getter@Setter@ToString
public class ProjectsDTO {

    private int projectNo;
    private ResTimeDTO resTimeDTOS;
    private String patientName;
    private String injuryName;
    private int day;
    private String[] time;

}
