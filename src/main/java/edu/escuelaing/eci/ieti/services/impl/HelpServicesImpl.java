package edu.escuelaing.eci.ieti.services.impl;

import edu.escuelaing.eci.ieti.models.Help;
import edu.escuelaing.eci.ieti.repository.HelpRepository;
import edu.escuelaing.eci.ieti.services.HelpServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class HelpServicesImpl implements HelpServices {
    @Autowired
    HelpRepository helpR;

    @Override
    public void save(Help help){
        helpR.insert(help);
    }

    @Override
    public List<Help> getHelp(){
        return helpR.findAll();
    }

}
