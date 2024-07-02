package pl.coderslab.charity.service_implementation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.service.DonationService;

@Service
@AllArgsConstructor
public class DonationServiceImpl implements DonationService {
    private final DonationRepository donationRepo;
}
