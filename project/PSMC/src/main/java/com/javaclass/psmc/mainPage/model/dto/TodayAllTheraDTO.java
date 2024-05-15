package com.javaclass.psmc.mainPage.model.dto;

import lombok.*;

import java.time.LocalTime;
import java.util.List;

@NoArgsConstructor@AllArgsConstructor@Getter@Setter@ToString
public class TodayAllTheraDTO {

    private LocalTime start;
    private LocalTime end;
    private int theraCode;
    private List<Integer> code;

}
