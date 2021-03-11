package edu.escuelaing.eci.ieti.services;

import edu.escuelaing.eci.ieti.models.Help;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface HelpServices {
    void save(Help help);
    List<Help> getHelp();
}
