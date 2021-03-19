package edu.escuelaing.eci.ieti.services.impl;

import edu.escuelaing.eci.ieti.models.Report;
import edu.escuelaing.eci.ieti.repository.ReportRepository;
import edu.escuelaing.eci.ieti.services.ReportServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class ReportServicesImpl implements ReportServices {
    @Autowired
    ReportRepository reportR;

    @Override 
    public void save(Report report){
        reportR.insert(report);
    }

    @Override
    public List<Report> getReport(){
        return reportR.findAll();
    }
}
