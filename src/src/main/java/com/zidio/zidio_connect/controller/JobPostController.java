package com.zidio.zidio_connect.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
        import com.zidio.zidio_connect.DTO.JobPostDTO;
import com.zidio.zidio_connect.Service.JobPostService;

@RestController
@RequestMapping("/api/job-posts")
public class JobPostController {

    @Autowired
    private JobPostService jobPostService;

    // Create new job post
    @PostMapping
    public ResponseEntity<JobPostDTO> createJobs(@RequestBody JobPostDTO dto) {
        return ResponseEntity.ok(jobPostService.createJob(dto));
    }

    // Search by company name
    @GetMapping("/search/company/{companyName}")
    public ResponseEntity<List<JobPostDTO>> getJobByCompanyName(@PathVariable String companyName) {
        return ResponseEntity.ok(jobPostService.findJobByCompanyName(companyName));
    }

    // Search by recruiter email
    @GetMapping("/recruiter/{recruiterEmail}")
    public ResponseEntity<List<JobPostDTO>> getJobByRecruiterEmail(@PathVariable String recruiterEmail) {
        return ResponseEntity.ok(jobPostService.findJobByRecruiterEmail(recruiterEmail));
    }

    // Search by job title
    @GetMapping("/search/title/{jobTitle}")
    public ResponseEntity<List<JobPostDTO>> getJobByJobTitle(@PathVariable String jobTitle) {
        return ResponseEntity.ok(jobPostService.findJobByJobTitle(jobTitle));
    }

    // Logged-in recruiter fetches their own posts
    @GetMapping("/me")
    public ResponseEntity<List<JobPostDTO>> getMyJobPosts(Authentication authentication) {
        String recruiterEmail = authentication.getName(); // From JWT
        return ResponseEntity.ok(jobPostService.findJobByRecruiterEmail(recruiterEmail));
    }
}
