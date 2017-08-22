package mx.cetys.aarambula.android.pokemonevtrainingcalc.model;

/**
 * Created by AngelArambula on 8/21/17.
 */

public class PokemonBattle {
    private String sLabel;
    private int nPokemon;

    public void setnPokemon(int nPokemon) {
        this.nPokemon = nPokemon;
    }

    public void setsLabel(String sLabel) {
        this.sLabel = sLabel;
    }

    public int getnPokemon() {
        return nPokemon;
    }

    public String getsLabel() {
        return sLabel;
    }
}
