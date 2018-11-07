package br.com.mercadolibre.app.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import java.util.ArrayList;

import br.com.mercadolibre.core.util.StringUtil;

public class Installment implements Parcelable {

    private String id;
    private ArrayList<PayerCost> costs;

    public Installment() {
    }

    private Installment(Parcel in) {
        id = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Installment> CREATOR = new Creator<Installment>() {
        @Override
        public Installment createFromParcel(Parcel in) {
            return new Installment(in);
        }

        @Override
        public Installment[] newArray(int size) {
            return new Installment[size];
        }
    };

    @NonNull
    public String getId() {
        return StringUtil.fixString(id);
    }

    public void setId(String id) {
        this.id = id;
    }

    @NonNull
    public ArrayList<PayerCost> getCosts() {
        return costs == null ? new ArrayList<PayerCost>() : costs;
    }

    public void setCosts(ArrayList<PayerCost> costs) {
        this.costs = costs;
    }
}
