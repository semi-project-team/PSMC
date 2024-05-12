package com.javaclass.psmc.mainPage.model.dto;

import com.javaclass.psmc.common.model.dto.TheraInfoDTO;
import lombok.*;

import java.util.List;
@NoArgsConstructor@AllArgsConstructor@Getter@Setter@ToString
public class AllTheraDTO {
    private int projectNo;
    private List<TheraInfoDTO> theraInfoDTOS;
}
