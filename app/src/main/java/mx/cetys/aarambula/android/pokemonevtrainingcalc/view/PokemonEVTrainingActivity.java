package mx.cetys.aarambula.android.pokemonevtrainingcalc.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import mx.cetys.aarambula.android.pokemonevtrainingcalc.R;

public class PokemonEVTrainingActivity extends AppCompatActivity {
    public static final String EXTRA_TARGET_EV = "TARGET_EV";
    public static final String EXTRA_BASE_EV = "BASE_EV";
    public static final String EXTRA_VITAMINS = "VITAMINS";
    public static final String EXTRA_ITEM_OPTIONS = "OPTIONS";
    public static final String EXTRA_EV_OPTIONS = "EV_OPTIONS";
    private TextView txtTargetEV;
    private TextView txtBaseEV;
    private CheckBox chkPokerus;
    private CheckBox chkSOS;
    private CheckBox chkPowerItem;
    private CheckBox chkEV1;
    private CheckBox chkEV2;
    private CheckBox chkEV3;
    private Button btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_evtraining);

        txtTargetEV = (TextView) findViewById(R.id.editTextTargetEV);
        txtBaseEV = (TextView) findViewById(R.id.editTextBaseEV);
        chkPokerus = (CheckBox) findViewById(R.id.checkBoxPokerus);
        chkSOS = (CheckBox) findViewById(R.id.checkBoxSOS);
        chkPowerItem = (CheckBox) findViewById(R.id.checkBoxPowerItem);
        chkEV1 = (CheckBox) findViewById(R.id.checkBoxEV1);
        chkEV2 = (CheckBox) findViewById(R.id.checkBoxEV2);
        chkEV3 = (CheckBox) findViewById(R.id.checkBoxEV3);
        btnCalculate = (Button) findViewById(R.id.buttonCalculateEV);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateEV();
            }
        });
    }

    public void calculateEV() {
        boolean[] arrOptionsItem = {chkPokerus.isChecked(), chkSOS.isChecked(), chkPowerItem.isChecked(), true};
        boolean[] arrOptionsEV = {chkEV1.isChecked(), chkEV2.isChecked(), chkEV3.isChecked(), true};

        Intent oIntent = new Intent(getApplicationContext(), PokemonBattleListActivity.class);
        Bundle oBundle = new Bundle();
        oBundle.putInt(EXTRA_TARGET_EV, Integer.parseInt(txtTargetEV.getText().toString()));
        //oBundle.putInt(EXTRA_BASE_EV, Integer.parseInt(txtBaseEV.getText().toString()));
        oBundle.putInt(EXTRA_VITAMINS, 0);
        oBundle.putBooleanArray(EXTRA_ITEM_OPTIONS, arrOptionsItem);
        oBundle.putBooleanArray(EXTRA_EV_OPTIONS, arrOptionsEV);
        oIntent.putExtras(oBundle);
        startActivity(oIntent);
    }
}
