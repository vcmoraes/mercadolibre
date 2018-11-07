package br.com.mercadolibre.app.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import br.com.mercadolibre.core.util.StringUtil;

public class Bank implements Parcelable {

    private String id;
    private String name;
    private String image;

    public Bank() {
    }

    protected Bank(Parcel in) {
        id = in.readString();
        name = in.readString();
        image = in.readString();
    }

    public static final Creator<Bank> CREATOR = new Creator<Bank>() {
        @Override
        public Bank createFromParcel(Parcel in) {
            return new Bank(in);
        }

        @Override
        public Bank[] newArray(int size) {
            return new Bank[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
        dest.writeString(image);
    }

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
