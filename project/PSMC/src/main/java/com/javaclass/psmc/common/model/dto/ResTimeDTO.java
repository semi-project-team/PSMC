package com.javaclass.psmc.common.model.dto;

import lombok.*;

import java.sql.Time;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ResTimeDTO {

    private int timeCode;
    private Time timeVal;
}
