package uk.gegc.jobportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import uk.gegc.jobportal.entity.Users;
import uk.gegc.jobportal.entity.UsersType;
import uk.gegc.jobportal.service.UsersTypeService;

import java.util.List;

@Controller
public class UsersController {

    private final UsersTypeService usersTypeService;

    @Autowired
    public UsersController(UsersTypeService usersTypeService) {
        this.usersTypeService = usersTypeService;
    }

    @GetMapping("/register")
    public String register(Model model){
        List<UsersType> usersTypes = usersTypeService.getAll();
        model.addAttribute("getAll", usersTypes);
        model.addAttribute("user", new Users());
        return "register";
    }
}
