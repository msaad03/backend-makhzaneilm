package io.magazine.makhzaneilm.repository;

import java.util.Optional;

import io.magazine.makhzaneilm.model.Role;
import io.magazine.makhzaneilm.model.enums.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
