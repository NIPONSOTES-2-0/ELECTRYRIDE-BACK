package edu.escuelaing.eci.ieti.services;

import edu.escuelaing.eci.ieti.models.Support;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface SupportServices {
    void save(Support support);
    List<Support> getSupport();
}
