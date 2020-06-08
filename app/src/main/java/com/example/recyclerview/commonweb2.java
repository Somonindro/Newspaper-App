package com.example.recyclerview;

import androidx.annotation.NonNull;
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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.adblockplus.libadblockplus.android.webview.AdblockWebView;

import java.util.List;

public class commonweb2 extends AppCompatActivity {

    private String[] newspaper = new String[20];
    private WebView w;
    private ProgressBar progressBar;
    private AdView mAdView;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("links");
    private int i=0;

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

    private void populating(final int x, int y) {

        if(y == 66)
        {
            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                    {
                        newspaper[i++]= (String) dataSnapshot1.getValue();
                    }
                    w.loadUrl(newspaper[x]);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
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