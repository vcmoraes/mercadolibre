package br.com.mercadolibre.app.usecase.payment;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

import java.util.ArrayList;

import br.com.mercadolibre.app.listerner.ResponseViewListerner;
import br.com.mercadolibre.app.mapper.PaymentMapper;
import br.com.mercadolibre.app.model.Payment;
import br.com.mercadolibre.core.api.payment.PaymentApi;
import br.com.mercadolibre.core.listerner.ResponseServer;
import br.com.mercadolibre.core.modelResponse.ErrorResponse;
import br.com.mercadolibre.core.modelResponse.PaymentResponse;

@EBean(scope = EBean.Scope.Singleton)
public class GetPaymentsUseCase {

    @Bean
    PaymentApi paymentApi;

    @Bean
    PaymentMapper paymentMapper;

    public void getPayments(final ResponseViewListerner<ArrayList<Payment>> listerner) {
        paymentApi.getPayments(new ResponseServer<ArrayList<PaymentResponse>>() {
            @Override
            public void success(ArrayList<PaymentResponse> response) {
                listerner.success(paymentMapper.responseToPayment(response));
            }

            @Override
            public void error(ErrorResponse errorResponse) {
                listerner.error(errorResponse.getMen());
            }
        });
    }
}
