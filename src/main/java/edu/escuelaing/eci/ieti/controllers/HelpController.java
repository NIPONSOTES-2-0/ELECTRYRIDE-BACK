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

import edu.escuelaing.eci.ieti.services.HelpServices;
import edu.escuelaing.eci.ieti.models.Help;


@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/api/b-ayuda")
public class HelpController {
    
    @Autowired
    HelpServices helpS;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<Help>> getHelps(){
        return new ResponseEntity<>(helpS.getHelp(), HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Optional<Help>> getHelp(@PathVariable String id){
        return new ResponseEntity<>(helpS.getHelpById(id), HttpStatus.ACCEPTED);
    }

    @RequestMapping(value="/", method = RequestMethod.POST)
    public ResponseEntity<Object> addHelp(@RequestBody Help help) {
        helpS.saveHelp(help);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }



    
}
