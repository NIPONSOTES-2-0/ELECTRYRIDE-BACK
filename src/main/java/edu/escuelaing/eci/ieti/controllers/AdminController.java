package edu.escuelaing.eci.ieti.controllers;

import edu.escuelaing.eci.ieti.models.Parking;
import edu.escuelaing.eci.ieti.models.Report;
import edu.escuelaing.eci.ieti.services.AdminService;
import edu.escuelaing.eci.ieti.services.ReportServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins="http://localhost:3000")
public class AdminController {


    public final AdminService adminService;

    public final ReportServices reportService;

    @Autowired
    public AdminController(AdminService adminService, ReportServices reportService){
        this.adminService = adminService;
        this.reportService = reportService;
    }



    /*
    @Autowired
    public AdminController(ReportServices reportService){
        System.out.println("ENTRANDO EN ADMIN CONTROLLER CONSTRUCTOR: "+reportService);
        this.reportService = reportService;
        System.out.println("ENTRANDO EN ADMIN CONTROLLER This.adminService: "+this.reportService);
    }*/



    @GetMapping("/parkings")
    public ResponseEntity<List<Parking>> getParkings(){
        try{
            return new ResponseEntity<>(adminService.getParkings(), HttpStatus.ACCEPTED);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/reports")
    public ResponseEntity<List<Report>> getReports(){
        try{
            return new ResponseEntity<>(reportService.getReport(), HttpStatus.ACCEPTED);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
