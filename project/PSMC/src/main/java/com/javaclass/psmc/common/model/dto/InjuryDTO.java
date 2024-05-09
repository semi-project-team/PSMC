package com.javaclass.psmc.common.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class InjuryDTO {

    private int injuryCode;
    private String injuryName;
    private int fieldCode;
}
