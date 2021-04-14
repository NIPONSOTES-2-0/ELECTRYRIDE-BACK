package edu.escuelaing.eci.ieti.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.escuelaing.eci.ieti.services.SupportServices;
import edu.escuelaing.eci.ieti.models.Support;

@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/api/apoyo")
public class SupportController {
    
    @Autowired
    SupportServices supportS;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<Support>> getSups(){
        return new ResponseEntity<>(supportS.getSup(), HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Optional<Support>> getSup(@PathVariable String id){
        return new ResponseEntity<>(supportS.getSupById(id), HttpStatus.ACCEPTED);
    }

    @RequestMapping(value="/", method = RequestMethod.POST)
    public ResponseEntity<Object> addSup(@RequestBody Support sup) {
        supportS.saveSup(sup);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
