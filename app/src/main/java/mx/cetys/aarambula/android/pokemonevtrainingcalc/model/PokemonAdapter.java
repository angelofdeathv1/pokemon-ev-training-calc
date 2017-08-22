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

public class PokemonAdapter extends ArrayAdapter<PokemonBattle> {
    public PokemonAdapter(Context context) {
        super(context, R.layout.pokemonbattles_row, R.id.txtId);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vista = super.getView(position, convertView, parent);
        TextView aux = null;
        PokemonBattle dato = this.getItem(position);

        aux = (TextView) vista.findViewById(R.id.txtId);
        aux.setText(dato.getsLabel());
        aux = null;

        aux = (TextView) vista.findViewById(R.id.txtNombre);
        aux.setText(dato.getnPokemon());
        aux = null;

        dato = null;

        return vista;
    }
}
