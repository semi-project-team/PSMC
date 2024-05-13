package com.javaclass.psmc.common.model.dto;

import lombok.*;


import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MediChatDTO {

    private int chatNo;
    private String contents;
    private int mediNo;
    private int projectNo;
    private LocalDateTime mediChatBoardDate;

}
