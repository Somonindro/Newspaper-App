package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import org.adblockplus.libadblockplus.android.webview.AdblockWebView;

public class commonweb2 extends AppCompatActivity {

    private String[] newspaper;
    private WebView w;
    private ProgressBar progressBar;
    AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commonweb2);

        Bundle b=getIntent().getExtras();

        int x=b.getInt("key1");
        int y=b.getInt("key2");

        Toast.makeText(this,"Please wait...",Toast.LENGTH_LONG).show();


        progressBar = findViewById(R.id.progressBar2);
        mAdView = findViewById(R.id.adView2);
        w = findViewById(R.id.webviewid2);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        WebSettings webSettings = w.getSettings();
        webSettings.setJavaScriptEnabled(true);
        w.setWebViewClient(new WebViewClient());

        populating(x, y);

    }

    @Override
    public void onBackPressed() {
        w.loadUrl("about:blank");
        if(w.canGoBack())
        {
            w.goBack();
        }
        else {
            super.onBackPressed();
        }
    }

    private void populating(int x, int y) {
        if(y == 66)
        {
            newspaper = getResources().getStringArray(R.array.tvchannel2);
            w.loadUrl(newspaper[x]);
        }
        else if(y == 67){
            newspaper = getResources().getStringArray(R.array.radio2);
            w.loadUrl(newspaper[x]);
        }
        else
        {
            newspaper = getResources().getStringArray(R.array.islamicradio2);
            w.loadUrl(newspaper[x]);
        }
    }

}