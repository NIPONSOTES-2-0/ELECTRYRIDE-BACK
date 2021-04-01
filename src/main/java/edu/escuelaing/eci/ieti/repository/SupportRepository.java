package edu.escuelaing.eci.ieti.repository;

import edu.escuelaing.eci.ieti.models.Support;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupportRepository extends MongoRepository<Support, String> {
    
}
