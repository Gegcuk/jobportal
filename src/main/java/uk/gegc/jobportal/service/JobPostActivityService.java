package uk.gegc.jobportal.service;

import uk.gegc.jobportal.entity.JobPostActivity;
import uk.gegc.jobportal.entity.RecruiterJobsDto;

import java.util.List;

public interface JobPostActivityService {
    public JobPostActivity addNew(JobPostActivity jobPostActivity);
    public List<RecruiterJobsDto> getRecruiterJobs(int recruiter);

    JobPostActivity getOne(int id);
}
