package br.com.mercadolibre.app.mapper;

import android.support.annotation.NonNull;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

import java.util.ArrayList;

import br.com.mercadolibre.app.model.Installment;
import br.com.mercadolibre.core.modelResponse.InstallmentResponse;

@EBean(scope = EBean.Scope.Singleton)
public class InstallmentMapper {

    @Bean
    PayerCostMapper payerCostMapper;

    public Installment responseToInstallment(InstallmentResponse response) {
        Installment installment = new Installment();
        installment.setCosts(payerCostMapper.responseToPayerCost(response.getPayerCostsResponse()));
        return installment;
    }

    public ArrayList<Installment> responseToInstallment(@NonNull ArrayList<InstallmentResponse> response) {
        ArrayList<Installment> installments = new ArrayList<>();
        for (InstallmentResponse installmentResponse : response) {
            installments.add(responseToInstallment(installmentResponse));
        }
        return installments;
    }
}
