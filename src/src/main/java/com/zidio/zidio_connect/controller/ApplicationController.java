package com.zidio.zidio_connect.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

        import com.zidio.zidio_connect.DTO.ApplicationDTO;
import com.zidio.zidio_connect.Service.ApplicationService;
import com.zidio.zidio_connect.Enum.ApplicationStatus;
import com.zidio.zidio_connect.Enum.JobType;

@RestController
@RequestMapping("/api/applications") // fixed typo
public class ApplicationController {

    @Autowired
    private ApplicationService appService;

    // Job seeker applies for a job (must be authenticated as themselves!)
    @PostMapping("/apply")
    public ResponseEntity<String> apply(Authentication authentication, @RequestBody ApplicationDTO dto) {
        String jobSeekerEmail = authentication.getName(); // email from JWT
        appService.apply(jobSeekerEmail, dto);
        return ResponseEntity.ok("Application got submitted");
    }

    // Get applications by logged-in jobseeker
    @GetMapping("/jobSeeker")
    public ResponseEntity<List<ApplicationDTO>> getJobSeekerApplications(Authentication authentication) {
        String jobSeekerEmail = authentication.getName();
        return ResponseEntity.ok(appService.getByJobSeekerEmail(jobSeekerEmail));
    }

    // Get applications by logged-in recruiter
    @GetMapping("/recruiter")
    public ResponseEntity<List<ApplicationDTO>> getRecruiterApplications(Authentication authentication) {
        String recruiterEmail = authentication.getName();
        return ResponseEntity.ok(appService.getByRecruiterEmail(recruiterEmail));
    }

    // Get by job type
    @GetMapping("/jobType")
    public ResponseEntity<List<ApplicationDTO>> getByJobType(@RequestParam JobType jobType) {
        return ResponseEntity.ok(appService.getByJobType(jobType));
    }

    // Get by job title
    @GetMapping("/search/{jobTitle}")
    public ResponseEntity<List<ApplicationDTO>> getByJobTitle(@PathVariable String jobTitle) {
        return ResponseEntity.ok(appService.getByJobTitle(jobTitle));
    }

    // Only recruiter should be able to do this in real-world!
    @PostMapping("/update-status")
    public ResponseEntity<String> updateStatus(@RequestParam Long id, @RequestParam ApplicationStatus status) {
        appService.updateStatus(id, status);
        return ResponseEntity.ok("Status got updated");
    }
}
