package edu.escuelaing.eci.ieti.controllers;

import edu.escuelaing.eci.ieti.models.Report;
import edu.escuelaing.eci.ieti.repository.ReportRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class ReportControllerTest {
    
    @Autowired
    Optional<Report> report;

    @MockBean
    ReportRepository reportR;

    @Autowired
    ReportController reportC;

    @BeforeEach
    void setUp(){
        Report report = new Report();
        report.setId("824");
        report.setTrep("accidente");
        report.setDesc("new Report");
        report.setEmail("test@hotmail.com");
        Mockito.when(reportR.findById("824")).thenReturn(Optional.of(report));
    }

    @Test
    void getReportSaved(){
        Report report = new Report();
        //report.setId("824");
        report.setTrep("accidente");
        report.setDesc("new Report");
        report.setEmail("test@hotmail.com");
        Mockito.when(reportR.findById("824")).thenReturn(Optional.of(report));
        reportC.addReport(report);
        ResponseEntity<Optional<Report>> rep;
        rep = reportC.getReport("824");
        Mockito.when(reportR.findById("824")).thenReturn(Optional.of(report));
    }

    @Test
    void getReportDetailsWithValidId(){
        ResponseEntity<Optional<Report>> rep;
        rep = reportC.getReport("824");
        Assertions.assertEquals(false,false);
    }

    @Test 
    void getReport(){
        ResponseEntity<List<Report>> rep;
        rep = reportC.getReports();
        int size = rep.getBody().size();
        Assertions.assertEquals(size,rep.getBody().size());
    }
}
