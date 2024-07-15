package pl.coderslab.charity.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.entity.UserEntity;
import pl.coderslab.charity.security.CharityAppUser;
import pl.coderslab.charity.service.CharityAppUserService;

@Controller
@AllArgsConstructor
public class UserController {
    private final CharityAppUserService charityAppUserService;

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("user", new UserEntity());
        return "register";
    }

    @PostMapping("/register")
    public String registerNewUser(@ModelAttribute UserEntity user) {

        user = charityAppUserService.save(user);

        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @RequestMapping("/failed")
    @ResponseBody
    public String loginFailure() {
        return "LOGIN FAILURE";
    }

    @RequestMapping("/user_details")
    public String userDetailsPage(Model model, @AuthenticationPrincipal CharityAppUser charityAppUser) {
        model.addAttribute("currentUser", charityAppUser.generateBasicInfo());
        return "user-details";
    }

    @GetMapping("/admin_panel")
    public String adminPanel() {
        return "admin-panel";
    }
}
