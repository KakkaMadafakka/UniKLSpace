package com.example.phobo.uniklspace;

import android.app.DownloadManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.phobo.uniklspace.Home.NetworkState;

import static android.content.Context.DOWNLOAD_SERVICE;

/**
 * Created by ash on 10/2/2018.
 */

public class Tab2 extends Fragment {

    WebView mWebView;
    TextView texttab2;
    ImageView Splashfuck;

    //Overriden method onCreateView
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v2=inflater.inflate(R.layout.tab2, container, false);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            v2.setSystemUiVisibility(v2.getSystemUiVisibility() | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            v2.setSystemUiVisibility(v2.getSystemUiVisibility() | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

        if(NetworkState.isInternetAvailable(getActivity())) //returns true if internet available
        {
            mWebView = v2.findViewById(R.id.uniklvle);
            Splashfuck = v2.findViewById(R.id.splashlogo);


            // Fucking settings for the webview
            WebSettings webSettings = mWebView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            mWebView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
            webSettings.setUseWideViewPort(true);
            webSettings.setSavePassword(true);
            webSettings.setEnableSmoothTransition(true);
            webSettings.setJavaScriptEnabled(true);
            mWebView.getSettings().setLoadsImagesAutomatically(true);
            webSettings.getLoadsImagesAutomatically();
            mWebView.getSettings().setAppCacheEnabled(true);
            mWebView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
            mWebView.setWebViewClient(new WebViewClient());
            mWebView.getSettings().setBuiltInZoomControls(false);
            mWebView.getSettings().setDisplayZoomControls(false);

            mWebView.setWebViewClient(new WebViewClient() {

                @Override
                public void onPageFinished(WebView view, String url) {
                    super.onPageFinished(view, url);
                    Splashfuck.setVisibility(View.GONE);
                    mWebView.setVisibility(View.VISIBLE);
                }
            });
            mWebView.loadUrl("https://vle.unikl.edu.my/login/index.php");
            mWebView.setVisibility(View.GONE);
            Splashfuck.setVisibility(View.VISIBLE);
        }
        else
        {
            texttab2 = v2.findViewById(R.id.tvtab2);
            texttab2.setVisibility(View.VISIBLE);

        }

        /*mWebView.setDownloadListener(new DownloadListener() {

            @Override
            public void onDownloadStart(String url, String userAgent,
                                        String contentDisposition, String mimetype,
                                        long contentLength) {
                DownloadManager.Request request = new DownloadManager.Request(
                        Uri.parse(url));

                request.allowScanningByMediaScanner();
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED); //Notify client once download is completed!
                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "UniKL");
                DownloadManager dm = (DownloadManager) getContext().getSystemService(DOWNLOAD_SERVICE);
                dm.enqueue(request);
                Toast.makeText(getContext(), "UniKL is downloading your request", //To notify the Client that the file is being downloaded
                        Toast.LENGTH_LONG).show();

            }
        });*/
        return v2;
    }
}