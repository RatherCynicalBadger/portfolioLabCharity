package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.charity.entity.Role;
import pl.coderslab.charity.entity.UserEntity;

import java.util.List;

public interface UserEntityRepository extends JpaRepository<UserEntity, Integer> {

    UserEntity findByEmail(String email);

    List<UserEntity> findAllByRolesContaining(Role role);

    List<UserEntity> findAllByRolesNotContaining(Role role);
}
