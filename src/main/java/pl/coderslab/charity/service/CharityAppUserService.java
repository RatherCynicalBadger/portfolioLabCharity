package pl.coderslab.charity.service;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.Role;
import pl.coderslab.charity.entity.UserEntity;
import pl.coderslab.charity.repository.RoleRepository;
import pl.coderslab.charity.repository.UserEntityRepository;
import pl.coderslab.charity.security.CharityAppUser;

import java.util.List;

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

    public UserEntity saveAdmin(UserEntity userEntity) {
        userEntity.setPassword(encoder.encode(userEntity.getPassword()));
        userEntity.getRoles().add(roleRepository.getRoleByName("ROLE_USER"));
        userEntity.getRoles().add(roleRepository.getRoleByName("ROLE_ADMIN"));
        return userEntityRepository.save(userEntity);
    }

    public void deleteById(Integer id) {
        userEntityRepository.deleteById(id);
    }

    public UserEntity findById(Integer id) {
        return userEntityRepository.findById(id).orElseThrow();
    }

    public List<UserEntity> findAllUsers() {
        Role adminRole = roleRepository.getRoleByName("ROLE_ADMIN");
        return userEntityRepository.findAllByRolesNotContaining(adminRole);
    }

    public List<UserEntity> findAllAdmins() {
        Role adminRole = roleRepository.getRoleByName("ROLE_ADMIN");
        return userEntityRepository.findAllByRolesContaining(adminRole);
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
