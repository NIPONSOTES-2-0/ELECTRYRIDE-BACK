package edu.escuelaing.eci.ieti.services.impl;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import edu.escuelaing.eci.ieti.http.PaymentIntentDTO;
import edu.escuelaing.eci.ieti.services.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Component
public class PaymentServiceImpl implements PaymentService {

    @Value("${stripe.key.secret}")
    public String secretKey;

    /*
        Creamos una clase PaymentDTO donde se almacena el objeto información de producto
        Luego instanciamos el PaymentIntent de Stripe y le pasamos nuestra información por medio
        de los parametros.
    */
    @Override
    public PaymentIntent paymentIntent(PaymentIntentDTO paymentIntentDTO) throws StripeException {
        Stripe.apiKey = secretKey;
        Map<String, Object> params = new HashMap<>();
        params.put("amount",paymentIntentDTO.getAmount());
        params.put("currency",paymentIntentDTO.getCurrency());
        params.put("description",paymentIntentDTO.getDescription());
        ArrayList paymentMetodTypes = new ArrayList<>();
        //el tipo de pago es tarjeta de credito
        paymentMetodTypes.add("card");
        params.put("payment_method_types",paymentMetodTypes);
        return PaymentIntent.create(params);
    }


    /*
        Confirmamos el pago validando que la tarjeta sea visa
        CON RETRIEVE recuperamos el pago por el id de pago y lo confirmamos o lo cancelamos
    */
    @Override
    public PaymentIntent confirm(String id) throws StripeException {
        Stripe.apiKey = secretKey;
        PaymentIntent paymentIntent = PaymentIntent.retrieve(id);

        Map<String, Object> params = new HashMap<>();
        params.put("payment_method", "pm_card_visa");
        paymentIntent.confirm(params);
        return paymentIntent;
    }

    @Override
    public PaymentIntent cancel(String id) throws StripeException {
        Stripe.apiKey = secretKey;
        PaymentIntent paymentIntent = PaymentIntent.retrieve(id);
        paymentIntent.cancel();
        return paymentIntent;
    }

}
