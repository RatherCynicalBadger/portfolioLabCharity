package pl.coderslab.charity.service_implementation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.repository.CategoryRepository;
import pl.coderslab.charity.service.CategoryService;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepo;
}
