package pl.coderslab.charity.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.repository.DonationRepository;

@Service
@AllArgsConstructor
public class DonationService {
    private final DonationRepository donationRepo;

    public int countAllBags() {
        return donationRepo.countAllBags();
    }

    public int countAllDonations() {
        return donationRepo.countAllDonations();
    }

    public Donation save(Donation donation) {
        return donationRepo.save(donation);
    }
}
