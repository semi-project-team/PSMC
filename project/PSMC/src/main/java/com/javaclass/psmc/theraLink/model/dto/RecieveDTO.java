package com.javaclass.psmc.theraLink.model.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@NoArgsConstructor@AllArgsConstructor@Getter@Setter@ToString
public class RecieveDTO {

    private List<MultipartFile> images;
    private String theraTitle;
    private String contents;
}
