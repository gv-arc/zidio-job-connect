package com.zidio.zidio_connect.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zidio.zidio_connect.DTO.RecruiterDTO;
import com.zidio.zidio_connect.Entity.Recruiter;
import com.zidio.zidio_connect.Repository.RecruiterRepository;

@Service
public class RecruiterService {

    @Autowired
    private RecruiterRepository recruiterRepository;

    // Create or Update by email
    public Recruiter createOrUpdateRecruiterProfile(String recruiterEmail, RecruiterDTO dto) {
        Recruiter recruiter = recruiterRepository.findByRecruiterEmail(recruiterEmail)
                .orElse(new Recruiter());

        recruiter.setRecruiterEmail(dto.getRecruiterEmail());
        recruiter.setRecruiterPhone(dto.getRecruiterPhone());
        recruiter.setCompanyName(dto.getCompanyName());
        recruiter.setCompanyWebsite(dto.getCompanyWebsite());

        return recruiterRepository.save(recruiter);
    }

    public Recruiter getRecruiterByCompanyName(String companyName) {
        return recruiterRepository.findByCompanyName(companyName)
                .orElseThrow(() -> new RuntimeException("Recruiter not found"));
    }

    public Recruiter getRecruiterByRecruiterEmail(String recruiterEmail) {
        return recruiterRepository.findByRecruiterEmail(recruiterEmail)
                .orElse(null);
    }
}
