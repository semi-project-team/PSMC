package com.javaclass.psmc.mediConnect.model.dto;

import com.javaclass.psmc.common.model.dto.CreateProjectDTO;
import lombok.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ShowMediConnectDTO {

    private int mediNo;
    private String mediTitle;
    private String mediContent;
    private LocalDateTime mediBoardDate;
    private int projectNo;
    private CreateProjectDTO createProjectDTO;

}
