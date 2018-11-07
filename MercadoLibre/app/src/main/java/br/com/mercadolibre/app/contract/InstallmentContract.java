package br.com.mercadolibre.app.contract;

import android.support.annotation.NonNull;

import java.util.ArrayList;

import br.com.mercadolibre.app.model.Bank;
import br.com.mercadolibre.app.model.Installment;
import br.com.mercadolibre.app.model.Payment;

public interface InstallmentContract {

    interface InstallmentView {
        void onInstallments(@NonNull ArrayList<Installment> installments);
        void onError(@NonNull String men);
    }

    interface InstallmentPresenter {
        void getInstallments(double value, @NonNull Payment payment, @NonNull Bank bank);
    }
}
