package uk.gegc.jobportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.gegc.jobportal.entity.JobPostActivity;
import uk.gegc.jobportal.repository.JobPostActivityRepository;

@Service
public class JobPostActivityServiceImpl implements JobPostActivityService {
    private final JobPostActivityRepository jobPostActivityRepository;

    @Autowired
    public JobPostActivityServiceImpl(JobPostActivityRepository jobPostActivityRepository) {
        this.jobPostActivityRepository = jobPostActivityRepository;
    }

    @Override
    public JobPostActivity addNew(JobPostActivity jobPostActivity) {
        return jobPostActivityRepository.save(jobPostActivity);
    }
}
