package com.javaclass.psmc.theraLink.model.dto;

import com.javaclass.psmc.common.model.dto.TheraLinkDTO;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor@AllArgsConstructor@Getter@Setter@ToString
public class TheraLinkWithMonthDTO {

    private int theraLinkNo;
    private int projectNo;
    private String theraTitle;
    private String theraContents;
    private String theraStatus;
    private LocalDate theraBoardDate;
    private String month;
    private String comment;
    private String day;

}
