package com.javaclass.psmc.mediConnect.model.dto;

import com.javaclass.psmc.common.model.dto.InjuryDTO;
import com.javaclass.psmc.common.model.dto.PatientDTO;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class NewProjectShowDTO {

    private int projectNo;
    private PatientDTO patientDTO;
    private InjuryDTO injuryDTO;


}
