package edu.escuelaing.eci.ieti.controllers;

import edu.escuelaing.eci.ieti.models.User;
import edu.escuelaing.eci.ieti.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserServices userS;

    @RequestMapping(value="/" ,method = RequestMethod.GET)
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = null;
        try {
            users = userS.getUsers();
            return new ResponseEntity<>(users, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path="/{email}" ,method = RequestMethod.GET)
    public ResponseEntity<User> getUsersbyEmail(@PathVariable String email) {
        User users = null;
        try {
            users = userS.getUserbyEmail(email);
            return new ResponseEntity<>(users, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value="/register", method = RequestMethod.POST)
    public ResponseEntity<Object> saveUser(@RequestBody User user) {
        try {
            userS.save(user);
        } catch (Exception ex) {
            return new ResponseEntity<>("Error 404", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>( HttpStatus.ACCEPTED);
    }

    @RequestMapping(value="/{email}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateUser(@RequestBody User user, @PathVariable String email) {
        try {
            userS.update(user,email);
        } catch (Exception ex) {
            return new ResponseEntity<>("Error 404", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>( HttpStatus.ACCEPTED);
    }

    @RequestMapping(value="/{email}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteUser(@PathVariable String email) {
        try {
            userS.deleteUser(email);
        } catch (Exception ex) {
            return new ResponseEntity<>("Error 404", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>( HttpStatus.ACCEPTED);
    }

}