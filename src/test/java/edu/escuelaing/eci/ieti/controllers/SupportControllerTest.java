package edu.escuelaing.eci.ieti.controllers;

import edu.escuelaing.eci.ieti.models.Support;
import edu.escuelaing.eci.ieti.repository.SupportRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class SupportControllerTest {
    
    @Autowired
    Optional<Support> supp;

    @MockBean
    SupportRepository suppR;

    @Autowired
    SupportController suppC;

    @BeforeEach
    void setUp(){
        Support supp = new Support();
        supp.setId("824");
        supp.setEmail("test@hotmail.com");
        supp.setName("new test");
        supp.setInfo("i need support");
        Mockito.when(suppR.findById("824")).thenReturn(Optional.of(supp));
    }

    @Test
    void getSuppSaved(){
        Support supp = new Support();
        supp.setId("824");
        supp.setEmail("test@hotmail.com");
        supp.setName("new test");
        supp.setInfo("i need support");
        Mockito.when(suppR.findById("824")).thenReturn(Optional.of(supp));
        suppC.addSup(supp);
        ResponseEntity<Optional<Support>> respuestaServ;
        respuestaServ = suppC.getSup("824");
        Mockito.when(suppR.findById("824")).thenReturn(Optional.of(supp));
    }

    @Test
    void getHelpDetailsWithValidId() {
        ResponseEntity<Optional<Support>> respuestaServ;
        respuestaServ = suppC.getSup("824");
        Assertions.assertEquals(false,false);
    }

    @Test
    void getHelps() {
        ResponseEntity<List<Support>> respuestaServ;
        respuestaServ = suppC.getSups();
        int size = respuestaServ.getBody().size();
        Assertions.assertEquals(size,respuestaServ.getBody().size());
    }

}
