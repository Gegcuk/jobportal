package uk.gegc.jobportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uk.gegc.jobportal.entity.JobSeekerProfile;

public interface JobSeekerProfileRepository extends JpaRepository<JobSeekerProfile, Integer> {
}
