package io.magazine.makhzaneilm.repository;

import io.magazine.makhzaneilm.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<File, String> {
}
