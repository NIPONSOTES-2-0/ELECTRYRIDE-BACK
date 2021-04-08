package edu.escuelaing.eci.ieti.repository;


import edu.escuelaing.eci.ieti.models.Help;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HelpRepository extends MongoRepository<Help, String>{    
}
