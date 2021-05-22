package edu.escuelaing.eci.ieti.controllers;

import edu.escuelaing.eci.ieti.models.User;
import edu.escuelaing.eci.ieti.services.UserServices;
import edu.escuelaing.eci.ieti.models.Token;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.jasypt.util.password.PasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserServices userS;

    @Autowired
    private PasswordEncryptor passwordEncryptor;

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
    @RequestMapping(value="/login",method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody User user) throws ServletException{
        String jwtToken = "";
        if (user.getEmail() == null || user.getPassword()== null) {
            throw new ServletException("Please fill in username and password");
        }

        String email = user.getEmail();
        String password = user.getPassword();

        User _user = userS.getUserbyEmail(email);

        String pwd = _user.getPassword();

        if (!passwordEncryptor.checkPassword(password, pwd)) {

            throw new ServletException("Invalid login. Please check your name and password.");
        }

        jwtToken = Jwts.builder().setSubject(email).claim("roles", "user").setIssuedAt(new Date()).signWith(
                SignatureAlgorithm.HS256, "secretkey").compact();
        return new ResponseEntity<>(new Token(jwtToken, _user), HttpStatus.OK);
    }
    @RequestMapping(value="/register", method = RequestMethod.POST)
    public ResponseEntity<Object> saveUser(@RequestBody User user) {
        try {
            userS.save(user);
        } catch (Exception ex) {
            return new ResponseEntity<>("Error 404", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>( HttpStatus.CREATED);
    }

    /*
    @RequestMapping(value="/", method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User _user = null;
        try {
             _user = userS.update(user);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(_user, HttpStatus.ACCEPTED);
    }*/

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