package mx.cetys.aarambula.android.pokemonevtrainingcalc;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import mx.cetys.aarambula.android.pokemonevtrainingcalc.model.ContactInfo;
import mx.cetys.aarambula.android.pokemonevtrainingcalc.model.Pokemon;
import mx.cetys.aarambula.android.pokemonevtrainingcalc.view.PokemonBattleListActivity;
import mx.cetys.aarambula.android.pokemonevtrainingcalc.view.PokemonEVStatsActivity;
import mx.cetys.aarambula.android.pokemonevtrainingcalc.view.PokemonEVTrainingActivity;

public class MainActivity extends AppCompatActivity {

    Button btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        setSupportActionBar(toolbar);

        btnCalculate = (Button) findViewById(R.id.button2);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateEV();
            }
        });


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent oIntent = new Intent(getApplicationContext(), PokemonEVTrainingActivity.class);
                startActivity(oIntent);
            }
        });
    }

    public void calculateEV() {
        Intent oIntent = new Intent(getApplicationContext(), PokemonEVStatsActivity.class);
        startActivity(oIntent);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == 1) {

        }
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
