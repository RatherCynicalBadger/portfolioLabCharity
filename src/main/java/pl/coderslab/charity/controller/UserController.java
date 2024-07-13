package pl.coderslab.charity.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.entity.UserEntity;
import pl.coderslab.charity.security.CustomUser;
import pl.coderslab.charity.service.CustomUserService;

@Controller
@AllArgsConstructor
public class UserController {
    private final CustomUserService customUserService;

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("user", new UserEntity());
        return "register";
    }

    @PostMapping("/register")
    public String registerNewUser(@ModelAttribute UserEntity user) {

        user = customUserService.save(user);

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

    @GetMapping("/user_details")
    public String userDetailsPage(Model model, @AuthenticationPrincipal CustomUser customUser) {
        model.addAttribute("currentUser", customUser.generateBasicInfo());
        return "user-details";
    }
}
