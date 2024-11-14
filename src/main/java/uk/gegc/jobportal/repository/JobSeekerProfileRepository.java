package uk.gegc.jobportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uk.gegc.jobportal.entity.JobSeekerProfile;

@Repository
public interface JobSeekerProfileRepository extends JpaRepository<JobSeekerProfile, Integer> {
}
