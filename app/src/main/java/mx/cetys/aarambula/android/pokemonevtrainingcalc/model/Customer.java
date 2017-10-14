package mx.cetys.aarambula.android.pokemonevtrainingcalc.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by AngelArambula on 9/22/17.
 */

public class Customer implements Parcelable {

    private String name;
    private int operations;
    private int turn;

    public int getTurn() {
        return turn;
    }

    public String getTurnStringValue() {
        return String.valueOf(turn);
    }

    public String getOperationsStringValue() {
        return String.valueOf(operations);
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOperations() {
        return operations;
    }

    public void setOperations(int operations) {
        this.operations = operations;
    }

    public Customer() {

    }

    public Customer(String name, int operations, int turn) {
        this.name = name;
        this.operations = operations;
        this.turn = turn;
    }

    private Customer(Parcel in) {
        this.name = in.readString();
        this.operations = in.readInt();
        this.turn = in.readInt();
    }

    public static final Creator<Customer> CREATOR = new Creator<Customer>() {
        @Override
        public Customer createFromParcel(Parcel in) {
            return new Customer(in);
        }

        @Override
        public Customer[] newArray(int size) {
            return new Customer[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeInt(operations);
        parcel.writeInt(turn);
    }
}
