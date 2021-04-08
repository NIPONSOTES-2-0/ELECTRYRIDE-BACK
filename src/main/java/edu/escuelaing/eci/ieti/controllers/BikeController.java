package edu.escuelaing.eci.ieti.controllers;

import java.util.List;
import java.util.Optional;

import edu.escuelaing.eci.ieti.models.Bike;
import edu.escuelaing.eci.ieti.services.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/bikes")
public class BikeController {

    @Autowired
    private BikeService bikeS;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public ResponseEntity<List<Bike>> getBikes(){
        return new ResponseEntity<>(bikeS.getBikes(), HttpStatus.ACCEPTED);
    }


    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<Optional<Bike>> getBike(@PathVariable String id) {
        return new ResponseEntity<>(bikeS.getBikeById(id), HttpStatus.ACCEPTED);
    }

    @RequestMapping(value="/", method=RequestMethod.POST)
    public ResponseEntity<Object> addBike(@RequestBody Bike bike) {
        bikeS.saveBike(bike);
        return new ResponseEntity<>( HttpStatus.CREATED);
    }


}
