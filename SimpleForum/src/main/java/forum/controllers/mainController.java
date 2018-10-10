package forum.controllers;

import forum.models.user;
import forum.repository.userRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class mainController {

    @GetMapping("/reg")
    public String regPage(Model model) {
        model.addAttribute("user", new user());
        return "reg";
    }

    @Autowired
    private userRepo userR;

    @PostMapping("/regAction")
    public @ResponseBody String regUser(@Valid user usrVali, @ModelAttribute user usr, BindingResult bindingResult){


        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.toString());
            return "/reg";
        }

        userR.save(usr);
        return "data saved.";
    }
}