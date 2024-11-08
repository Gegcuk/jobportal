package uk.gegc.jobportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.gegc.jobportal.entity.RecruiterProfile;
import uk.gegc.jobportal.repository.RecruiterProfileRepository;

import java.util.Optional;

@Service
public class RecruiterProfileServiceImpl implements RecruiterProfileService{
    private final RecruiterProfileRepository recruiterProfileRepository;

    @Autowired
    public RecruiterProfileServiceImpl(RecruiterProfileRepository recruiterProfileRepository) {
        this.recruiterProfileRepository = recruiterProfileRepository;
    }

    @Override
    public Optional<RecruiterProfile> getOne(Integer id) {
        return recruiterProfileRepository.findById(id);
    }

    @Override
    public RecruiterProfile addNew(RecruiterProfile recruiterProfile) {
        return recruiterProfileRepository.save(recruiterProfile);
    }
}
