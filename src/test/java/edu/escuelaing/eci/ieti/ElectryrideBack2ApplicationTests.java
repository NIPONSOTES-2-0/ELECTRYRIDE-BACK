package edu.escuelaing.eci.ieti;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.escuelaing.eci.ieti.services.UserServices;

@RunWith(SpringRunner.class)
@SpringBootTest
class ElectryrideBack2ApplicationTests {

	@Autowired
	UserServices userS; 
	
	@Test
	void consultaTablaUsuarios() {
		assertTrue(userS.getUsers()!=null);
	}
}
