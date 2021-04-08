package edu.escuelaing.eci.ieti.services;

import java.util.List;

import edu.escuelaing.eci.ieti.models.Parking;
import org.springframework.stereotype.Service;

@Service
public interface ParkingService {

    List<Parking> getParkings();

    void rentedBike(String id);

}
