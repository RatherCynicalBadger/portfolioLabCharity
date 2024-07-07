package pl.coderslab.charity.service;

import pl.coderslab.charity.entity.Donation;

public interface DonationService {

    int countAllBags();

    int countAllDonations();

    Donation save(Donation donation);
}
