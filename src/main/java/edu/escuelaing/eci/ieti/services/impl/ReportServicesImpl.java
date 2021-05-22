package edu.escuelaing.eci.ieti.services.impl;

import edu.escuelaing.eci.ieti.models.Report;
import edu.escuelaing.eci.ieti.repository.ReportRepository;
import edu.escuelaing.eci.ieti.services.ReportServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
public class ReportServicesImpl implements ReportServices {
    
    @Autowired
    ReportRepository reportR;

    @Override 
    public void saveReport(Report report){
        System.out.println("\n Va a guardar el reporte: "+report+" \n");
        reportR.save(report);
        System.out.println("\n GUARDÓ EL REPORTE: "+report+" \n");
    }

    @Override
    public List<Report> getReport(){
        return reportR.findAll();
    }

    public Optional<Report> getReportById(String id){
        return reportR.findById(id);
    }
}
