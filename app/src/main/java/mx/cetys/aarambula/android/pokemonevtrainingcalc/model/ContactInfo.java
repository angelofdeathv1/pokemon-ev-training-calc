package mx.cetys.aarambula.android.pokemonevtrainingcalc.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by aarambula on 9/1/2017.
 */

public class ContactInfo implements Parcelable {

    private String name;
    private String surname;
    private int idx;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }


    public ContactInfo(){

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(surname);
        dest.writeInt(idx);
    }

    // Creator
    public static final Parcelable.Creator CREATOR
            = new Parcelable.Creator() {
        public ContactInfo createFromParcel(Parcel in) {
            return new ContactInfo(in);
        }

        public ContactInfo[] newArray(int size) {
            return new ContactInfo[size];
        }
    };

    // "De-parcel object
    public ContactInfo(Parcel in) {
        name = in.readString();
        surname = in.readString();
        idx = in.readInt();
    }
}
