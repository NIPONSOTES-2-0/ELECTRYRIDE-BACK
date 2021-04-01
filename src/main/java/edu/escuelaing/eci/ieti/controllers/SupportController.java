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

import edu.escuelaing.eci.ieti.services.SupportServices;
import edu.escuelaing.eci.ieti.models.Support;

@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/api/apoyo")
public class SupportController {
    
    @Autowired
    SupportServices supportS;

    @RequestMapping(value = "/apoyo", method = RequestMethod.GET)
    public ResponseEntity<List<Support>> getSupport(){
        List<Support> supports = null;
        try{
            supports = supportS.getSupport();
            for(Support s: supports){
                System.out.print(s.toString());
            }
            return new ResponseEntity<>(supports, HttpStatus.ACCEPTED);
        } catch(Exception e){
            return null;
        }
    }

    @RequestMapping(value="/register", method = RequestMethod.POST)
    public ResponseEntity<Object> saveSupport(@RequestBody Support support) {
        try {
            System.out.println("\n Entra en post de support: "+ support + "\n ");
            supportS.save(support);
        } catch (Exception ex) {
            return new ResponseEntity<>("Error 404", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>( HttpStatus.ACCEPTED);
    }

}
