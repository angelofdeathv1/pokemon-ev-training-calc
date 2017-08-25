package mx.cetys.aarambula.android.pokemonevtrainingcalc.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mx.cetys.aarambula.android.pokemonevtrainingcalc.R;

public class MenuFragmentActivity extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_menu_fragment,container,false);
    }
}
