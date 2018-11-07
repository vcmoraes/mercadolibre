package br.com.mercadolibre.core.modelResponse;

import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import br.com.mercadolibre.core.util.StringUtil;

public class InstallmentResponse {

    @SerializedName("payment_method_id")
    private String paymentMethodId;

    @SerializedName("payment_type_id")
    private String paymentTypeId;

    @SerializedName("processing_mode")
    private String processingMode;

    @SerializedName("merchant_account_id")
    private String merchantAccountId;

    @SerializedName("issuer")
    private IssuerResponse issuerResponse;

    @SerializedName("payer_costs")
    private ArrayList<PayerCostResponse> payerCostsResponse;

    @NonNull
    public String getPaymentMethodId() {
        return StringUtil.fixString(paymentMethodId);
    }

    @NonNull
    public String getPaymentTypeId() {
        return StringUtil.fixString(paymentTypeId);
    }

    @NonNull
    public String getProcessingMode() {
        return StringUtil.fixString(processingMode);
    }

    @NonNull
    public String getMerchantAccountId() {
        return StringUtil.fixString(merchantAccountId);
    }

    @NonNull
    public IssuerResponse getIssuerResponse() {
        return issuerResponse == null ? new IssuerResponse() : issuerResponse;
    }

    @NonNull
    public ArrayList<PayerCostResponse> getPayerCostsResponse() {
        return payerCostsResponse == null ? new ArrayList<PayerCostResponse>() : payerCostsResponse;
    }
}
