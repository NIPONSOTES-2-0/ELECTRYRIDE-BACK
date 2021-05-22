package edu.escuelaing.eci.ieti.services;

import edu.escuelaing.eci.ieti.controllers.AdminController;
import edu.escuelaing.eci.ieti.models.Report;
import edu.escuelaing.eci.ieti.services.impl.AdminServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

public class AdminServicesTest {

    @Autowired
    private AdminService adminService; //= new AdminServiceImpl();

    @Before
    public void setUp(){
        System.out.println("\n Entra en SETUP \n");
        adminService = Mockito.mock(AdminService.class);
        System.out.println("\n admin services: "+adminService+"\n");
        //adminController = new AdminController(reportService);

    }

    @Test
    public void testeandoAdminService() {
        System.out.println("\n adminServiceTEST: "+adminService);
        System.out.println("\n testeando AdminService: "+adminService.getReports());
        Report report01 = new Report("1","Eduard","opinion","Me gusta mucho la app, genial que esten en Colombia", "eduard@mail.com");
        Mockito.when(adminService.getReports()).thenReturn(Arrays.asList(report01));

        Assert.assertEquals(report01, adminService.getReports().get(0));
    }
}


