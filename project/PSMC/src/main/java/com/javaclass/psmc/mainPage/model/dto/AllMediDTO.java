package com.javaclass.psmc.mainPage.model.dto;

import com.javaclass.psmc.common.model.dto.MediInfoDTO;
import lombok.*;

import java.util.List;
@NoArgsConstructor@AllArgsConstructor@Getter@Setter@ToString
public class AllMediDTO {

    private int projectNo;
    private List<MediInfoDTO> mediInfoDTOS;
}
