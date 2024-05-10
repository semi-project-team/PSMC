package com.javaclass.psmc.mainPage.model.dto;

import com.javaclass.psmc.common.model.dto.AssignProjectDTO;
import com.javaclass.psmc.common.model.dto.CreateProjectDTO;
import com.javaclass.psmc.common.model.dto.InjuryDTO;
import com.javaclass.psmc.common.model.dto.PatientDTO;
import lombok.*;

@NoArgsConstructor@AllArgsConstructor@Getter@Setter@ToString
public class ConnectProjectDTO {

    private int projectNo;
    private CreateToEmpDTO create;
    private AssignToEmpDTO assign;
    private PatientDTO patientDTO;
    private InjuryDTO injuryDTO;

}
