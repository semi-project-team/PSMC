package com.javaclass.psmc.mainPage.model.dto;

import com.javaclass.psmc.common.model.dto.MedicalFieldDTO;
import com.javaclass.psmc.common.model.dto.PositionDTO;
import lombok.*;

@NoArgsConstructor@AllArgsConstructor@Getter@Setter@ToString
public class ProfileDTO {

    private String pmCode;
    private String name;
    private int fieldCode;
    private int positionCode;
    private String officeNum;
    private String email;
    private PositionDTO positionDTO;
    private MedicalFieldDTO medicalFieldDTO;
}
