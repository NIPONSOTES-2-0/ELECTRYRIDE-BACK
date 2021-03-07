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
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/api/bikes")
public class BicycleController {

    @Autowired
    private ParkingService parkingService;

    @RequestMapping(value="/parkings", method = RequestMethod.GET)
    public ResponseEntity<List<Parking>> getParking(){
        List<Parking> parkings = null;
        try {
            parkings = parkingService.getParkings();
            return new ResponseEntity<>(parkings, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            System.out.println("ERROR DE Get Parkings: "+ex);
            return null;
        }        
    }


    @RequestMapping(value="/parking/{id}", method=RequestMethod.GET)
    public ResponseEntity<Object> updateParking(@PathVariable String id) {
        System.out.println("ENTRANDO EN MODIFICAR APLICACION");
        try {
            System.out.println("\n Entra en post de parking: "+ id + "\n ");
            parkingService.rentedBike(id);            
        } catch (Exception ex) {
            return new ResponseEntity<>("Error 404", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>( HttpStatus.ACCEPTED);
    }

}
