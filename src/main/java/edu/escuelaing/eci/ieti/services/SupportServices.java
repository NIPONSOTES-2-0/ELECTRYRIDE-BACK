package edu.escuelaing.eci.ieti.services;

import edu.escuelaing.eci.ieti.models.Support;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public interface SupportServices {
    void saveSup(Support support);
    List<Support> getSup();
    Optional<Support> getSupById(String id);
}
