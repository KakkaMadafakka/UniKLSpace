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
import android.widget.TextView;

import com.example.phobo.uniklspace.Timetable.AddRecordActivity;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by ash on 10/2/2018.
 */

public class Tab3 extends Fragment {

    TextView timetableadd,day;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v=inflater.inflate(R.layout.tab3, container, false);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            v.setSystemUiVisibility(v.getSystemUiVisibility());
        }

        day = v.findViewById(R.id.tv_day);
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
        Date d = new Date();
        String dayOfTheWeek = sdf.format(d);

        day.setText(dayOfTheWeek);

        if (dayOfTheWeek=="Sunday"){

        }
        timetableadd= v.findViewById(R.id.tv_add_btn);
        timetableadd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent shareIntent = new Intent(getContext(), AddRecordActivity.class);
                startActivity(shareIntent);
            }
        });
        return v;
    }

}
