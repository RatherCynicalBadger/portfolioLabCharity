package pl.coderslab.charity.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class InstitutionService {
    private final InstitutionRepository institutionRepo;

    public List<Institution> findAll() {
        return institutionRepo.findAll();
    }
}
