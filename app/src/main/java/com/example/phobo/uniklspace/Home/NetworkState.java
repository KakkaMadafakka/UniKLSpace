package com.example.phobo.uniklspace.Home;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.example.phobo.uniklspace.Tab1;

/**
 * Created by phobo on 10-Feb-18.
 */

public class NetworkState {


    private static final String TAG = NetworkState.class.getSimpleName();



    public static boolean isInternetAvailable(Context context)
    {
        NetworkInfo info = ((ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();

        if (info == null)
        {
            Log.d(TAG,"no internet connection");
            return false;
        }
        else
        {
            if(info.isConnected())
            {
                Log.d(TAG," internet connection available...");
                return true;
            }
            else
            {
                Log.d(TAG," internet connection");
                return true;
            }

        }
    }


}
