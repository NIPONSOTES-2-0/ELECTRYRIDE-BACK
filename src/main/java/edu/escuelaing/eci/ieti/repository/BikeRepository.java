package edu.escuelaing.eci.ieti.repository;

import edu.escuelaing.eci.ieti.models.Bike;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BikeRepository extends MongoRepository<Bike,String> {
    Optional<Bike> findById(String id);
}

