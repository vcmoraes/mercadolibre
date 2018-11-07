package br.com.mercadolibre.app.presenter;

import android.support.annotation.NonNull;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

import java.util.ArrayList;

import br.com.mercadolibre.app.contract.InstallmentContract;
import br.com.mercadolibre.app.listerner.ResponseViewListerner;
import br.com.mercadolibre.app.model.Bank;
import br.com.mercadolibre.app.model.Installment;
import br.com.mercadolibre.app.model.Payment;
import br.com.mercadolibre.app.usecase.payment.GetInstallmentsUseCase;

@EBean
public class InstallmentPresenter extends Presenter<InstallmentContract.InstallmentView> implements InstallmentContract.InstallmentPresenter {

    @Bean
    GetInstallmentsUseCase getInstallmentsUseCase;

    @Override
    public void getInstallments(double value, @NonNull Payment payment, @NonNull Bank bank) {
        getInstallmentsUseCase.getInstallments(value, payment, bank, new ResponseViewListerner<ArrayList<Installment>>() {
            @Override
            public void success(@NonNull ArrayList<Installment> response) {
                getView().onInstallments(response);
            }

            @Override
            public void error(@NonNull String men) {
                getView().onError(men);
            }
        });
    }
}
