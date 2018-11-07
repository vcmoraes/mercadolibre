package br.com.mercadolibre.core.api;

import android.content.Context;
import android.support.annotation.NonNull;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.io.IOException;

import br.com.mercadolibre.core.R;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

@EBean(scope = EBean.Scope.Singleton)
public class InitCore {

    @RootContext
    Context context;

    public void init() {
        ApiClient.getInstance().setEndPoint("https://api.mercadopago.com", new Interceptor() {
            @Override
            public Response intercept(@NonNull Chain chain) throws IOException {
                Request original = chain.request();
                HttpUrl originalHttpUrl = original.url();
                HttpUrl url = originalHttpUrl.newBuilder()
                        .addQueryParameter("public_key", context.getString(R.string.public_key))
                        .build();
                Request.Builder requestBuilder = original.newBuilder()
                        .url(url);
                Request request = requestBuilder.build();
                return chain.proceed(request);
            }
        });
        ApiClient.getInstance().withLog();
    }
}
