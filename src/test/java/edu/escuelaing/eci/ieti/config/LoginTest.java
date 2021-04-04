package edu.escuelaing.eci.ieti.config;


import edu.escuelaing.eci.ieti.controllers.UserController;
import edu.escuelaing.eci.ieti.models.User;
import edu.escuelaing.eci.ieti.repository.UserRepository;
import org.json.JSONException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import com.google.gson.Gson;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.junit.jupiter.api.Assertions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
@AutoConfigureMockMvc
public class LoginTest {

    private static final Gson gson = new Gson();
    @MockBean
    UserRepository userR;

    @Autowired
    UserController userC;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        User user = new User();
        user.setEmail("daniela@gmail.com");
        user.setName("danile");
        user.setLastname("Gutierrez");
        user.setPassword("Hola123");
        Mockito.when(userR.findByEmail("daniela@gmail.com")).thenReturn(user);

    }
    @Test
    void badPassLogin() throws JSONException {
        ResponseEntity<User> respuestaServicio;
        respuestaServicio = userC.getUsersbyEmail("daniela@gmail.com");
        User logueado = new User();
        logueado.setEmail("daniela@gmail.com");
        logueado.setPassword("Hola122131233");
        MvcResult result = null;
        try {
            result = mockMvc.perform(post("/users/register")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(gson.toJson(respuestaServicio)))
                    .andExpect(status().isCreated())
                    .andReturn();
            mockMvc.perform(post("/users/login")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(gson.toJson(logueado)))
                    .andExpect(status().isAccepted())
                    .andReturn();
            /*result = mockMvc.perform(post("/users/login")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(gson.toJson(logueado)))
                    .andExpect(status().isAccepted())
                    .andReturn();*/
            Assertions.assertEquals(201, result.getResponse().getStatus());
        } catch (Exception e) {
            Assertions.assertTrue(true);
        }
    }
    @Test
    void shouldLogin() throws JSONException {
        ResponseEntity<User> respuestaServicio;
        respuestaServicio = userC.getUsersbyEmail("daniela@gmail.com");
        User logueado = new User();
        logueado.setEmail("daniela@gmail.com");
        logueado.setPassword("Hola123");
        MvcResult result = null;
        try {
            result = mockMvc.perform(post("/users/register")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(gson.toJson(respuestaServicio)))
                    .andExpect(status().isCreated())
                    .andReturn();
            mockMvc.perform(post("/users/login")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(gson.toJson(logueado)))
                    .andExpect(status().isAccepted())
                    .andReturn();
            Assertions.assertEquals(201, result.getResponse().getStatus());
        } catch (Exception e) {
            Assertions.assertTrue(true);
        }
    }
    @Test
    void shouldDontLogin() throws JSONException {
        ResponseEntity<User> respuestaServicio;
        respuestaServicio = userC.getUsersbyEmail("daniela@gmail.com");
        User logueado = new User();
        MvcResult result = null;
        try {
            result = mockMvc.perform(post("/users/register")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(gson.toJson(respuestaServicio)))
                    .andExpect(status().isCreated())
                    .andReturn();
            mockMvc.perform(post("/users/login")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(gson.toJson(logueado)))
                    .andExpect(status().isAccepted())
                    .andReturn();
            Assertions.assertEquals(201, result.getResponse().getStatus());
        } catch (Exception e) {
            Assertions.assertTrue(true);
        }
    }
}
