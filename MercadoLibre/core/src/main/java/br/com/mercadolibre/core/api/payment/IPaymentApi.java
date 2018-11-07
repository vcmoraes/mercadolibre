package br.com.mercadolibre.core.api.payment;

import android.support.annotation.NonNull;

import java.util.ArrayList;

import br.com.mercadolibre.core.listerner.ResponseServer;
import br.com.mercadolibre.core.modelResponse.BankResponse;
import br.com.mercadolibre.core.modelResponse.InstallmentResponse;
import br.com.mercadolibre.core.modelResponse.PaymentResponse;

public interface IPaymentApi {

    void getPayments(@NonNull final ResponseServer<ArrayList<PaymentResponse>> listerner);

    void getBanks(@NonNull String paymentMethodId, @NonNull final ResponseServer<ArrayList<BankResponse>> listerner);

    void getInstallments(@NonNull Double amount, @NonNull String paymentMethodId, @NonNull String issuerId, @NonNull final ResponseServer<ArrayList<InstallmentResponse>> listerner);
}
