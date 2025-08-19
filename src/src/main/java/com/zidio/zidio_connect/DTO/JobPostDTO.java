package com.zidio.zidio_connect.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobPostDTO {

    private Long id;
    private String recruiterEmail;
    private String companyName;
    private String jobTitle;
    private String jobDescription;
    private String jobType;
    private String jobCategory;
    private String jobLocation;
    private boolean remote;

    @Builder.Default
    private LocalDate postedDate = LocalDate.now();

    @Builder.Default
    private boolean active = true;
}
