package mx.cetys.aarambula.android.pokemonevtrainingcalc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

import mx.cetys.aarambula.android.pokemonevtrainingcalc.model.PokemonAdapter;
import mx.cetys.aarambula.android.pokemonevtrainingcalc.model.PokemonBattle;

public class PokemonBattleList extends AppCompatActivity {
    PokemonAdapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_battle_list);
        adaptador = new PokemonAdapter(this);
    }

    private void llenarListadoUsuarios(ArrayList<PokemonBattle> valorArregloUsuarios) {
        PokemonBattle user = null;
        adaptador.clear();

        for (int i = 0; i < valorArregloUsuarios.size(); i++) {
            user = valorArregloUsuarios.get(i);
            adaptador.add(user);
        }

        adaptador.notifyDataSetChanged();
    }
}
