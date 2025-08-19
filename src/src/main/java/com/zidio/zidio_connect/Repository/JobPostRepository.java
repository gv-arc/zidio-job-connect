package com.zidio.zidio_connect.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.zidio.zidio_connect.Entity.JobPost;

@Repository
public interface JobPostRepository extends JpaRepository<JobPost, Long> {

    List<JobPost> findByRecruiterEmail(String recruiterEmail);

    List<JobPost> findByJobTitleContainingIgnoreCase(String jobTitle);

    List<JobPost> findByCompanyNameContainingIgnoreCase(String companyName);
}
