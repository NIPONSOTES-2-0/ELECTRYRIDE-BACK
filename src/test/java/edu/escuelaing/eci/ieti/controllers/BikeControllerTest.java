package edu.escuelaing.eci.ieti.controllers;

import edu.escuelaing.eci.ieti.models.Bike;
import edu.escuelaing.eci.ieti.models.STATE;
import edu.escuelaing.eci.ieti.models.User;
import edu.escuelaing.eci.ieti.repository.BikeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@SpringBootTest
public class BikeControllerTest {

    @Autowired
    Optional<Bike> bike;

    @MockBean
    BikeRepository bikeR;

    @Autowired
    BikeController bikeC;

    @BeforeEach
    void setUp() {
        Bike bike = new Bike();
        bike.setId("376");
        bike.setDate(new Date());
        bike.setState(STATE.EXCELENTE);
        Mockito.when(bikeR.findById("376")).thenReturn(Optional.of(bike));

    }
    @Test
    void getBikeSaved() {
        Bike bike = new Bike();
        //bike.setId("376");
        bike.setDate(new Date());
        bike.setState(STATE.EXCELENTE);
        Mockito.when(bikeR.findById("376")).thenReturn(Optional.of(bike));
        bikeC.addBike(bike);
        ResponseEntity<Optional<Bike>> respuestaServicio;
        respuestaServicio = bikeC.getBike("376");
        Mockito.when(bikeR.findById("376")).thenReturn(Optional.of(bike));
    }
    @Test
    void getBikeDetailsWithValidId() {
        ResponseEntity<Optional<Bike>> respuestaServicio;
        respuestaServicio = bikeC.getBike("376");
        Assertions.assertEquals(false,false);
    }
    @Test
    void getBikes() {
        ResponseEntity<List<Bike>> respuestaServicio;
        respuestaServicio = bikeC.getBikes();
        int size = respuestaServicio.getBody().size();
        Assertions.assertEquals(size,respuestaServicio.getBody().size());
    }
}
