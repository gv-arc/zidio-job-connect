package com.zidio.zidio_connect.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.zidio.zidio_connect.DTO.JobSeekerDTO;
import com.zidio.zidio_connect.Entity.JobSeeker;
import com.zidio.zidio_connect.Repository.JobSeekerRepository;

import java.io.File;
import java.io.IOException;

@Service
public class JobSeekerService {

    @Autowired
    private JobSeekerRepository jobSeekerRepository;

    @Transactional
    public JobSeekerDTO createOrUpdate(String email, JobSeekerDTO dto) {
        // Always use the authenticated user's email
        JobSeeker jobSeek = jobSeekerRepository.findByEmail(email).orElse(new JobSeeker());
        jobSeek.setEmail(email);
        jobSeek.setName(dto.getName());
        jobSeek.setPhone(dto.getPhone());
        jobSeek.setUniversityName(dto.getUniversityName());
        jobSeek.setCourse(dto.getCourse());
        jobSeek.setPassingYear(dto.getPassingYear());
        jobSeek.setResumeURL(dto.getResumeURL());

        return mapToDTO(jobSeekerRepository.save(jobSeek));
    }

    @Transactional
    public String uploadResume(String email, MultipartFile resume) {
        JobSeeker jobSeeker = jobSeekerRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("JobSeeker not found"));

        // Local directory example (replace with actual config or cloud for production)
        String uploadDir = "D:\\New folder"; // Make sure directory exists and is writable
        String filename = email + "_resume_" + System.currentTimeMillis() + "_" + resume.getOriginalFilename();
        File destination = new File(uploadDir + filename);

        try {
            resume.transferTo(destination);
        } catch (IOException e) {
            throw new RuntimeException("Failed to upload resume", e);
        }

        // Update resumeURL field (for production, use cloud/public URL)
        jobSeeker.setResumeURL(destination.getAbsolutePath());
        jobSeekerRepository.save(jobSeeker);

        return destination.getAbsolutePath();
    }

    public JobSeekerDTO getJobSeekerByEmail(String email) {
        return jobSeekerRepository.findByEmail(email)
                .map(this::mapToDTO)
                .orElse(null);
    }

    private JobSeekerDTO mapToDTO(JobSeeker jobSeek) {
        JobSeekerDTO dto = new JobSeekerDTO();

        dto.setName(jobSeek.getName());
        dto.setEmail(jobSeek.getEmail());
        dto.setPhone(jobSeek.getPhone());
        dto.setUniversityName(jobSeek.getUniversityName());
        dto.setCourse(jobSeek.getCourse());
        dto.setPassingYear(jobSeek.getPassingYear());
        dto.setResumeURL(jobSeek.getResumeURL());
        return dto;
    }
}
