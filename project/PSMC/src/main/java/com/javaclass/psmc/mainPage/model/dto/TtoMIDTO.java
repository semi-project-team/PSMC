package com.javaclass.psmc.mainPage.model.dto;

import lombok.*;

import java.sql.Time;
import java.util.List;
@NoArgsConstructor@AllArgsConstructor@Setter@Getter@ToString
public class TtoMIDTO {
    private int timeCode;
    private Time timeVal;
    private List<MItoProDTO> mItoProDTOS;
}
