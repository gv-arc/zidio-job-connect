package com.zidio.zidio_connect.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobSeekerDTO {

    private String name;
    private String email;
    private String phone;
    private String universityName;
    private String course;
    private String passingYear;
    private String resumeURL;
}

