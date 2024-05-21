package com.javaclass.psmc.theraLink.model.dto;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor@AllArgsConstructor@Getter@Setter@ToString
public class MessageDTO {

    private String theraNum;
    private String theraChatContent;
    private LocalDateTime theraChatDate;
    private String pmCode;
}
