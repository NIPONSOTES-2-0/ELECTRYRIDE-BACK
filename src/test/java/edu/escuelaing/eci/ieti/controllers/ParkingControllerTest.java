package edu.escuelaing.eci.ieti.controllers;

import edu.escuelaing.eci.ieti.models.User;
import edu.escuelaing.eci.ieti.models.Parking;
import edu.escuelaing.eci.ieti.repository.UserRepository;
import edu.escuelaing.eci.ieti.repository.ParkingRepository;
import edu.escuelaing.eci.ieti.controllers.BicycleController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class ParkingControllerTest {

    @Autowired
    Optional<Parking> parking;
    //Optional<User> user;



    @MockBean
    ParkingRepository parkingRepository;

    @Autowired
    BicycleController parkingController;
    /*
    @BeforeEach
    void setUp() {
        User user = new User();
        // user.setId("376");
        user.setEmail("daniela@gmail.com");
        user.setName("danile");
        user.setLastname("Gutierrez");
        user.setPassword("Hola123");
        Mockito.when(userR.findByEmail("daniela@gmail.com")).thenReturn(user);

    }

    @Test
    void getUserSavedAndDelete() {
        User user1 = new User();
        user1.setEmail("quantum@gmail.com");
        user1.setName("crespo");
        user1.setLastname("wild");
        user1.setPassword("Hola123");
        userC.saveUser(user1);
        ResponseEntity<User> respuestaServicio;
        respuestaServicio = userC.getUsersbyEmail("quatum@gmail.com");
        Mockito.when(userR.findByEmail("quatum@gmail.com")).thenReturn(user1);
        userC.deleteUser(user1.getEmail());
    }

    @Test
    void getUserUpdate() {
        ResponseEntity<User> respuestaServicio;
        respuestaServicio = userC.getUsersbyEmail("daniela@gmail.com");
        respuestaServicio.getBody().setName("jaime");
        respuestaServicio.getBody().setLastname("altozano");
        userC.updateUser(respuestaServicio.getBody(),"daniela@gmail.com");
        Mockito.when(userR.findByEmail("daniela@gmail.com")).thenReturn(respuestaServicio.getBody());

    }

    @Test
    void getUserDetailsWithValidEmail() {
        ResponseEntity<User> respuestaServicio;
        respuestaServicio = userC.getUsersbyEmail("daniela@gmail.com");
        Assertions.assertEquals("danile",respuestaServicio.getBody().getName());
    }
    @Test
    void getUserDetailsWithInValidEmail() {
        Exception myException = null;
        ResponseEntity<User> respuestaServicio;
        respuestaServicio = userC.getUsersbyEmail("xxxx@gmail.com");
        Mockito.when(userC.getUsersbyEmail("xxxx@gmail.com")).thenThrow(new Exception());
        Assertions.assertEquals(myException.getErrorName(), "java.lang.NullPointerException");
    }*/

    @Test
    void getUserUpdate() {
        ResponseEntity<Object> respuestaServicio;

        respuestaServicio = parkingController.updateParking("-1");
        //respuestaServicio.getBody().setName("jaime");
        //respuestaServicio.getBody().setLastname("altozano");
        //userC.updateUser(respuestaServicio.getBody(),"daniela@gmail.com");
        //Mockito.when(userR.findByEmail("daniela@gmail.com")).thenReturn(respuestaServicio.getBody());
    }

    @Test
    void getUserUpdateException() {
        ResponseEntity<Object> respuestaServicio;

        respuestaServicio = parkingController.updateParking("a");
        //respuestaServicio.getBody().setName("jaime");
        //respuestaServicio.getBody().setLastname("altozano");
        //userC.updateUser(respuestaServicio.getBody(),"daniela@gmail.com");
        //Mockito.when(userR.findByEmail("daniela@gmail.com")).thenReturn(respuestaServicio.getBody());
    }

    @Test
    void getParkings() {
        ResponseEntity<List<Parking>> respuestaServicio;
        respuestaServicio = parkingController.getParking();
        int size = respuestaServicio.getBody().size();
        Assertions.assertEquals(size,respuestaServicio.getBody().size());
    }
}
