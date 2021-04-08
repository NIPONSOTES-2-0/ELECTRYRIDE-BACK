package edu.escuelaing.eci.ieti.services;


import edu.escuelaing.eci.ieti.models.Bike;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface BikeService{

    List<Bike> getBikes();
    Optional<Bike> getBikeById(String id);
    void saveBike(Bike bike);

}
