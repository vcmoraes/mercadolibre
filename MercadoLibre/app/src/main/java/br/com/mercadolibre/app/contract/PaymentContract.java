package br.com.mercadolibre.app.contract;

import android.support.annotation.NonNull;

import java.util.ArrayList;

import br.com.mercadolibre.app.model.Payment;

public interface PaymentContract {

    interface PaymentView {
        void onPayments(@NonNull ArrayList<Payment> payments);
        void onError(@NonNull String men);
    }

    interface PaymentPresenter {
        void getPayments();
    }
}
