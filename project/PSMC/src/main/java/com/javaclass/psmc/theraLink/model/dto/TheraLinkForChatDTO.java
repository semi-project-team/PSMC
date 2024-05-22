package com.javaclass.psmc.theraLink.model.dto;


import lombok.*;

import java.util.List;
@NoArgsConstructor@AllArgsConstructor@Getter@Setter@ToString
public class TheraLinkForChatDTO {

    private String me;
    private int theraLinkNo;
    private String theraTitle;
    private String theraContents;
    private List<TheraChatForBlogDTO> theraChatForBlogDTOS;
}
