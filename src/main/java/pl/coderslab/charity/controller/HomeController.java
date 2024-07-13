package pl.coderslab.charity.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;

import java.util.List;


@Controller
@AllArgsConstructor
public class HomeController {

    private final InstitutionService institutionService;
    private final DonationService donationService;

    @RequestMapping("/home")
    public String homeAction(Model model) {
        List<Institution> allInst = institutionService.findAll();
        List<Institution> institutions1 = allInst.subList(0, allInst.size() / 2);
        List<Institution> institutions2 = allInst.subList(allInst.size() / 2, allInst.size());

        model.addAttribute("institutions_1", institutions1);
        model.addAttribute("institutions_2", institutions2);

        model.addAttribute("all_bags", donationService.countAllBags());
        model.addAttribute("all_donations", donationService.countAllDonations());
        return "index";
    }
}
