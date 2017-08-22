package mx.cetys.aarambula.android.pokemonevtrainingcalc;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.List;

import mx.cetys.aarambula.android.pokemonevtrainingcalc.controller.CoreFunctions;
import mx.cetys.aarambula.android.pokemonevtrainingcalc.model.PokemonAdapter;
import mx.cetys.aarambula.android.pokemonevtrainingcalc.model.PokemonBattle;

public class MainActivity extends AppCompatActivity {
    CoreFunctions oCoreFunctions = new CoreFunctions();
    PokemonAdapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        adaptador = new PokemonAdapter(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                llenarListadoUsuarios(oCoreFunctions.calculatePokemonToDefeat(100, 1, 0, true, true, true, true));
                Snackbar.make(view, "", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });
    }

    private void llenarListadoUsuarios(List<PokemonBattle> valorArregloUsuarios) {
        adaptador.clear();

        for (int i = 0; i < valorArregloUsuarios.size(); i++) {
            PokemonBattle user = valorArregloUsuarios.get(i);
            adaptador.add(user);
        }

        adaptador.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
