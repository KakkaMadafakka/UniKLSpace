package com.example.phobo.uniklspace;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import com.example.phobo.uniklspace.Timetable.ListBatchesActivity;

/**
 * Created by ash on 10/2/2018.
 */

public class Tab3 extends Fragment {

    Button timetablecall;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v=inflater.inflate(R.layout.tab3, container, false);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            v.setSystemUiVisibility(v.getSystemUiVisibility());
        }

        timetablecall=(Button)v.findViewById(R.id.btn_beta);
        timetablecall.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent shareIntent = new Intent(getContext(), ListBatchesActivity.class);
                startActivity(shareIntent);
            }
        });

        return v;
    }
}
