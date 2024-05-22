package com.javaclass.psmc.theraLink.model.dto;

import lombok.*;

import java.util.List;
@NoArgsConstructor@AllArgsConstructor@Getter@Setter@ToString
public class ChatDeleteDTO {

    private List<String> deleteNum;
    private String theraNum;
}
