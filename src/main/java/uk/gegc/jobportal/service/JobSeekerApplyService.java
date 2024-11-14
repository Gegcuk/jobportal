package uk.gegc.jobportal.service;

import uk.gegc.jobportal.entity.JobSeekerApply;
import uk.gegc.jobportal.entity.JobSeekerProfile;

import java.util.List;

public interface JobSeekerApplyService {
    public List<JobSeekerApply> getCandidatesJobs(JobSeekerProfile userAccountId);

}
