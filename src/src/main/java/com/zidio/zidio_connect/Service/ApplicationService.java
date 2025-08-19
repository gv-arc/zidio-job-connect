package com.zidio.zidio_connect.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zidio.zidio_connect.DTO.ApplicationDTO;
import com.zidio.zidio_connect.Entity.Application;
import com.zidio.zidio_connect.Repository.ApplicationRepository;
import com.zidio.zidio_connect.Enum.ApplicationStatus;
import com.zidio.zidio_connect.Enum.JobType;

@Service
public class ApplicationService {
    @Autowired
    private ApplicationRepository appRepo;

    public String apply(String jobSeekerEmail, ApplicationDTO dto) {
        // Always use jobSeekerEmail from JWT!
        if (appRepo.findByJobSeekerEmailAndJobId(jobSeekerEmail, dto.getJobId()).isPresent()) {
            throw new RuntimeException("You already have applied for this job");
        }
        Application app = Application.builder()
                .jobId(dto.getJobId())
                .jobSeekerName(dto.getJobSeekerName())
                .jobSeekerEmail(jobSeekerEmail) // enforce identity
                .jobTitle(dto.getJobTitle())
                .jobType(dto.getJobType())
                .recruiterEmail(dto.getRecruiterEmail())
                .status(ApplicationStatus.APPLIED)
                .appliedAt(LocalDateTime.now())
                .build();
        appRepo.save(app);
        return "You just applied for this job";
    }

    public List<ApplicationDTO> getByJobSeekerEmail(String jobSeekerEmail) {
        return appRepo.findByJobSeekerEmail(jobSeekerEmail)
                .stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public List<ApplicationDTO> getByRecruiterEmail(String recruiterEmail) {
        return appRepo.findByRecruiterEmail(recruiterEmail)
                .stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public List<ApplicationDTO> getByJobTitle(String jobTitle) {
        return appRepo.findByJobTitle(jobTitle)
                .stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public List<ApplicationDTO> getByJobType(JobType jobType) {
        return appRepo.findByJobType(jobType)
                .stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public void updateStatus(Long id, ApplicationStatus status) {
        Application app = appRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Application not found"));
        app.setStatus(status);
        appRepo.save(app);
    }

    private ApplicationDTO mapToDTO(Application app) {
        return ApplicationDTO.builder()
                .id(app.getId())
                .jobId(app.getJobId())
                .jobSeekerName(app.getJobSeekerName())
                .jobSeekerEmail(app.getJobSeekerEmail())
                .recruiterEmail(app.getRecruiterEmail())
                .jobTitle(app.getJobTitle())
                .jobType(app.getJobType())
                .status(app.getStatus())
                .appliedAt(app.getAppliedAt())
                .build();
    }
}
