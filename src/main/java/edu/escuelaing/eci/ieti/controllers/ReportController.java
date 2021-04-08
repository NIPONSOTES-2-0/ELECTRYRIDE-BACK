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

import edu.escuelaing.eci.ieti.services.ReportServices;
import edu.escuelaing.eci.ieti.models.Report;

@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/api/reporte")
public class ReportController {
    
    @Autowired
    ReportServices reportS;

    @RequestMapping(value = "/reporte", method = RequestMethod.GET)
    public ResponseEntity<List<Report>> getReport(){
        List<Report> reports = null;
        try{
            reports = reportS.getReport();
            for(Report r: reports){
                System.out.print(r.toString());
            }
            return new ResponseEntity<>(reports, HttpStatus.ACCEPTED);
        } catch(Exception e){
            return null;
        }
    }

    @RequestMapping(value="/register", method = RequestMethod.POST)
    public ResponseEntity<Object> saveReport(@RequestBody Report report) {
        try {
            System.out.println("\n Entra en post de help: "+ report + "\n ");
            reportS.save(report);
        } catch (Exception ex) {
            return new ResponseEntity<>("Error 404", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>( HttpStatus.ACCEPTED);
    }


}
