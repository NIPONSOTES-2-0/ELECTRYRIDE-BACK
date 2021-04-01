package edu.escuelaing.eci.ieti.services;

import edu.escuelaing.eci.ieti.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserServices {
    void save(User user);
    void update(User user,String email);
    List<User> getUsers();
	User getUserbyEmail(String email);
	void deleteUser(String email);
}