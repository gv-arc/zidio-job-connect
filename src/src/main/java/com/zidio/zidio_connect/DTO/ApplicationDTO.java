package com.zidio.zidio_connect.DTO;

import java.time.LocalDateTime;
import com.zidio.zidio_connect.Enum.ApplicationStatus;
import com.zidio.zidio_connect.Enum.JobType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApplicationDTO {
    private Long id;
    private String jobSeekerName;
    private String jobSeekerEmail;
    private String recruiterEmail;
    private Long jobId;
    private String jobTitle;
    private JobType jobType;
    private ApplicationStatus status;
    private LocalDateTime appliedAt;
}

