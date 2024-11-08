package uk.gegc.jobportal.service;

import uk.gegc.jobportal.entity.RecruiterProfile;

import java.util.Optional;

public interface RecruiterProfileService {
    public Optional<RecruiterProfile> getOne(Integer id);

    RecruiterProfile addNew(RecruiterProfile recruiterProfile);
}
