package org.kapsathon.gonephishin;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// @EnableScan
@Repository
public interface EmailRepository extends JpaRepository<Email, String> {
     
    Optional<Email> findById(String id);
}
