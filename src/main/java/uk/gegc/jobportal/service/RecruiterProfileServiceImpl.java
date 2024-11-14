package uk.gegc.jobportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uk.gegc.jobportal.entity.RecruiterProfile;
import uk.gegc.jobportal.entity.Users;
import uk.gegc.jobportal.repository.RecruiterProfileRepository;
import uk.gegc.jobportal.repository.UsersRepository;

import java.util.Optional;

@Service
public class RecruiterProfileServiceImpl implements RecruiterProfileService{
    private final RecruiterProfileRepository recruiterProfileRepository;
    private final UsersRepository usersRepository;

    @Autowired
    public RecruiterProfileServiceImpl(RecruiterProfileRepository recruiterProfileRepository, UsersRepository usersRepository) {
        this.recruiterProfileRepository = recruiterProfileRepository;
        this.usersRepository = usersRepository;
    }

    @Override
    public Optional<RecruiterProfile> getOne(Integer id) {
        return recruiterProfileRepository.findById(id);
    }

    @Override
    public RecruiterProfile addNew(RecruiterProfile recruiterProfile) {
        return recruiterProfileRepository.save(recruiterProfile);
    }

    @Override
    public RecruiterProfile getCurrentRecruiterProfile() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(!(authentication instanceof AnonymousAuthenticationToken)){
            String currentUserName = authentication.getName();
            Users users = usersRepository.findByEmail(currentUserName).orElseThrow(() -> new UsernameNotFoundException("User not found"));
            Optional<RecruiterProfile> recruitProfile = getOne(users.getUserId());
            return recruitProfile.orElse(null);
        } else return null;
    }
}
