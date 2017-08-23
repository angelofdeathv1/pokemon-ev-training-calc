package mx.cetys.aarambula.android.pokemonevtrainingcalc.model;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import mx.cetys.aarambula.android.pokemonevtrainingcalc.R;

/**
 * Created by AngelArambula on 8/21/17.
 */

public class PokemonAdapter extends ArrayAdapter<PokemonBattleRow> {
    public PokemonAdapter(Context context) {
        super(context, R.layout.pokemonbattles_row, R.id.txtId);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View oView = super.getView(position, convertView, parent);
        TextView txtDescription;
        TextView txtPokemonBattles;

        PokemonBattleRow oPokemonRow = this.getItem(position);
        //EVElementsTable oEVElement=oPokemonRow.getoEVElement();

        txtDescription = (TextView) oView.findViewById(R.id.txtId);
        txtDescription.setText(oPokemonRow.getsLabel());

        txtPokemonBattles = (TextView) oView.findViewById(R.id.txtNombre);
        txtPokemonBattles.setText(oPokemonRow.getnPokemon()+"");

        return oView;
    }
}
