package com.javaclass.psmc.theraLink.model.dto;

import lombok.*;

import java.time.LocalDateTime;
@NoArgsConstructor@AllArgsConstructor@Getter@Setter@ToString
public class TheraChatForBlogDTO {

    private int theraChatNo;
    private int theraLinkNo;
    private String pmCode;
    private String theraChatContent;
    private LocalDateTime theraChatBoardDate;
    private String theraChatStatus;
    private String name;
}
