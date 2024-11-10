package uk.gegc.jobportal.service;

import org.springframework.stereotype.Service;
import uk.gegc.jobportal.entity.JobSeekerProfile;
import uk.gegc.jobportal.repository.JobSeekerProfileRepository;

import java.util.Optional;

@Service
public class JobSeekerProfileServiceImpl implements JobSeekerProfileService {
    private final JobSeekerProfileRepository jobSeekerProfileRepository;

    public JobSeekerProfileServiceImpl(JobSeekerProfileRepository jobSeekerProfileRepository) {
        this.jobSeekerProfileRepository = jobSeekerProfileRepository;
    }

    @Override
    public Optional<JobSeekerProfile> getOne(Integer id) {
        return jobSeekerProfileRepository.findById(id);
    }
}
