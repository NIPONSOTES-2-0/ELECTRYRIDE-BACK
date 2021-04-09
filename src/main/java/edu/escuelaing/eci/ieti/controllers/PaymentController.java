package edu.escuelaing.eci.ieti.controllers;

import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import edu.escuelaing.eci.ieti.http.PaymentIntentDTO;
import edu.escuelaing.eci.ieti.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/stripe")
@CrossOrigin(origins="http://localhost:3000")
@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/payment")
    public ResponseEntity<String> payment(@RequestBody PaymentIntentDTO paymentIntentDTO) throws StripeException {
        PaymentIntent paymentIntent = paymentService.paymentIntent(paymentIntentDTO);
        String paymentString = paymentIntent.toJson();
        System.out.println("Payment Intento JSON: "+paymentString);
        return new ResponseEntity<String>(paymentString, HttpStatus.OK);
    }


    //Confirmamos el pago
    @PostMapping("/confirm/{id}")
    public ResponseEntity<String> confirm(@RequestParam String id) throws StripeException {
        PaymentIntent paymentIntent = paymentService.confirm(id);
        String paymentString = paymentIntent.toJson();
        System.out.println("On confirm paymentIntento JSON: "+paymentString);
        return new ResponseEntity<String>(paymentString, HttpStatus.OK);
    }

    @PostMapping("/cancel/{id}")
    public ResponseEntity<String> cancel(@PathVariable String id) throws StripeException {
        PaymentIntent paymentIntent = paymentService.cancel(id);
        String paymentString = paymentIntent.toJson();
        System.out.println("On cancel PaymentIntent JSON: "+paymentString);
        return new ResponseEntity<String>(paymentString, HttpStatus.OK);
    }




}