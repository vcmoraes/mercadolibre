package br.com.mercadolibre.app.presenter;


import android.support.annotation.NonNull;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

import java.util.ArrayList;

import br.com.mercadolibre.app.contract.BankContract;
import br.com.mercadolibre.app.listerner.ResponseViewListerner;
import br.com.mercadolibre.app.model.Bank;
import br.com.mercadolibre.app.model.Payment;
import br.com.mercadolibre.app.usecase.payment.GetBanksUseCase;

@EBean
public class BankPresenter extends Presenter<BankContract.BankView> implements BankContract.BankPresenter {

    @Bean
    GetBanksUseCase getBanksUseCase;

    @Override
    public void getBanks(@NonNull Payment payment) {
        getBanksUseCase.getBanks(payment, new ResponseViewListerner<ArrayList<Bank>>() {
            @Override
            public void success(@NonNull ArrayList<Bank> response) {
                getView().onBanks(response);
            }

            @Override
            public void error(@NonNull String men) {
                getView().onError(men);
            }
        });

    }
}
