package edu.escuelaing.eci.ieti.services.impl;

import edu.escuelaing.eci.ieti.models.User;
import edu.escuelaing.eci.ieti.repository.UserRepository;
import edu.escuelaing.eci.ieti.services.UserServices;
import org.jasypt.util.password.PasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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
    public void update(User user, String email) {
        User _user = getUserbyEmail(email);
        userR.delete(_user);
        userR.save(user);
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