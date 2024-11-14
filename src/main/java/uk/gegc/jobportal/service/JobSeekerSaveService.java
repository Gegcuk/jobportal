package uk.gegc.jobportal.service;

import uk.gegc.jobportal.entity.JobPostActivity;
import uk.gegc.jobportal.entity.JobSeekerProfile;
import uk.gegc.jobportal.entity.JobSeekerSave;

import java.util.List;

public interface JobSeekerSaveService {
    public List<JobSeekerSave> getCandidatesJob(JobSeekerProfile userAccountId);

    public List<JobSeekerSave> getJobCandidates(JobPostActivity job);

    public void addNew(JobSeekerSave jobSeekerSave);
}
