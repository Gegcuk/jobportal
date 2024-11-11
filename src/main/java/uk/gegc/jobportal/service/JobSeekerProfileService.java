package uk.gegc.jobportal.service;

import org.springframework.stereotype.Service;
import uk.gegc.jobportal.entity.JobSeekerProfile;

import java.util.Optional;

public interface JobSeekerProfileService {
    public Optional<JobSeekerProfile> getOne(Integer id);

    JobSeekerProfile addNew(JobSeekerProfile jobSeekerProfile);
}
