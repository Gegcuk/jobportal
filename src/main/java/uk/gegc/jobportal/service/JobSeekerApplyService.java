package uk.gegc.jobportal.service;

import uk.gegc.jobportal.entity.JobPostActivity;
import uk.gegc.jobportal.entity.JobSeekerApply;
import uk.gegc.jobportal.entity.JobSeekerProfile;

import java.util.List;

public interface JobSeekerApplyService {
    public List<JobSeekerApply> getCandidatesJobs(JobSeekerProfile userAccountId);
    public List<JobSeekerApply> getJobsCandidates(JobPostActivity job);

    public void addNew(JobSeekerApply jobSeekerApply);
}
