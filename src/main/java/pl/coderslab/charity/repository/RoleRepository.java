package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.charity.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role getRoleByName(String name);
}
