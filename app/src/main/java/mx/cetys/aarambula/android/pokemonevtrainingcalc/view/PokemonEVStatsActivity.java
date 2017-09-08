package mx.cetys.aarambula.android.pokemonevtrainingcalc.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
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
    private SeekBar skbIV;
    private EditText edtPkmNo;
    private EditText edtStat;
    private EditText edtLevel;
    private EditText edtNature;
    private TextView txtResult;
    private TextView txtIV;
    private EVStatsFunctions oEVCore = new EVStatsFunctions();
    private Pokemon oPkmToCalc = new Pokemon();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_evstats);

        oDatabase = FirebaseDatabase.getInstance();
        oDatabase.setPersistenceEnabled(true);
        mDatabase = oDatabase.getReference();

        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                lPokemon = new ArrayList<Pokemon>();
                for (DataSnapshot dataPkm : dataSnapshot.getChildren()) {
                    Pokemon pkm = dataPkm.getValue(Pokemon.class);
                    lPokemon.add(pkm);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("test", "loadPost:onCancelled", databaseError.toException());
            }
        };

        mDatabase.addListenerForSingleValueEvent(postListener);

        btnCalculate = (Button) findViewById(R.id.btnSearchPkm);
        skbIV = (SeekBar) findViewById(R.id.seekBarIV);
        edtPkmNo = (EditText) findViewById(R.id.editTextPkmNo);
        edtStat = (EditText) findViewById(R.id.editTextStat);
        edtNature = (EditText) findViewById(R.id.editTextNature);
        edtLevel = (EditText) findViewById(R.id.editTextLevel);
        txtResult = (TextView) findViewById(R.id.textViewResult);
        txtIV = (TextView) findViewById(R.id.textViewIV);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int nPkmNo = Integer.parseInt(edtPkmNo.getText().toString());
                oPkmToCalc = lPokemon.get(nPkmNo - 1);

                txtResult.setText("Stat: " + getSpreadEV(oPkmToCalc.getAtk()));

            }
        });

        skbIV.setMax(31);
        skbIV.setProgress(0);
        txtIV.setText("IV: " + 0 + "/" + skbIV.getMax());

        skbIV.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int nProgress = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser) {
                nProgress = progressValue;
                txtIV.setText("IV: " + nProgress + "/" + seekBar.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                txtIV.setText("IV: " + nProgress + "/" + seekBar.getMax());
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
                if (checked) {
                    txtResult.setText("Atk: " + getSpreadEV(oPkmToCalc.getAtk()));
                }
                break;
            case R.id.radioButtonDEF:
                if (checked) {
                    txtResult.setText("Def: " + getSpreadEV(oPkmToCalc.getDef()));
                }
                break;
            case R.id.radioButtonSPE:
                if (checked) {
                    txtResult.setText("Spe: " + getSpreadEV(oPkmToCalc.getSpd()));
                }
                break;
            case R.id.radioButtonSPD:
                if (checked) {
                    txtResult.setText("SPDef: " + getSpreadEV(oPkmToCalc.getSPDef()));
                }
                break;
            case R.id.radioButtonSPA:
                if (checked) {
                    txtResult.setText("SPAtk: " + getSpreadEV(oPkmToCalc.getSPAtk()));
                }
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

    private long getSpreadEV(int nPkmBaseStat) {
        int nStat = Integer.parseInt(edtStat.getText().toString());
        int nLevel = Integer.parseInt(edtLevel.getText().toString());
        double xNature = Double.parseDouble(edtNature.getText().toString());
         return oEVCore.getEVStat(nPkmBaseStat, skbIV.getProgress(), nStat, nLevel, xNature);
    }
}
