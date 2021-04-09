package edu.escuelaing.eci.ieti.services;


import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import edu.escuelaing.eci.ieti.http.PaymentIntentDTO;
import org.springframework.stereotype.Service;

@Service
public interface PaymentService {

    PaymentIntent paymentIntent(PaymentIntentDTO paymentIntentDTO) throws StripeException;

    PaymentIntent confirm(String id) throws StripeException;

    PaymentIntent cancel(String id) throws StripeException;
}
