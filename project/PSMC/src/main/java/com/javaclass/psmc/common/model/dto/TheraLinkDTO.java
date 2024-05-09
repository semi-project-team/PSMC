package com.javaclass.psmc.common.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class TheraLinkDTO {

    private int projectNo;
    private int theraLinkNo;
    private String title;
    private String contents;
    private String theraStatus;

}
