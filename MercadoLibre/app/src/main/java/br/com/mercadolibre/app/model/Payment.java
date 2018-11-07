package br.com.mercadolibre.app.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import br.com.mercadolibre.core.util.StringUtil;

public class Payment implements Parcelable {

    private String id;
    private String name;
    private String image;

    public Payment() {
    }

    protected Payment(Parcel in) {
        id = in.readString();
        name = in.readString();
        image = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
        dest.writeString(image);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Payment> CREATOR = new Creator<Payment>() {
        @Override
        public Payment createFromParcel(Parcel in) {
            return new Payment(in);
        }

        @Override
        public Payment[] newArray(int size) {
            return new Payment[size];
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
    public String getName() {
        return StringUtil.fixString(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    @NonNull
    public String getImage() {
        return StringUtil.fixString(image);
    }

    public void setImage(String image) {
        this.image = image;
    }
}
