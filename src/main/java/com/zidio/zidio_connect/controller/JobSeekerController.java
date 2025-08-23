package com.zidio.zidio_connect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.zidio.zidio_connect.DTO.JobSeekerDTO;
import com.zidio.zidio_connect.Service.JobSeekerService;

@RestController
@RequestMapping("/api/jobSeekers")
public class JobSeekerController {

    @Autowired
    private JobSeekerService jobSeekerService;

    // Create or update profile for logged-in jobseeker
    @PostMapping
    public ResponseEntity<JobSeekerDTO> saveJobSeeker(
            Authentication authentication,
            @RequestBody JobSeekerDTO dto) {

        String userEmail = authentication.getName();
        dto.setEmail(userEmail);
        JobSeekerDTO updated = jobSeekerService.createOrUpdate(userEmail, dto);
        return ResponseEntity.ok(updated);
    }

    // Upload resume for logged-in jobseeker
    @PostMapping("/me/resume")
    public ResponseEntity<String> uploadResume(
            Authentication authentication,
            @RequestParam("file") MultipartFile resume) {

        String userEmail = authentication.getName();
        String resumePath = jobSeekerService.uploadResume(userEmail, resume);
        return ResponseEntity.ok("Resume uploaded to: " + resumePath);
    }

    // Get jobseeker profile by email (for recruiter/admin access)
    @GetMapping("/{email}")
    public ResponseEntity<JobSeekerDTO> getJobSeekerByEmail(@PathVariable String email) {
        JobSeekerDTO dto = jobSeekerService.getJobSeekerByEmail(email);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    // Get own jobseeker profile using JWT token
    @GetMapping("/me")
    public ResponseEntity<JobSeekerDTO> getMyProfile(Authentication authentication) {
        String userEmail = authentication.getName();
        JobSeekerDTO dto = jobSeekerService.getJobSeekerByEmail(userEmail);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }
}
