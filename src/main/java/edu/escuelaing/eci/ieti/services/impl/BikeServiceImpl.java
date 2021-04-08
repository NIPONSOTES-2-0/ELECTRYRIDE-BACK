package edu.escuelaing.eci.ieti.services.impl;

import edu.escuelaing.eci.ieti.models.Bike;
import edu.escuelaing.eci.ieti.repository.BikeRepository;
import edu.escuelaing.eci.ieti.services.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BikeServiceImpl implements BikeService {

    @Autowired
    BikeRepository bikeR;

    @Override
    public List<Bike> getBikes() {
        return bikeR.findAll();
    }

    @Override
    public Optional<Bike> getBikeById(String id) {
       return bikeR.findById(id);
    }

    @Override
    public void saveBike(Bike bike) {
        bikeR.save(bike);
    }

}
