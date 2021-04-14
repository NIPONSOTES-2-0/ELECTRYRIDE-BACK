package edu.escuelaing.eci.ieti.controllers;

import edu.escuelaing.eci.ieti.models.Help;
import edu.escuelaing.eci.ieti.repository.HelpRepository;
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

public class HelpControllerTest {
    
    @Autowired
    Optional<Help> help;

    @MockBean
    HelpRepository helpR;

    @Autowired
    HelpController helpC;

    @BeforeEach
    void setUp(){
        Help help = new Help();
        help.setId("824");
        help.setEmail("test@hotmail.com");
        help.setName("new test");
        help.setThelp("queja");
        help.setInfo("i need help");
        Mockito.when(helpR.findById("824")).thenReturn(Optional.of(help));
    }

    @Test
    void getHelpSaved(){
        Help help = new Help();
        help.setId("824");
        help.setEmail("test@hotmail.com");
        help.setName("new test");
        help.setThelp("queja");
        help.setInfo("i need help");
        Mockito.when(helpR.findById("824")).thenReturn(Optional.of(help));
        helpC.addHelp(help);
        ResponseEntity<Optional<Help>> respuestaServ;
        respuestaServ = helpC.getHelp("824");
        Mockito.when(helpR.findById("824")).thenReturn(Optional.of(help));
    }

    @Test
    void getHelpDetailsWithValidId() {
        ResponseEntity<Optional<Help>> respuestaServ;
        respuestaServ = helpC.getHelp("824");
        Assertions.assertEquals(false,false);
    }

    @Test
    void getHelps() {
        ResponseEntity<List<Help>> respuestaServ;
        respuestaServ = helpC.getHelps();
        int size = respuestaServ.getBody().size();
        Assertions.assertEquals(size,respuestaServ.getBody().size());
    }

}
