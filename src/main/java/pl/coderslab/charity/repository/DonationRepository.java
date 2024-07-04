package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.charity.entity.Donation;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Integer> {

    @Query("SELECT sum(d.quantity) FROM Donation d")
    int countAllBags();

    @Query("SELECT count(d) FROM Donation d")
    int countAllDonations();
}
