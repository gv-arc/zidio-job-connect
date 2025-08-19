package com.zidio.zidio_connect.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "job_posts")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
