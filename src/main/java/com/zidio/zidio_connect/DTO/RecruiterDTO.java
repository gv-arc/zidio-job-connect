package com.zidio.zidio_connect.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecruiterDTO {

    private String recruiterEmail;
    private String recruiterPhone;
    private String companyName;
    private String companyWebsite;
}
