package edu.escuelaing.eci.ieti.services;

import edu.escuelaing.eci.ieti.models.Report;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public interface ReportServices{
    void saveReport(Report report);
    List<Report> getReport();
    Optional<Report> getReportById(String id);
} 