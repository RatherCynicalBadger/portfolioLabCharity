package pl.coderslab.charity.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.entity.UserEntity;
import pl.coderslab.charity.security.CharityAppUser;
import pl.coderslab.charity.service.CharityAppUserService;
import pl.coderslab.charity.service.InstitutionService;

import java.security.InvalidParameterException;

@Controller
@AllArgsConstructor
public class UserController {
    private final CharityAppUserService charityAppUserService;
    private final InstitutionService institutionService;

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

    @GetMapping("/admin/panel")
    public String adminPanel() {
        return "admin-panel";
    }

    @GetMapping("/admin/list")
    public String adminList(Model model, @RequestParam String mode) {

        switch (mode) {
            case "I":
                model.addAttribute("mode", "I");
                model.addAttribute("list", institutionService.findAll());
                break;
            case "A":
                model.addAttribute("mode", "A");
                model.addAttribute("list", charityAppUserService.findAllAdmins());
                break;
            case "U":
                model.addAttribute("mode", "U");
                model.addAttribute("list", charityAppUserService.findAllUsers());
                break;
            default:
                throw new InvalidParameterException("Stop playing with url.\n\n\n\t\tBastard.");
        }

        return "admin-list";
    }

    @GetMapping("/admin/edit")
    public String adminEditForm(Model model, @RequestParam String mode, @RequestParam Integer id) {

        Institution institution;
        UserEntity userEntity;

        switch (mode) {
            case "I":
                model.addAttribute("mode", "I");
                institution = (id == 0) ? new Institution() : institutionService.findById(id);
                userEntity = new UserEntity();
                break;
            case "A":
                model.addAttribute("mode", "A");
                userEntity = (id == 0) ? new UserEntity() : charityAppUserService.findById(id);
                institution = new Institution();
                break;
            case "U":
                model.addAttribute("mode", "U");
                userEntity = (id == 0) ? new UserEntity() : charityAppUserService.findById(id);
                institution = new Institution();
                break;
            default:
                throw new InvalidParameterException("Stop playing with url.\n\n\n\t\tBastard.");
        }

        model.addAttribute("inst", institution);
        model.addAttribute("user", userEntity);

        return "admin-edit";
    }

    @PostMapping("/admin/edit")
    public String adminEditAction(@ModelAttribute Institution inst, @ModelAttribute UserEntity user, @RequestParam String mode) {

        System.out.println("Mode: " + mode);
        System.out.println("inst.id: " + inst.getId());
        System.out.println("user.id: " + user.getId());

        switch (mode) {
            case "I":
                institutionService.save(inst);
                break;
            case "A":
                charityAppUserService.saveAdmin(user);
                break;
            case "U":
                charityAppUserService.save(user);
                break;
            default:
                throw new InvalidParameterException("Stop playing with url.\n\n\n\t\tBastard.");
        }

        return "redirect:/admin/list?mode=" + mode;
    }

    @PostMapping("/admin/delete")
    public String adminDeleteAction(@RequestParam String mode, @RequestParam Integer id) {
        switch (mode) {
            case "I":
                institutionService.deleteById(id);
                break;
            case "A", "U":
                charityAppUserService.deleteById(id);
                break;
            default:
                throw new InvalidParameterException("Stop playing with url.\n\n\n\t\tBastard.");
        }
        return "redirect:/admin/list?mode=" + mode;
    }
}
