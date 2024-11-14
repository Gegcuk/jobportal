package uk.gegc.jobportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uk.gegc.jobportal.entity.JobPostActivity;
import uk.gegc.jobportal.entity.JobSeekerProfile;
import uk.gegc.jobportal.entity.JobSeekerSave;

import java.util.List;

@Repository
public interface JobSeekerSaveRepository extends JpaRepository<JobSeekerSave, Integer> {
    List<JobSeekerSave> findByUserId(JobSeekerProfile userAccount);
    List<JobSeekerSave> findByJob(JobPostActivity job);


}
