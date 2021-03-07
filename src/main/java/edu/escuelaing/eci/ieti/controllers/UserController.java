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
@RequestMapping("/api/usuarios")
public class UserController {

    @Autowired
    UserServices userS;

    @RequestMapping(value="/" ,method = RequestMethod.GET)
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


    @RequestMapping(value="/register", method = RequestMethod.POST)
    public ResponseEntity<Object> saveUser(@RequestBody User user) {
        try {
            System.out.println("\n Entra en post de user: "+ user + "\n ");
            userS.save(user);
        } catch (Exception ex) {
            return new ResponseEntity<>("Error 404", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>( HttpStatus.ACCEPTED);
    }


}