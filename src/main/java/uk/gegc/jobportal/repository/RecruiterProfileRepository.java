package uk.gegc.jobportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uk.gegc.jobportal.entity.RecruiterProfile;

@Repository
public interface RecruiterProfileRepository extends JpaRepository<RecruiterProfile, Integer> {
}
