package edu.escuelaing.eci.ieti.services.impl;

import edu.escuelaing.eci.ieti.models.Support;
import edu.escuelaing.eci.ieti.repository.SupportRepository;
import edu.escuelaing.eci.ieti.services.SupportServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class SupportServicesImpl implements SupportServices {
    @Autowired
    SupportRepository supportR;

    @Override
    public void save(Support support){
        supportR.insert(support);
    }
    
    @Override
    public List<Support> getSupport(){
        return supportR.findAll();
    }

}
