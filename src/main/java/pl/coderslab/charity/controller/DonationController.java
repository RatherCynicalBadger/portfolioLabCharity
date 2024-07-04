package pl.coderslab.charity.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import pl.coderslab.charity.service.DonationService;

@Controller
@AllArgsConstructor
public class DonationController {
    private final DonationService donationService;
}
