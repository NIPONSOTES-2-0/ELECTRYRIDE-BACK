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

import edu.escuelaing.eci.ieti.services.ReportServices;
import edu.escuelaing.eci.ieti.models.Report;

@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/reporte")
public class ReportController {
    
    @Autowired
    ReportServices reportS;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<Report>> getReports(){
        return new ResponseEntity<>(reportS.getReport(), HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Optional<Report>> getReport(@PathVariable String id){
        return new ResponseEntity<>(reportS.getReportById(id), HttpStatus.ACCEPTED);
    }

    @RequestMapping(value="/", method = RequestMethod.POST)
    public ResponseEntity<Object> addReport(@RequestBody Report report) {
        System.out.println("\n Reporte nuevo: "+report);
        reportS.saveReport(report);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
