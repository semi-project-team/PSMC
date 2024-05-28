package com.javaclass.psmc.theraLink.model.dto;


import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor@AllArgsConstructor@Getter@Setter@ToString
public class BlogDTO {

    private int theraLinkNo;
    private int projectNo;
    private String theraTitle;
    private String theraContents;
    private String theraStatus;
    private LocalDate theraBoardDate;
    private String savedName;
    private String filepath;
    private String comment;
}
