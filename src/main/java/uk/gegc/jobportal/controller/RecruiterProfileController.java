package uk.gegc.jobportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import uk.gegc.jobportal.entity.RecruiterProfile;
import uk.gegc.jobportal.entity.Users;
import uk.gegc.jobportal.repository.UsersRepository;
import uk.gegc.jobportal.service.RecruiterProfileService;
import uk.gegc.jobportal.util.FileUploadUtil;

import java.util.Objects;
import java.util.Optional;

@Controller
@RequestMapping("/recruiter-profile")
public class RecruiterProfileController {

    private final UsersRepository usersRepository;
    private final RecruiterProfileService recruiterProfileService;

    @Autowired
    public RecruiterProfileController(UsersRepository usersRepository, RecruiterProfileService recruiterProfileService) {
        this.usersRepository = usersRepository;
        this.recruiterProfileService = recruiterProfileService;
    }

    @GetMapping("/")
    public String recruitProfile(Model model){
       Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
       if(!(authentication instanceof AnonymousAuthenticationToken)){
            String currentUsername = authentication.getName();
            Users users = usersRepository.findByEmail(currentUsername).orElseThrow(()->new UsernameNotFoundException("Could not find user: " + currentUsername));
            Optional<RecruiterProfile> recruiterProfileOptional = recruiterProfileService.getOne(users.getUserId());
           recruiterProfileOptional.ifPresent(recruiterProfile -> model.addAttribute("profile", recruiterProfile));
       }
       return "recruiter_profile";
    }

    @PostMapping("/addNew")
    public String addNew(RecruiterProfile recruiterProfile, @RequestParam(value = "image", required = false)MultipartFile multipartFile, Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(!(authentication instanceof AnonymousAuthenticationToken)){
            String currentUserName = authentication.getName();
            Users users = usersRepository.findByEmail(currentUserName).orElseThrow(()->new UsernameNotFoundException("Could not find user: " + currentUserName));
            recruiterProfile.setUserId(users);
            recruiterProfile.setUserAccountId(users.getUserId());
        }
        model.addAttribute("profile", recruiterProfile);
        String fileName = "";
        if(!Objects.equals(multipartFile.getOriginalFilename(), "")){
            fileName = StringUtils.cleanPath(Objects.requireNonNull(multipartFile.getOriginalFilename()));
            recruiterProfile.setProfilePhoto(fileName);
        }
        RecruiterProfile savedUser = recruiterProfileService.addNew(recruiterProfile);

        String uploadDir = "photos/recruiter/" + savedUser.getUserAccountId();
        try{
            FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
        } catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/dashboard/";
    }

}
