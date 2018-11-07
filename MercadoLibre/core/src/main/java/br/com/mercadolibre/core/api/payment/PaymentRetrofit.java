package br.com.mercadolibre.core.api.payment;

import android.support.annotation.NonNull;

import java.util.ArrayList;

import br.com.mercadolibre.core.modelResponse.BankResponse;
import br.com.mercadolibre.core.modelResponse.InstallmentResponse;
import br.com.mercadolibre.core.modelResponse.PaymentResponse;
import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PaymentRetrofit {

    @GET("/v1/payment_methods")
    Observable<Response<ArrayList<PaymentResponse>>> getPayments();

    @GET("/v1/payment_methods/card_issuers")
    Observable<Response<ArrayList<BankResponse>>> getBanks(@Query("payment_method_id") @NonNull String paymentMethodId);

    @GET("/v1/payment_methods/installments")
    Observable<Response<ArrayList<InstallmentResponse>>> getInstallments(@Query("amount") double amount, @Query("payment_method_id") @NonNull String paymentMethodId, @Query("issuer.id") @NonNull String issuerId);
}
