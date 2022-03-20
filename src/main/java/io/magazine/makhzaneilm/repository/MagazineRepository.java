package io.magazine.makhzaneilm.repository;

import io.magazine.makhzaneilm.entity.Magazine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MagazineRepository extends JpaRepository<Magazine, Long>  {
    Optional<Magazine> findByMonth(String month);
}