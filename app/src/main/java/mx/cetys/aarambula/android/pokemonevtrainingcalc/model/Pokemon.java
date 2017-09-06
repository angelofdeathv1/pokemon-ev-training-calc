package mx.cetys.aarambula.android.pokemonevtrainingcalc.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Pokemon implements Parcelable {

    private Integer no;
    private String name;
    private Integer hP;
    private Integer atk;
    private Integer def;
    private Integer sPAtk;
    private Integer sPDef;
    private Integer spd;
    private Integer tot;
    private Integer eVHP;
    private Integer eVAtk;
    private Integer eVDef;
    private Integer eVSPAtk;
    private Integer eVSPDef;
    private Integer eVSpd;
    public final static Parcelable.Creator<Pokemon> CREATOR = new Creator<Pokemon>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Pokemon createFromParcel(Parcel in) {
            Pokemon instance = new Pokemon();
            instance.no = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            instance.hP = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.atk = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.def = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.sPAtk = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.sPDef = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.spd = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.tot = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.eVHP = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.eVAtk = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.eVDef = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.eVSPAtk = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.eVSPDef = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.eVSpd = ((Integer) in.readValue((Integer.class.getClassLoader())));
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

    /**
     * @param eVSpd
     * @param eVSPDef
     * @param no
     * @param eVAtk
     * @param atk
     * @param tot
     * @param def
     * @param eVDef
     * @param name
     * @param sPDef
     * @param eVSPAtk
     * @param spd
     * @param sPAtk
     * @param eVHP
     * @param hP
     */
    public Pokemon(Integer no, String name, Integer hP, Integer atk, Integer def, Integer sPAtk, Integer sPDef, Integer spd, Integer tot, Integer eVHP, Integer eVAtk, Integer eVDef, Integer eVSPAtk, Integer eVSPDef, Integer eVSpd) {
        super();
        this.no = no;
        this.name = name;
        this.hP = hP;
        this.atk = atk;
        this.def = def;
        this.sPAtk = sPAtk;
        this.sPDef = sPDef;
        this.spd = spd;
        this.tot = tot;
        this.eVHP = eVHP;
        this.eVAtk = eVAtk;
        this.eVDef = eVDef;
        this.eVSPAtk = eVSPAtk;
        this.eVSPDef = eVSPDef;
        this.eVSpd = eVSpd;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHP() {
        return hP;
    }

    public void setHP(Integer hP) {
        this.hP = hP;
    }

    public Integer getAtk() {
        return atk;
    }

    public void setAtk(Integer atk) {
        this.atk = atk;
    }

    public Integer getDef() {
        return def;
    }

    public void setDef(Integer def) {
        this.def = def;
    }

    public Integer getSPAtk() {
        return sPAtk;
    }

    public void setSPAtk(Integer sPAtk) {
        this.sPAtk = sPAtk;
    }

    public Integer getSPDef() {
        return sPDef;
    }

    public void setSPDef(Integer sPDef) {
        this.sPDef = sPDef;
    }

    public Integer getSpd() {
        return spd;
    }

    public void setSpd(Integer spd) {
        this.spd = spd;
    }

    public Integer getTot() {
        return tot;
    }

    public void setTot(Integer tot) {
        this.tot = tot;
    }

    public Integer getEVHP() {
        return eVHP;
    }

    public void setEVHP(Integer eVHP) {
        this.eVHP = eVHP;
    }

    public Integer getEVAtk() {
        return eVAtk;
    }

    public void setEVAtk(Integer eVAtk) {
        this.eVAtk = eVAtk;
    }

    public Integer getEVDef() {
        return eVDef;
    }

    public void setEVDef(Integer eVDef) {
        this.eVDef = eVDef;
    }

    public Integer getEVSPAtk() {
        return eVSPAtk;
    }

    public void setEVSPAtk(Integer eVSPAtk) {
        this.eVSPAtk = eVSPAtk;
    }

    public Integer getEVSPDef() {
        return eVSPDef;
    }

    public void setEVSPDef(Integer eVSPDef) {
        this.eVSPDef = eVSPDef;
    }

    public Integer getEVSpd() {
        return eVSpd;
    }

    public void setEVSpd(Integer eVSpd) {
        this.eVSpd = eVSpd;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(no);
        dest.writeValue(name);
        dest.writeValue(hP);
        dest.writeValue(atk);
        dest.writeValue(def);
        dest.writeValue(sPAtk);
        dest.writeValue(sPDef);
        dest.writeValue(spd);
        dest.writeValue(tot);
        dest.writeValue(eVHP);
        dest.writeValue(eVAtk);
        dest.writeValue(eVDef);
        dest.writeValue(eVSPAtk);
        dest.writeValue(eVSPDef);
        dest.writeValue(eVSpd);
    }

    public int describeContents() {
        return 0;
    }

}