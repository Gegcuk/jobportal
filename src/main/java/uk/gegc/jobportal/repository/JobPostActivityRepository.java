package uk.gegc.jobportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uk.gegc.jobportal.entity.JobPostActivity;

public interface JobPostActivityRepository extends JpaRepository<JobPostActivity, Integer> {
}
