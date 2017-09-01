package mx.cetys.aarambula.android.pokemonevtrainingcalc.view;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.List;

import mx.cetys.aarambula.android.pokemonevtrainingcalc.MainActivity;
import mx.cetys.aarambula.android.pokemonevtrainingcalc.R;
import mx.cetys.aarambula.android.pokemonevtrainingcalc.controller.EVSpreadFunctions;
import mx.cetys.aarambula.android.pokemonevtrainingcalc.controller.PokemonAdapter;
import mx.cetys.aarambula.android.pokemonevtrainingcalc.model.PokemonBattleRow;

public class PokemonBattleListActivity extends AppCompatActivity {
    EVSpreadFunctions oEVSpreadFunctions = new EVSpreadFunctions();
    PokemonAdapter oPokemonAdapter;
    ListView oListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_battle_list);
        oListView = (ListView) findViewById(R.id.lv_battleList);
        oPokemonAdapter = new PokemonAdapter(this);
        oListView.setAdapter(oPokemonAdapter);

        Bundle b = this.getIntent().getExtras();
        int nTargetEV = b.getInt(MainActivity.EXTRA_TARGET_EV, 0);
        //int nBaseEV = b.getInt(MainActivity.EXTRA_BASE_EV, 0);
        int nVitamins = b.getInt(MainActivity.EXTRA_VITAMINS, 0);
        boolean[] arrOptionsItem = b.getBooleanArray(MainActivity.EXTRA_ITEM_OPTIONS);
        boolean[] arrOptionsEV = b.getBooleanArray(MainActivity.EXTRA_EV_OPTIONS);

        if (oEVSpreadFunctions.validateEVOptions(nTargetEV, arrOptionsEV[0], arrOptionsEV[1], arrOptionsEV[2], nVitamins, arrOptionsItem[0], arrOptionsItem[1], arrOptionsItem[2])) {
            fillPokemonList(oEVSpreadFunctions.calculatePokemonToDefeat(nTargetEV, nVitamins));
        } else {
            DialogFragment newFragment = new CalculateEVDialogFragment();
            newFragment.show(getSupportFragmentManager(), "missiles");
        }

    }

    private void fillPokemonList(List<PokemonBattleRow> lPokemonBattles) {
        oPokemonAdapter.clear();

        for (int i = 0; i < lPokemonBattles.size(); i++) {
            PokemonBattleRow oPokemonBattle = lPokemonBattles.get(i);
            oPokemonAdapter.add(oPokemonBattle);
        }

        oPokemonAdapter.notifyDataSetChanged();
    }
}
