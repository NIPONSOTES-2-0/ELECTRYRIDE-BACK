package edu.escuelaing.eci.ieti.services;

import edu.escuelaing.eci.ieti.models.Report;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface ReportServices{
    void save(Report report);
    List<Report> getReport();
} 