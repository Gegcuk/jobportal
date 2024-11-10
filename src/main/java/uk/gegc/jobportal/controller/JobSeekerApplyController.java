package uk.gegc.jobportal.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import uk.gegc.jobportal.entity.JobPostActivity;
import uk.gegc.jobportal.service.JobPostActivityService;
import uk.gegc.jobportal.service.UsersService;

@Controller
@AllArgsConstructor
public class JobSeekerApplyController {

    private final JobPostActivityService jobPostActivityService;
    private final UsersService usersService;

    @GetMapping("job-details-apply/{id}")
    private String display(@PathVariable("id") int id, Model model){
        JobPostActivity jobDetails = jobPostActivityService.getOne(id);
        model.addAttribute("jobDetails", jobDetails);
        model.addAttribute("user", usersService.getCurrentUserProfile());
        return "job-details";
    }
}
