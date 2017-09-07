package mx.cetys.aarambula.android.pokemonevtrainingcalc.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Pokemon implements Parcelable {

    private int No;
    private String Name;
    private int HP;
    private int Atk;
    private int Def;
    private int SPAtk;
    private int SPDef;
    private int Spd;
    private int Tot;
    private int EV_HP;
    private int EV_Atk;
    private int EV_Def;
    private int EV_SPAtk;
    private int EV_SPDef;
    private int EV_Spd;
    public final static Parcelable.Creator<Pokemon> CREATOR = new Creator<Pokemon>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Pokemon createFromParcel(Parcel in) {
            Pokemon instance = new Pokemon();
            instance.No = in.readInt();
            instance.Name = in.readString();
            instance.HP = in.readInt();
            instance.Atk = in.readInt();
            instance.Def = in.readInt();
            instance.SPAtk = in.readInt();
            instance.SPDef = in.readInt();
            instance.Spd = in.readInt();
            instance.Tot = in.readInt();
            instance.EV_HP = in.readInt();
            instance.EV_Atk = in.readInt();
            instance.EV_Def = in.readInt();
            instance.EV_SPAtk = in.readInt();
            instance.EV_SPDef = in.readInt();
            instance.EV_Spd = in.readInt();
            return instance;
        }

        public Pokemon[] newArray(int size) {
            return (new Pokemon[size]);
        }

    };

    /**
     * No args constructor for use in serialization
     */
    public Pokemon() {
    }

    public Pokemon(int no, String name, int HP, int atk, int def, int SPAtk, int SPDef, int spd, int tot, int EV_HP, int EV_Atk, int EV_Def, int EV_SPAtk, int EV_SPDef, int EV_Spd) {
        this.No = no;
        this.Name = name;
        this.HP = HP;
        this.Atk = atk;
        this.Def = def;
        this.SPAtk = SPAtk;
        this.SPDef = SPDef;
        this.Spd = spd;
        this.Tot = tot;
        this.EV_HP = EV_HP;
        this.EV_Atk = EV_Atk;
        this.EV_Def = EV_Def;
        this.EV_SPAtk = EV_SPAtk;
        this.EV_SPDef = EV_SPDef;
        this.EV_Spd = EV_Spd;
    }

    public int getNo() {
        return No;
    }

    public void setNo(int no) {
        No = no;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getAtk() {
        return Atk;
    }

    public void setAtk(int atk) {
        Atk = atk;
    }

    public int getDef() {
        return Def;
    }

    public void setDef(int def) {
        Def = def;
    }

    public int getSPAtk() {
        return SPAtk;
    }

    public void setSPAtk(int SPAtk) {
        this.SPAtk = SPAtk;
    }

    public int getSPDef() {
        return SPDef;
    }

    public void setSPDef(int SPDef) {
        this.SPDef = SPDef;
    }

    public int getSpd() {
        return Spd;
    }

    public void setSpd(int spd) {
        Spd = spd;
    }

    public int getTot() {
        return Tot;
    }

    public void setTot(int tot) {
        Tot = tot;
    }

    public int getEV_HP() {
        return EV_HP;
    }

    public void setEV_HP(int EV_HP) {
        this.EV_HP = EV_HP;
    }

    public int getEV_Atk() {
        return EV_Atk;
    }

    public void setEV_Atk(int EV_Atk) {
        this.EV_Atk = EV_Atk;
    }

    public int getEV_Def() {
        return EV_Def;
    }

    public void setEV_Def(int EV_Def) {
        this.EV_Def = EV_Def;
    }

    public int getEV_SPAtk() {
        return EV_SPAtk;
    }

    public void setEV_SPAtk(int EV_SPAtk) {
        this.EV_SPAtk = EV_SPAtk;
    }

    public int getEV_SPDef() {
        return EV_SPDef;
    }

    public void setEV_SPDef(int EV_SPDef) {
        this.EV_SPDef = EV_SPDef;
    }

    public int getEV_Spd() {
        return EV_Spd;
    }

    public void setEV_Spd(int EV_Spd) {
        this.EV_Spd = EV_Spd;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(No);
        dest.writeValue(Name);
        dest.writeValue(HP);
        dest.writeValue(Atk);
        dest.writeValue(Def);
        dest.writeValue(SPAtk);
        dest.writeValue(SPDef);
        dest.writeValue(Spd);
        dest.writeValue(Tot);
        dest.writeValue(EV_HP);
        dest.writeValue(EV_Atk);
        dest.writeValue(EV_Def);
        dest.writeValue(EV_SPAtk);
        dest.writeValue(EV_SPDef);
        dest.writeValue(EV_Spd);
    }

    public int describeContents() {
        return 0;
    }

}