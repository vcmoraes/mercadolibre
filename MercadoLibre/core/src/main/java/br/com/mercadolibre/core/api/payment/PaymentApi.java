package br.com.mercadolibre.core.api.payment;

import android.content.Context;
import android.support.annotation.NonNull;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.ArrayList;

import br.com.mercadolibre.core.api.BaseApi;
import br.com.mercadolibre.core.listerner.ResponseServer;
import br.com.mercadolibre.core.modelResponse.BankResponse;
import br.com.mercadolibre.core.modelResponse.InstallmentResponse;
import br.com.mercadolibre.core.modelResponse.PaymentResponse;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

@EBean(scope = EBean.Scope.Singleton)
public class PaymentApi implements IPaymentApi {

    @RootContext
    Context context;

    private BaseApi<PaymentRetrofit> paymentApi = new BaseApi<>(PaymentRetrofit.class);


    @Override
    public void getPayments(@NonNull final ResponseServer<ArrayList<PaymentResponse>> listerner) {
        paymentApi.getApi().getPayments().observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new Observer<Response<ArrayList<PaymentResponse>>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Response<ArrayList<PaymentResponse>> response) {
                listerner.success(response.body());
            }

            @Override
            public void onError(Throwable e) {
                paymentApi.verifyErrorDefault(context, e, listerner);
            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void getBanks(@NonNull String paymentMethodId, @NonNull final ResponseServer<ArrayList<BankResponse>> listerner) {
        paymentApi.getApi().getBanks(paymentMethodId).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new Observer<Response<ArrayList<BankResponse>>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Response<ArrayList<BankResponse>> response) {
                listerner.success(response.body());
            }

            @Override
            public void onError(Throwable e) {
                paymentApi.verifyErrorDefault(context, e, listerner);
            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void getInstallments(@NonNull Double amount, @NonNull String paymentMethodId, @NonNull String issuerId, @NonNull final ResponseServer<ArrayList<InstallmentResponse>> listerner) {
        paymentApi.getApi().getInstallments(amount, paymentMethodId, issuerId).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new Observer<Response<ArrayList<InstallmentResponse>>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Response<ArrayList<InstallmentResponse>> response) {
                listerner.success(response.body());
            }

            @Override
            public void onError(Throwable e) {
                paymentApi.verifyErrorDefault(context, e, listerner);
            }

            @Override
            public void onComplete() {

            }
        });
    }
}
