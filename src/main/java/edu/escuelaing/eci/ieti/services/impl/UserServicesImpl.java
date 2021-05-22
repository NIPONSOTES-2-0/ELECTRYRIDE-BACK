package edu.escuelaing.eci.ieti.services.impl;

import edu.escuelaing.eci.ieti.models.User;
import edu.escuelaing.eci.ieti.repository.UserRepository;
import edu.escuelaing.eci.ieti.services.UserServices;
import org.jasypt.util.password.PasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Component
public class UserServicesImpl implements UserServices {

    @Autowired
    UserRepository userR;

    @Autowired
    private PasswordEncryptor passwordEncryptor;

    @Override
    public void save(User user) {
        user.setPassword(passwordEncryptor.encryptPassword(user.getPassword()));
        userR.insert(user);
    }

    @Override
    public User update(User user) {
        Logger logger
                = Logger.getLogger(UserServicesImpl.class.getName());
        // Call info method
        User _user = getUserbyEmail(user.getEmail());
        logger.info("uno");
        logger.info(_user.toString());
        _user.setName(user.getName());
        _user.setLastname(user.getLastname());
        _user.setPassword(passwordEncryptor.encryptPassword(_user.getPassword()));
        logger.info("dos");
        logger.info(_user.toString());
        userR.save(_user);
        return _user;
        //deleteUser(email);
        //save(user);
        //_user.setName(user.getName());
        //_user.setLastname(user.getLastname());
        //_user.setPassword(passwordEncryptor.encryptPassword(user.getPassword()));
        //userR.insert(_user);
    }

    @Override
    public List<User> getUsers() {
        return userR.findAll();
    }

    @Override
	public User getUserbyEmail(String email) {
		return userR.findByEmail(email);
	}

    @Override
	public void deleteUser(String email) {
    	User _user= userR.findByEmail(email);
        userR.delete(_user);
	}
}