package uk.gegc.jobportal.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import uk.gegc.jobportal.entity.JobPostActivity;
import uk.gegc.jobportal.entity.JobSeekerProfile;
import uk.gegc.jobportal.entity.JobSeekerSave;
import uk.gegc.jobportal.entity.Users;
import uk.gegc.jobportal.service.JobPostActivityService;
import uk.gegc.jobportal.service.JobSeekerProfileService;
import uk.gegc.jobportal.service.JobSeekerSaveService;
import uk.gegc.jobportal.service.UsersService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class JobSeekerSaveController {
    private final UsersService usersService;
    private final JobSeekerProfileService jobSeekerProfileService;
    private final JobPostActivityService jobPostActivityService;
    private final JobSeekerSaveService jobSeekerSaveService;

    @PostMapping("job-details/save/{id}")
    public String save(@PathVariable("id") int id, JobSeekerSave jobSeekerSave){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(!(authentication instanceof AnonymousAuthenticationToken)){
            String currentUsername = authentication.getName();
            Users users = usersService.findByEmail(currentUsername);
            Optional<JobSeekerProfile> seekerProfile = jobSeekerProfileService.getOne(users.getUserId());
            JobPostActivity jobPostActivity = jobPostActivityService.getOne(id);
            if(seekerProfile.isPresent() && jobPostActivity != null){
                jobSeekerSave.setJob(jobPostActivity);
                jobSeekerSave.setUserId(seekerProfile.get());
            } else {
                throw new RuntimeException("User not found");
            }
            jobSeekerSaveService.addNew(jobSeekerSave);
        }
        return "redirect:/dashboard/";
    }

    @GetMapping("saved-jobs/")
    public String savedJobs(Model model){
        List<JobPostActivity> jobPost = new ArrayList<>();
        Object currentUserProfile = usersService.getCurrentUserProfile();
        List<JobSeekerSave> jobSeekerSaveList = jobSeekerSaveService.getCandidatesJob((JobSeekerProfile) currentUserProfile);
        for(JobSeekerSave jobSeekerSave: jobSeekerSaveList){
            jobPost.add(jobSeekerSave.getJob());
        }
        model.addAttribute("jobPost", jobPost);
        model.addAttribute("user", currentUserProfile);

        return "saved-jobs";
    }
}
