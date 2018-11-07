package br.com.mercadolibre.core.modelResponse;

import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import br.com.mercadolibre.core.util.StringUtil;

public class BankResponse {

    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName("secure_thumbnail")
    private String secureThumbnail;

    @SerializedName("thumbnail")
    private String thumbnail;

    @SerializedName("processing_mode")
    private String processingMode;

    @SerializedName("merchant_account_id")
    private String merchantAccountId;

    @NonNull
    public String getId() {
        return StringUtil.fixString(id);
    }

    @NonNull
    public String getName() {
        return StringUtil.fixString(name);
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
    public String getProcessingMode() {
        return StringUtil.fixString(processingMode);
    }

    @NonNull
    public String getMerchantAccountId() {
        return StringUtil.fixString(merchantAccountId);
    }
}
