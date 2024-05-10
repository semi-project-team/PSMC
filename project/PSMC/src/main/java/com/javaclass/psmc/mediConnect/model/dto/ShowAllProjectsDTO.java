package com.javaclass.psmc.mediConnect.model.dto;

import com.javaclass.psmc.common.model.dto.CreateProjectDTO;
import com.javaclass.psmc.common.model.dto.InjuryDTO;
import com.javaclass.psmc.common.model.dto.PatientDTO;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ShowAllProjectsDTO {

    private int projectNo;
    private int patientNo;
    private InjuryDTO injuryDTO;
    private PatientDTO patientDTO;
    private CreateProjectDTO createProjectDTO;

}
