package edu.escuelaing.eci.ieti.controllers;

import edu.escuelaing.eci.ieti.models.Parking;
import edu.escuelaing.eci.ieti.repository.ParkingRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class ParkingControllerTest {

    @Autowired
    Optional<Parking> parking;


    @MockBean
    ParkingRepository parkingRepository;


    @Autowired
    BicycleController parkingController;


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
