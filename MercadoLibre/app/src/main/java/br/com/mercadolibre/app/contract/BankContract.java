package br.com.mercadolibre.app.contract;

import android.support.annotation.NonNull;

import java.util.ArrayList;

import br.com.mercadolibre.app.model.Bank;
import br.com.mercadolibre.app.model.Payment;

public interface BankContract {

    interface BankView {
        void onBanks(@NonNull ArrayList<Bank> banks);
        void onError(@NonNull String men);
    }

    interface BankPresenter {
        void getBanks(@NonNull Payment payment);
    }
}
