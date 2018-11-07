package br.com.mercadolibre.app.usecase.payment;

import android.support.annotation.NonNull;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

import java.util.ArrayList;

import br.com.mercadolibre.app.listerner.ResponseViewListerner;
import br.com.mercadolibre.app.mapper.InstallmentMapper;
import br.com.mercadolibre.app.model.Bank;
import br.com.mercadolibre.app.model.Installment;
import br.com.mercadolibre.app.model.Payment;
import br.com.mercadolibre.core.api.payment.PaymentApi;
import br.com.mercadolibre.core.listerner.ResponseServer;
import br.com.mercadolibre.core.modelResponse.ErrorResponse;
import br.com.mercadolibre.core.modelResponse.InstallmentResponse;

@EBean(scope = EBean.Scope.Singleton)
public class GetInstallmentsUseCase {

    @Bean
    PaymentApi paymentApi;

    @Bean
    InstallmentMapper installmentMapper;

    public void getInstallments(@NonNull Double amount, @NonNull Payment payment, @NonNull Bank bank, final ResponseViewListerner<ArrayList<Installment>> listerner) {
        paymentApi.getInstallments(amount, payment.getId(), bank.getId(), new ResponseServer<ArrayList<InstallmentResponse>>() {
            @Override
            public void success(ArrayList<InstallmentResponse> response) {
                listerner.success(installmentMapper.responseToInstallment(response));
            }

            @Override
            public void error(ErrorResponse errorResponse) {
                listerner.error(errorResponse.getMen());
            }
        });
    }
}
