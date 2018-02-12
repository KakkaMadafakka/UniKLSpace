package com.example.phobo.uniklspace;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by ash on 10/2/2018.
 */

public class Tab5 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v=inflater.inflate(R.layout.tab5, container, false);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            v.setSystemUiVisibility(v.getSystemUiVisibility());
        }
        return v;
    }
}
