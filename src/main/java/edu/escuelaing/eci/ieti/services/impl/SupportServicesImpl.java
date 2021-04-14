package edu.escuelaing.eci.ieti.services.impl;

import edu.escuelaing.eci.ieti.models.Support;
import edu.escuelaing.eci.ieti.repository.SupportRepository;
import edu.escuelaing.eci.ieti.services.SupportServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
public class SupportServicesImpl implements SupportServices {
    @Autowired
    SupportRepository supportR;

    @Override
    public void saveSup(Support support){
        supportR.save(support);
    }
    
    @Override
    public List<Support> getSup(){
        return supportR.findAll();
    }

    @Override
    public Optional<Support> getSupById(String id){
        return supportR.findById(id);
    }

}
