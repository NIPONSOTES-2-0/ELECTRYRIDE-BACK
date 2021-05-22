package edu.escuelaing.eci.ieti.services.impl;

import edu.escuelaing.eci.ieti.models.Parking;
import edu.escuelaing.eci.ieti.models.Report;
import edu.escuelaing.eci.ieti.repository.ParkingRepository;
import edu.escuelaing.eci.ieti.repository.ReportRepository;
import edu.escuelaing.eci.ieti.services.AdminService;
import edu.escuelaing.eci.ieti.services.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private ParkingRepository parkingRepository;

    @Autowired
    private  ReportRepository reportRepository;

    @Override
    public List<Report> getReports() {
        List<Report> reports = reportRepository.findAll();
        return reports;
    }


    @Override
    public List<Parking> getParkings() {
        List<Parking> parkings = parkingRepository.findAll();
        return parkings;
    }

}
