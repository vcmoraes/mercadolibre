package br.com.mercadolibre.app.listerner;

import android.support.annotation.NonNull;

public interface ResponseViewListerner<MODEL> {

    void success(@NonNull MODEL response);

    void error(@NonNull String men);
}