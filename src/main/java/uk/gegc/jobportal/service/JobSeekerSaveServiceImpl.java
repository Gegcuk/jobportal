package uk.gegc.jobportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.gegc.jobportal.entity.JobPostActivity;
import uk.gegc.jobportal.entity.JobSeekerProfile;
import uk.gegc.jobportal.entity.JobSeekerSave;
import uk.gegc.jobportal.repository.JobSeekerSaveRepository;

import java.util.List;

@Service
public class JobSeekerSaveServiceImpl implements JobSeekerSaveService {

    private final JobSeekerSaveRepository jobSeekerSaveRepository;

    @Autowired
    public JobSeekerSaveServiceImpl(JobSeekerSaveRepository jobSeekerSaveRepository) {
        this.jobSeekerSaveRepository = jobSeekerSaveRepository;
    }

    public List<JobSeekerSave> getCandidatesJob(JobSeekerProfile userAccountId){
        return jobSeekerSaveRepository.findByUserId(userAccountId);
    }

    public List<JobSeekerSave> getJobCandidates(JobPostActivity job){
        return jobSeekerSaveRepository.findByJob(job);
    }

    @Override
    public void addNew(JobSeekerSave jobSeekerSave) {
        jobSeekerSaveRepository.save(jobSeekerSave);
    }
}
