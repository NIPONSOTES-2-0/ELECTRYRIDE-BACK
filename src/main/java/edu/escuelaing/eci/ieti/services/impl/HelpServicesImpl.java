package edu.escuelaing.eci.ieti.services.impl;

import edu.escuelaing.eci.ieti.models.Help;
import edu.escuelaing.eci.ieti.repository.HelpRepository;
import edu.escuelaing.eci.ieti.services.HelpServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
public class HelpServicesImpl implements HelpServices {

    @Autowired
    HelpRepository helpR;

    @Override
    public void saveHelp(Help help){
        helpR.save(help);
    }

    @Override
    public Optional<Help> getHelpById(String id){
        return helpR.findById(id);
    }

    @Override
    public List<Help> getHelp(){
        return helpR.findAll();
    }

}
