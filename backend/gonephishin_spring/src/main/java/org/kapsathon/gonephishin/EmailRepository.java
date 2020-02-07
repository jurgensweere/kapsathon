package org.kapsathon.gonephishin;

import java.util.Optional;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface EmailRepository extends
  CrudRepository<Email, String> {
     
    Optional<Email> findById(String id);
}
