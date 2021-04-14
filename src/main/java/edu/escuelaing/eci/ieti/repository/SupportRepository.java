package edu.escuelaing.eci.ieti.repository;

import edu.escuelaing.eci.ieti.models.Support;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface SupportRepository extends MongoRepository<Support, String> {
    Optional<Support> findById(String id);
}
