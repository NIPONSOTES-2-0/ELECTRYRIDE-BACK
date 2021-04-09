package edu.escuelaing.eci.ieti.controllers;


import com.stripe.exception.StripeException;
import edu.escuelaing.eci.ieti.http.PaymentIntentDTO;
import edu.escuelaing.eci.ieti.controllers.PaymentController;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.ResponseEntity;

import java.util.Calendar;

@SpringBootTest
public class PaymentControllerTest {


    @Autowired
    PaymentIntentDTO paymentIntentDTO;
    //Optional<User> user;


    @Autowired
    PaymentController paymentController;
    


    @Test
    void postconfirm() {
        try {
            paymentController.confirm("pm_1IVJXhEq3EyAQ22JOBSbcL3s");
        } catch (StripeException e) {
            e.printStackTrace();
        }
    }

    @Test
    void postCancel(){
        try {
            paymentController.cancel("1");
        } catch (StripeException e) {
            e.printStackTrace();
        }
    }

}
