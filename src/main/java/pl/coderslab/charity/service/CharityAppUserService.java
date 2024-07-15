package pl.coderslab.charity.service;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.UserEntity;
import pl.coderslab.charity.repository.RoleRepository;
import pl.coderslab.charity.repository.UserEntityRepository;
import pl.coderslab.charity.security.CharityAppUser;

@Service
@AllArgsConstructor
public class CharityAppUserService implements UserDetailsService {

    private final UserEntityRepository userEntityRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public UserEntity save(UserEntity userEntity) {
        userEntity.setPassword(encoder.encode(userEntity.getPassword()));
        userEntity.getRoles().add(roleRepository.getRoleByName("ROLE_USER"));
        return userEntityRepository.save(userEntity);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity userEntity = userEntityRepository.findByEmail(email);
        if (userEntity == null) {
            throw new UsernameNotFoundException(email + " not found in DB");
        } else {
            return new CharityAppUser(userEntity);
        }
    }
}
