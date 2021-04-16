package edu.escuelaing.eci.ieti.repository;

import edu.escuelaing.eci.ieti.models.Report;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends MongoRepository<Report, String>{
    Optional<Report> findById(String id);
}
