package com.javaclass.psmc.common.model.dto;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class TheraChatDTO {

    private int theraChatNo;
    private int theraLinkNo;
    private int projectNo;
    private String theraChatContent;
    private LocalDateTime theraChatBoardDate;
}
