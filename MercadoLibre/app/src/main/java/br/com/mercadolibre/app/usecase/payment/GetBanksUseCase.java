package br.com.mercadolibre.app.usecase.payment;

import android.support.annotation.NonNull;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

import java.util.ArrayList;

import br.com.mercadolibre.app.listerner.ResponseViewListerner;
import br.com.mercadolibre.app.mapper.BankMapper;
import br.com.mercadolibre.app.model.Bank;
import br.com.mercadolibre.app.model.Payment;
import br.com.mercadolibre.core.api.payment.PaymentApi;
import br.com.mercadolibre.core.listerner.ResponseServer;
import br.com.mercadolibre.core.modelResponse.BankResponse;
import br.com.mercadolibre.core.modelResponse.ErrorResponse;

@EBean(scope = EBean.Scope.Singleton)
public class GetBanksUseCase {

    @Bean
    PaymentApi paymentApi;

    @Bean
    BankMapper bankMapper;

    public void getBanks(@NonNull Payment payment, final ResponseViewListerner<ArrayList<Bank>> listerner) {
        paymentApi.getBanks(payment.getId(), new ResponseServer<ArrayList<BankResponse>>() {
            @Override
            public void success(ArrayList<BankResponse> response) {
                listerner.success(bankMapper.responseToBank(response));
            }

            @Override
            public void error(ErrorResponse errorResponse) {
                listerner.error(errorResponse.getMen());
            }
        });
    }
}
