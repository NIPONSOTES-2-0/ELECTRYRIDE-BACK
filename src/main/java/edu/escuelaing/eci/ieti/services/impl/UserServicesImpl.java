package edu.escuelaing.eci.ieti.services.impl;

import edu.escuelaing.eci.ieti.models.User;
import edu.escuelaing.eci.ieti.repository.UserRepository;
import edu.escuelaing.eci.ieti.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServicesImpl implements UserServices {
    @Autowired
    UserRepository userR;

    @Override
    public void save(User user) {
        userR.save(user);
    }

    @Override
    public List<User> getUsers() {
        return userR.findAll();
    }
}