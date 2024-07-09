package pl.coderslab.charity.security;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.repository.UserEntityRepository;

@Service
@AllArgsConstructor
public class CustomUserService {

    private final UserEntityRepository userEntityRepository;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
}
