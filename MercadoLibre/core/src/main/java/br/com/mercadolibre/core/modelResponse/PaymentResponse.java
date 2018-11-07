package br.com.mercadolibre.core.modelResponse;

import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import br.com.mercadolibre.core.util.StringUtil;

public class PaymentResponse {

    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName("payment_type_id")
    private String paymentTypeId;

    @SerializedName("status")
    private String status;

    @SerializedName("secure_thumbnail")
    private String secureThumbnail;

    @SerializedName("thumbnail")
    private String thumbnail;

    @SerializedName("deferred_capture")
    private String deferredCapture;

    @SerializedName("min_allowed_amount")
    private Double minAllowedAmount;

    @SerializedName("max_allowed_amount")
    private Double maxAllowedAmount;

    @SerializedName("accreditation_time")
    private Integer accreditationTime;

    @NonNull
    public String getId() {
        return StringUtil.fixString(id);
    }

    @NonNull
    public String getName() {
        return StringUtil.fixString(name);
    }

    @NonNull
    public String getPaymentTypeId() {
        return StringUtil.fixString(paymentTypeId);
    }

    @NonNull
    public String getStatus() {
        return StringUtil.fixString(status);
    }

    @NonNull
    public String getSecureThumbnail() {
        return StringUtil.fixString(secureThumbnail);
    }

    @NonNull
    public String getThumbnail() {
        return StringUtil.fixString(thumbnail);
    }

    @NonNull
    public String getDeferredCapture() {
        return StringUtil.fixString(deferredCapture);
    }

    public double getMinAllowedAmount() {
        return minAllowedAmount == null ? 0 : minAllowedAmount;
    }

    public double getMaxAllowedAmount() {
        return maxAllowedAmount == null ? 0 : maxAllowedAmount;
    }

    public int getAccreditationTime() {
        return accreditationTime == null ? 0 : accreditationTime;
    }
}
