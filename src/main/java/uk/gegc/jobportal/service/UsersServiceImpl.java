package uk.gegc.jobportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uk.gegc.jobportal.entity.JobSeekerProfile;
import uk.gegc.jobportal.entity.RecruiterProfile;
import uk.gegc.jobportal.entity.Users;
import uk.gegc.jobportal.repository.JobSeekerProfileRepository;
import uk.gegc.jobportal.repository.RecruiterProfileRepository;
import uk.gegc.jobportal.repository.UsersRepository;

import java.util.Date;
import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;
    private final JobSeekerProfileRepository jobSeekerProfileRepository;
    private final RecruiterProfileRepository recruiterProfileRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UsersServiceImpl(UsersRepository usersRepository, JobSeekerProfileRepository jobSeekerProfileRepository, RecruiterProfileRepository recruiterProfileRepository, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.jobSeekerProfileRepository = jobSeekerProfileRepository;
        this.recruiterProfileRepository = recruiterProfileRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Users addNew(Users users){
        users.setActive(true);
        users.setRegistrationDate(new Date(System.currentTimeMillis()));
        users.setPassword(passwordEncoder.encode(users.getPassword()));
        Users savedUser = usersRepository.save(users);
        int userTypeId = users.getUserTypeId().getUserTypeId();
        System.out.printf(savedUser.toString());
        System.out.println(userTypeId);
        if(userTypeId == 1){
            recruiterProfileRepository.save(new RecruiterProfile(savedUser));
        } else {
            jobSeekerProfileRepository.save(new JobSeekerProfile(savedUser));
        }
        return savedUser;
    }

    @Override
    public Optional<Users> getUserByEmail(String email){
        return usersRepository.findByEmail(email);
    }

    @Override
    public Object getCurrentUserProfile() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(!(authentication instanceof AnonymousAuthenticationToken)){
            String username = authentication.getName();
            Users users = usersRepository.findByEmail(username).orElseThrow(()->new UsernameNotFoundException("Could not find " + username));
            int userId = users.getUserId();
            if(authentication.getAuthorities().contains(new SimpleGrantedAuthority("Recruiter"))){
                RecruiterProfile recruiterProfile = recruiterProfileRepository.findById(userId).orElse(new RecruiterProfile());
                return recruiterProfile;
            } else {
                JobSeekerProfile jobSeekerProfile = jobSeekerProfileRepository.findById(userId).orElse(new JobSeekerProfile());
                return jobSeekerProfile;
            }
        }
        return null;
    }
}
