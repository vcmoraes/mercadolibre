package br.com.mercadolibre.app;

import android.app.Application;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EApplication;

import br.com.mercadolibre.core.api.InitCore;

@EApplication
public class AppApplication extends Application {

    @Bean
    InitCore initCore;

    @Override
    public void onCreate() {
        super.onCreate();
        initCore.init();
    }
}
