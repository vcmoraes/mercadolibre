package br.com.mercadolibre.app.mapper;

import android.support.annotation.NonNull;

import org.androidannotations.annotations.EBean;

import java.util.ArrayList;

import br.com.mercadolibre.app.model.PayerCost;
import br.com.mercadolibre.core.modelResponse.PayerCostResponse;

@EBean(scope = EBean.Scope.Singleton)
public class PayerCostMapper {

    public PayerCost responseToPayerCost(PayerCostResponse response) {
        PayerCost payerCost = new PayerCost();
        payerCost.setRecommendedMessage(response.getRecommendedMessage());
        return payerCost;
    }

    public ArrayList<PayerCost> responseToPayerCost(@NonNull ArrayList<PayerCostResponse> response) {
        ArrayList<PayerCost> payerCosts = new ArrayList<>();
        for (PayerCostResponse payerCostResponse : response) {
            payerCosts.add(responseToPayerCost(payerCostResponse));
        }
        return payerCosts;
    }
}
