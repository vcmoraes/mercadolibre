package br.com.mercadolibre.app.presenter;

import android.support.annotation.NonNull;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

import java.util.ArrayList;

import br.com.mercadolibre.app.contract.PaymentContract;
import br.com.mercadolibre.app.listerner.ResponseViewListerner;
import br.com.mercadolibre.app.model.Payment;
import br.com.mercadolibre.app.usecase.payment.GetPaymentsUseCase;

@EBean
public class PaymentPresent extends Presenter<PaymentContract.PaymentView> implements PaymentContract.PaymentPresenter {

    @Bean
    GetPaymentsUseCase getPaymentsUseCase;

    @Override
    public void getPayments() {
        getPaymentsUseCase.getPayments(new ResponseViewListerner<ArrayList<Payment>>() {
            @Override
            public void success(@NonNull ArrayList<Payment> response) {
                getView().onPayments(response);
            }

            @Override
            public void error(@NonNull String men) {
                getView().onError(men);
            }
        });
    }
}
