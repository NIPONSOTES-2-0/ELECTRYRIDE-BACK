package edu.escuelaing.eci.ieti.repository;


import edu.escuelaing.eci.ieti.models.Parking;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingRepository extends MongoRepository<Parking, String> {
}
