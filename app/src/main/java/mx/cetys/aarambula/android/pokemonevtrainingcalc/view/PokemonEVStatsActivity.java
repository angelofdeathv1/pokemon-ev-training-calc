package mx.cetys.aarambula.android.pokemonevtrainingcalc.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import mx.cetys.aarambula.android.pokemonevtrainingcalc.R;
import mx.cetys.aarambula.android.pokemonevtrainingcalc.controller.EVStatsFunctions;
import mx.cetys.aarambula.android.pokemonevtrainingcalc.model.Pokemon;

public class PokemonEVStatsActivity extends AppCompatActivity {
    private DatabaseReference mDatabase;
    private FirebaseDatabase oDatabase;
    private ArrayList<Pokemon> lPokemon;
    private Button btnCalculate;
    private EditText edtPkmNo;
    private EditText edtStat;
    private TextView txtResult;
    private EVStatsFunctions oEVCore = new EVStatsFunctions();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_evstats);

        oDatabase = FirebaseDatabase.getInstance();
        // oDatabase.setPersistenceEnabled(true);
        mDatabase = oDatabase.getReference();


        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                lPokemon = new ArrayList<Pokemon>();
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    lPokemon.add(postSnapshot.getValue(Pokemon.class));
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w("test", "loadPost:onCancelled", databaseError.toException());
            }
        };

        mDatabase.addListenerForSingleValueEvent(postListener);

        edtPkmNo = (EditText) findViewById(R.id.editTextPkmNo);
        edtStat = (EditText) findViewById(R.id.editTextStat);
        txtResult = (TextView) findViewById(R.id.textViewResult);
        btnCalculate = (Button) findViewById(R.id.btnSearchPkm);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int nPkmNo = Integer.parseInt(edtPkmNo.getText().toString());
                int nEV = Integer.parseInt(edtStat.getText().toString());
                Pokemon oPkm = lPokemon.get(nPkmNo - 1);

                txtResult.setText(oEVCore.calculateEVStat(oPkm.getEVSPAtk(), 31, nEV, 50, 1) + "");

            }
        });

    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioButtonHP:
                if (checked)

                    break;
            case R.id.radioButtonATK:
                if (checked)

                    break;
            case R.id.radioButtonDEF:
                if (checked)

                    break;
            case R.id.radioButtonSPE:
                if (checked)

                    break;
            case R.id.radioButtonSPD:
                if (checked)

                    break;
            case R.id.radioButtonSPA:
                if (checked)

                    break;
        }
    }

    private ValueEventListener getPokemonValueListener() {
        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                lPokemon = new ArrayList<Pokemon>();
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    lPokemon.add(postSnapshot.getValue(Pokemon.class));
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w("test", "loadPost:onCancelled", databaseError.toException());
            }
        };
        return postListener;
    }
}
