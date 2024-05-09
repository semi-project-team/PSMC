package com.javaclass.psmc.common.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MediConnectDTO {

    private int mediNo;
    private String mediTitle;
    private String mediContent;
    private int projectNo;
    private String mediStatus;
}
