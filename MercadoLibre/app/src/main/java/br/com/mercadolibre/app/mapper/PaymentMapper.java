package br.com.mercadolibre.app.mapper;

import android.support.annotation.NonNull;

import org.androidannotations.annotations.EBean;

import java.util.ArrayList;

import br.com.mercadolibre.app.model.Payment;
import br.com.mercadolibre.core.modelResponse.PaymentResponse;

@EBean(scope = EBean.Scope.Singleton)
public class PaymentMapper {

    public Payment responseToPayment(PaymentResponse response) {
        Payment payment = new Payment();
        payment.setId(response.getId());
        payment.setName(response.getName());
        payment.setImage(response.getThumbnail());
        return payment;
    }

    public ArrayList<Payment> responseToPayment(@NonNull ArrayList<PaymentResponse> response) {
        ArrayList<Payment> payments = new ArrayList<>();
        for (PaymentResponse paymentResponse : response) {
            payments.add(responseToPayment(paymentResponse));
        }
        return payments;
    }
}
