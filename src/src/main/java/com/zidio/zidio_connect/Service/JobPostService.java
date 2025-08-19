package com.zidio.zidio_connect.Service;


import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zidio.zidio_connect.DTO.JobPostDTO;
import com.zidio.zidio_connect.Entity.JobPost;
import com.zidio.zidio_connect.Repository.JobPostRepository;

@Service
public class JobPostService {

    @Autowired
    private JobPostRepository jobPostRepository;

    public JobPostDTO createJob(JobPostDTO dto) {
        JobPost job = new JobPost();
        job.setCompanyName(dto.getCompanyName());
        job.setRecruiterEmail(dto.getRecruiterEmail());
        job.setJobTitle(dto.getJobTitle());
        job.setJobCategory(dto.getJobCategory());
        job.setJobDescription(dto.getJobDescription());
        job.setJobType(dto.getJobType());
        job.setJobLocation(dto.getJobLocation());
        job.setRemote(dto.isRemote());
        job.setPostedDate(dto.getPostedDate() != null ? dto.getPostedDate() : LocalDate.now());
        job.setActive(dto.isActive());

        JobPost saved = jobPostRepository.save(job);
        return mapToDTO(saved);
    }

    public List<JobPostDTO> findJobByCompanyName(String companyName) {
        return jobPostRepository.findByCompanyNameContainingIgnoreCase(companyName)
                .stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public List<JobPostDTO> findJobByRecruiterEmail(String recruiterEmail) {
        return jobPostRepository.findByRecruiterEmail(recruiterEmail)
                .stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public List<JobPostDTO> findJobByJobTitle(String jobTitle) {
        return jobPostRepository.findByJobTitleContainingIgnoreCase(jobTitle)
                .stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    private JobPostDTO mapToDTO(JobPost post) {
        JobPostDTO dto = new JobPostDTO();
        dto.setId(post.getId());
        dto.setCompanyName(post.getCompanyName());
        dto.setRecruiterEmail(post.getRecruiterEmail());
        dto.setJobCategory(post.getJobCategory());
        dto.setJobDescription(post.getJobDescription());
        dto.setJobTitle(post.getJobTitle());
        dto.setJobType(post.getJobType());
        dto.setJobLocation(post.getJobLocation());
        dto.setPostedDate(post.getPostedDate());
        dto.setRemote(post.isRemote());
        dto.setActive(post.isActive());
        return dto;
    }
}
