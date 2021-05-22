package edu.escuelaing.eci.ieti.controllers;

import edu.escuelaing.eci.ieti.models.Parking;
import edu.escuelaing.eci.ieti.models.Report;
import edu.escuelaing.eci.ieti.repository.ReportRepository;
import edu.escuelaing.eci.ieti.services.AdminService;
import edu.escuelaing.eci.ieti.services.ReportServices;
import org.junit.Assert;
import org.junit.Before;
import org.mockito.Mockito;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.assertj.core.api.Assertions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import java.util.Arrays;
import java.util.List;



public class ReportsAdminTest {

    private AdminController adminController;



    private AdminService adminService;

    private ReportServices reportService;



    @Before
    public void setUp(){
        System.out.println("\n Entra en SETUP \n");
        reportService = Mockito.mock(ReportServices.class);
        adminService = Mockito.mock(AdminService.class);
        System.out.println("\n admin services: "+reportService+"\n");
        adminController = new AdminController(adminService, reportService);

    }

    @Test
    public void deberiaRetornarReportControllerAdmin(){
        Report report01 = new Report("1","Eduard","opinion","Me gusta mucho la app, genial que esten en Colombia", "eduard@mail.com");
        Mockito.when(reportService.getReport()).thenReturn(Arrays.asList(report01));
        ResponseEntity<List<Report>> httpResponse = adminController.getReports();
        Assert.assertEquals(httpResponse.getStatusCode(), HttpStatus.ACCEPTED);
        Assert.assertEquals(report01, httpResponse.getBody().get(0));
    }

    @Test
    public void deberiaRetornarParkingControllerAdmin(){
        Parking parking01 = new Parking("1","ECI","Escuela Colombiana JG", Double.parseDouble("-79.1234"), Double.parseDouble("4.1723"), 45);
        Mockito.when(adminService.getParkings()).thenReturn(Arrays.asList(parking01));
        ResponseEntity<List<Parking>> httpResponse = adminController.getParkings();
        Assert.assertEquals(httpResponse.getStatusCode(), HttpStatus.ACCEPTED);
        Assert.assertEquals(parking01, httpResponse.getBody().get(0));
    }








}
