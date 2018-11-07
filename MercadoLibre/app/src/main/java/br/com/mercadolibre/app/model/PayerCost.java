package br.com.mercadolibre.app.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import br.com.mercadolibre.core.util.StringUtil;

public class PayerCost implements Parcelable {

    private String recommendedMessage;

    public PayerCost() {
    }

    private PayerCost(Parcel in) {
        recommendedMessage = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(recommendedMessage);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<PayerCost> CREATOR = new Creator<PayerCost>() {
        @Override
        public PayerCost createFromParcel(Parcel in) {
            return new PayerCost(in);
        }

        @Override
        public PayerCost[] newArray(int size) {
            return new PayerCost[size];
        }
    };

    @NonNull
    public String getRecommendedMessage() {
        return StringUtil.fixString(recommendedMessage);
    }

    public void setRecommendedMessage(String recommendedMessage) {
        this.recommendedMessage = recommendedMessage;
    }
}
