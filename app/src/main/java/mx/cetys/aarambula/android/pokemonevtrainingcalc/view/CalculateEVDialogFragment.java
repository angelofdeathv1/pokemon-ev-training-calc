package mx.cetys.aarambula.android.pokemonevtrainingcalc.view;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

import mx.cetys.aarambula.android.pokemonevtrainingcalc.R;

/**
 * Created by aarambula on 8/31/2017.
 */

public class CalculateEVDialogFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Warning")
                .setMessage(R.string.txtDialogCalculate)
                .setNegativeButton(R.string.txtOptionYesCalculate, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        return;
                    }
                });
        return builder.create();
    }
}
