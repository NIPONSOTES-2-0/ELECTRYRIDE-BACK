package edu.escuelaing.eci.ieti.controllers;

import edu.escuelaing.eci.ieti.models.User;
import edu.escuelaing.eci.ieti.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class UserController {

    @Autowired
    UserServices userS;

    @RequestMapping(value="/user" ,method = RequestMethod.GET)
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = null;
        try {
            users = userS.getUsers();
            for(User u : users){
                System.out.print(u.toString());
            }
            return new ResponseEntity<>(users, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            return null;
        }
    }
    /*@RequestMapping(value="/user", method = RequestMethod.POST)
    public ResponseEntity<Object> saveUser(@RequestBody User user) {
        try {
            userS.save(user);
        } catch (Exception ex) {
            return new ResponseEntity<>("Error 404", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>( HttpStatus.ACCEPTED);
    }*/


}