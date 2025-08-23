package com.zidio.zidio_connect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.zidio.zidio_connect.DTO.RecruiterDTO;
import com.zidio.zidio_connect.Entity.Recruiter;
import com.zidio.zidio_connect.Service.RecruiterService;

@RestController
@RequestMapping("/api/recruiters")
public class RecruiterController {

    @Autowired
    private RecruiterService recruiterService;

    // Create or update profile by recruiter email (for admins or internal use)
    @PostMapping("/profile/email/{recruiterEmail}")
    public ResponseEntity<Recruiter> createOrUpdateProfile(
            @PathVariable String recruiterEmail,
            @RequestBody RecruiterDTO dto) {
        return ResponseEntity.ok(
                recruiterService.createOrUpdateRecruiterProfile(recruiterEmail, dto)
        );
    }

    // Get recruiter by company name
    @GetMapping("/profile/company/{companyName}")
    public ResponseEntity<Recruiter> getRecruiterByCompanyName(@PathVariable String companyName) {
        return ResponseEntity.ok(recruiterService.getRecruiterByCompanyName(companyName));
    }

    // 🔹 GET logged-in recruiter's own profile
    @GetMapping("/me")
    public ResponseEntity<Recruiter> getMyProfile(Authentication authentication) {
        String recruiterEmail = authentication.getName(); // JWT subject
        Recruiter recruiter = recruiterService.getRecruiterByRecruiterEmail(recruiterEmail);
        return recruiter != null ? ResponseEntity.ok(recruiter) : ResponseEntity.notFound().build();
    }

    // 🔹 POST to update logged-in recruiter's profile
    @PostMapping("/me")
    public ResponseEntity<Recruiter> updateMyProfile(
            Authentication authentication,
            @RequestBody RecruiterDTO dto) {
        String recruiterEmail = authentication.getName();
        Recruiter updated = recruiterService.createOrUpdateRecruiterProfile(recruiterEmail, dto);
        return ResponseEntity.ok(updated);
    }
}

