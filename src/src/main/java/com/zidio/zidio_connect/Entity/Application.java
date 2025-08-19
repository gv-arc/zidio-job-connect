package com.zidio.zidio_connect.Entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import com.zidio.zidio_connect.Enum.ApplicationStatus;
import com.zidio.zidio_connect.Enum.JobType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "applications")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String jobSeekerName;
    private String jobSeekerEmail;      // No unique constraint!
    private Long jobId;
    private String jobTitle;
    private JobType jobType;
    private String recruiterEmail;      // No unique constraint!
    private ApplicationStatus status;
    private LocalDateTime appliedAt;
}

