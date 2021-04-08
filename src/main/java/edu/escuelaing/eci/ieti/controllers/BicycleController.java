package edu.escuelaing.eci.ieti.controllers;

import java.util.List;

import edu.escuelaing.eci.ieti.models.Parking;
import edu.escuelaing.eci.ieti.services.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/bikes")
public class BicycleController {

    @Autowired
    private ParkingService parkingService;

    @RequestMapping(value="/parkings", method = RequestMethod.GET)
    public ResponseEntity<List<Parking>> getParking(){
        List<Parking> parkings = null;
        parkings = parkingService.getParkings();
        return new ResponseEntity<>(parkings, HttpStatus.ACCEPTED);
    }


    @RequestMapping(value="/parking/{id}", method=RequestMethod.GET)
    public ResponseEntity<Object> updateParking(@PathVariable String id) {
        parkingService.rentedBike(id);
        return new ResponseEntity<>( HttpStatus.ACCEPTED);
    }

}
