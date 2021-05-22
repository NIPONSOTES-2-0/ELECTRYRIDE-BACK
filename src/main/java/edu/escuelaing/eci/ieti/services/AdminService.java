package edu.escuelaing.eci.ieti.services;

import edu.escuelaing.eci.ieti.models.Parking;
import edu.escuelaing.eci.ieti.models.Report;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AdminService {

    public List<Report> getReports();

    public List<Parking> getParkings();
}
