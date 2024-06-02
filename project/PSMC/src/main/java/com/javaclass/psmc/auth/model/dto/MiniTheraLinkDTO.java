package com.javaclass.psmc.auth.model.dto;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor@AllArgsConstructor@Getter@Setter@ToString
public class MiniTheraLinkDTO {

    private int chatNo;
    private int projectNo;
    private String theraChatContent;
    private LocalDateTime chatBoardDate;
    private String patientName;
    private String transDate;
}
