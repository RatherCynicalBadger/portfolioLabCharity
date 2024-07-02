package pl.coderslab.charity.service_implementation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.repository.InstitutionRepository;
import pl.coderslab.charity.service.InstitutionService;

@Service
@AllArgsConstructor
public class InstitutionServiceImpl implements InstitutionService {
    private final InstitutionRepository institutionRepo;
}
