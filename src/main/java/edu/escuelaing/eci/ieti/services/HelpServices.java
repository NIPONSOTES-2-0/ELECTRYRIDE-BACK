package edu.escuelaing.eci.ieti.services;

import edu.escuelaing.eci.ieti.models.Help;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public interface HelpServices {
    void saveHelp(Help help);
    List<Help> getHelp();
    Optional<Help> getHelpById(String id);
}
