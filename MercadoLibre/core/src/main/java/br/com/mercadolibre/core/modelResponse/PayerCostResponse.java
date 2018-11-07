package br.com.mercadolibre.core.modelResponse;

import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import br.com.mercadolibre.core.util.StringUtil;

public class PayerCostResponse {

    @SerializedName("installments")
    private Integer installments;

    @SerializedName("installment_rate")
    private Double installmentRate;

    @SerializedName("discount_rate")
    private Double discountRate;

    @SerializedName("min_allowed_amount")
    private Double minAllowedAmount;

    @SerializedName("max_allowed_amount")
    private Double maxAllowedAmount;

    @SerializedName("installment_amount")
    private Double installmentAmount;

    @SerializedName("total_amount")
    private Double totalAmount;

    @SerializedName("recommended_message")
    private String recommendedMessage;

    @SerializedName("labels")
    private ArrayList<String> labels;

    @SerializedName("installment_rate_collector")
    private ArrayList<String> installmentRateCollector;

    @NonNull
    public Integer getInstallments() {
        return installments == null ? 0 : installments;
    }

    @NonNull
    public Double getInstallmentRate() {
        return installmentRate == null ? 0 : installmentRate;
    }

    @NonNull
    public Double getDiscountRate() {
        return discountRate == null ? 0 : discountRate;
    }

    @NonNull
    public Double getMinAllowedAmount() {
        return minAllowedAmount == null ? 0 : minAllowedAmount;
    }

    @NonNull
    public Double getMaxAllowedAmount() {
        return maxAllowedAmount == null ? 0 : maxAllowedAmount;
    }

    @NonNull
    public Double getInstallmentAmount() {
        return installmentAmount == null ? 0 : installmentAmount;
    }

    @NonNull
    public Double getTotalAmount() {
        return totalAmount == null ? 0 : totalAmount;
    }

    @NonNull
    public String getRecommendedMessage() {
        return StringUtil.fixString(recommendedMessage);
    }

    @NonNull
    public ArrayList<String> getLabels() {
        return labels == null ? new ArrayList<String>() : labels;
    }

    @NonNull
    public ArrayList<String> getInstallmentRateCollector() {
        return installmentRateCollector == null ? new ArrayList<String>() : installmentRateCollector;
    }
}
