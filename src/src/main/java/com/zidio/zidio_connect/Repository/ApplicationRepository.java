package com.zidio.zidio_connect.Repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.zidio.zidio_connect.Entity.Application;
import com.zidio.zidio_connect.Enum.JobType;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
    Optional<Application> findByJobSeekerEmailAndJobId(String jobSeekerEmail, Long jobId);
    List<Application> findByJobSeekerEmail(String jobSeekerEmail);
    List<Application> findByRecruiterEmail(String recruiterEmail);
    List<Application> findByJobTitle(String jobTitle);
    List<Application> findByJobType(JobType jobType);
}
