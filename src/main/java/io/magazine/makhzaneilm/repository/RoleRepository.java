package io.magazine.makhzaneilm.repository;

import java.util.Optional;

import io.magazine.makhzaneilm.entity.Role;
import io.magazine.makhzaneilm.constants.enums.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {
    Optional<Role> findByName(ERole name);
}
