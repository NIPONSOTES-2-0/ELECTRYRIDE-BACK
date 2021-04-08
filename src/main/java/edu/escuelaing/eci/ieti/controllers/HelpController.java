package edu.escuelaing.eci.ieti.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

    @RequestMapping(value = "/ayuda", method = RequestMethod.GET)
    public ResponseEntity<List<Help>> getHelps(){
        List<Help> helps = null;
        try{
            helps = helpS.getHelp();
            for(Help h: helps){
                System.out.print(h.toString());
            }
            return new ResponseEntity<>(helps, HttpStatus.ACCEPTED);
        } catch(Exception e){
            return null;
        }
    }

    @RequestMapping(value="/register", method = RequestMethod.POST)
    public ResponseEntity<Object> saveHelp(@RequestBody Help help) {
        try {
            System.out.println("\n Entra en post de help: "+ help + "\n ");
            helpS.save(help);
        } catch (Exception ex) {
            return new ResponseEntity<>("Error 404", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>( HttpStatus.ACCEPTED);
    }



    
}
