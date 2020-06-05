package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import org.adblockplus.libadblockplus.android.webview.AdblockWebView;

public class commonweb extends AppCompatActivity {

    private String[] newspaper;
    private AdblockWebView w;
    private ProgressBar progressBar;
    AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        //hello
        setContentView(R.layout.activity_commonweb);

        Bundle b=getIntent().getExtras();

        int x=b.getInt("key1");
        int y=b.getInt("key2");//key1 and key2 is for zillavittik

        int p=0;
        int q=b.getInt("key3");//eng er position
        p=b.getInt("key4");//key3 and key4 is for english
        //for zillavittik p will be still 0
        int r=b.getInt("key5");//international er position

        progressBar = findViewById(R.id.progressBar);
        mAdView = findViewById(R.id.adView);
        w = findViewById(R.id.webviewid);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        w.setWebChromeClient(new MyChrome());
        w.setWebViewClient(new MyClient());

        if(p==0) populating(x, y);

        else if(p==1)
        {
            newspaper=getResources().getStringArray(R.array.Englishnewspaper2);
            w.loadUrl(newspaper[q]);
        }
        else if(p==2)
        {
            newspaper=getResources().getStringArray(R.array.internationalsite);
            w.loadUrl(newspaper[r]);
        }

    }

    public class MyChrome extends WebChromeClient
    {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
            progressBar.setProgress(newProgress);
        }

    }

    public class MyClient extends WebViewClient
    {

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            progressBar.setVisibility(View.GONE);
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            progressBar.setVisibility(View.VISIBLE);
            progressBar.setProgress(0);
        }

    }

    @Override
    public void onBackPressed() {
        if(w.canGoBack())
        {
            w.goBack();
        }
        else {
            super.onBackPressed();
        }
    }

    private void populating(int x, int y) {

        if(y==0)
        {
            newspaper=getResources().getStringArray(R.array.Barishal2);
            w.loadUrl(newspaper[x]);
        }
        else if(y==1)
        {
            newspaper=getResources().getStringArray(R.array.Bhola2);
            w.loadUrl(newspaper[x]);
        }
        else if(y==2)
        {
            newspaper=getResources().getStringArray(R.array.Patuakhali2);
            w.loadUrl(newspaper[x]);
        }
        else if(y==3)
        {
            newspaper=getResources().getStringArray(R.array.Pirojpur2);
            w.loadUrl(newspaper[x]);
        }
        else if(y==4)
        {
            newspaper=getResources().getStringArray(R.array.Brammonbaria2);
            w.loadUrl(newspaper[x]);
        }
        else if(y==5)
        {
            newspaper=getResources().getStringArray(R.array.Chandpur2);
            w.loadUrl(newspaper[x]);
        }
        else if(y==6)
        {
            newspaper=getResources().getStringArray(R.array.Chittagong2);
            w.loadUrl(newspaper[x]);
        }
        else if(y==7)
        {
            newspaper=getResources().getStringArray(R.array.Comilla2);
            w.loadUrl(newspaper[x]);
        }
        else if(y==8)
        {
            newspaper=getResources().getStringArray(R.array.Coxsbazar2);
            w.loadUrl(newspaper[x]);
        }
        else if(y==9)
        {
            newspaper=getResources().getStringArray(R.array.Feni2);
            w.loadUrl(newspaper[x]);
        }
        else if(y==10)
        {
            newspaper=getResources().getStringArray(R.array.Khagrachori2);
            w.loadUrl(newspaper[x]);
        }
        else if(y==11)
        {
            newspaper=getResources().getStringArray(R.array.Lakshmipur2);
            w.loadUrl(newspaper[x]);
        }
        else if(y==12)
        {
            newspaper=getResources().getStringArray(R.array.Noakhali2);
            w.loadUrl(newspaper[x]);
        }
        else if(y==13)
        {
            newspaper=getResources().getStringArray(R.array.Rangamati2);
            w.loadUrl(newspaper[x]);
        }
        else if(y==14)
        {
            newspaper=getResources().getStringArray(R.array.Dhaka2);
            w.loadUrl(newspaper[x]);
        }
        else if(y==15)
        {
            newspaper=getResources().getStringArray(R.array.Faridpur2);
            w.loadUrl(newspaper[x]);
        }
        else if(y==16)
        {
            newspaper=getResources().getStringArray(R.array.Gazipur2);
            w.loadUrl(newspaper[x]);
        }
        else if(y==17)
        {
            newspaper=getResources().getStringArray(R.array.Gopalganj2);
            w.loadUrl(newspaper[x]);
        }
        else if(y==18)
        {
            newspaper=getResources().getStringArray(R.array.Kishorganj2);
            w.loadUrl(newspaper[x]);
        }
        else if(y==19)
        {
            newspaper=getResources().getStringArray(R.array.Madaripur2);
            w.loadUrl(newspaper[x]);
        }
        else if(y==20)
        {
            newspaper=getResources().getStringArray(R.array.Munshiganj2);
            w.loadUrl(newspaper[x]);
        }
        else if(y==21)
        {
            newspaper=getResources().getStringArray(R.array.Naraynganj2);
            w.loadUrl(newspaper[x]);
        }
        else if(y==22)
        {
            newspaper=getResources().getStringArray(R.array.Narsinghdi2);
            w.loadUrl(newspaper[x]);
        }
        else if(y==23)
        {
            newspaper=getResources().getStringArray(R.array.Rajbari2);
            w.loadUrl(newspaper[x]);
        }
        else if(y==24)
        {
            newspaper=getResources().getStringArray(R.array.Shariatpur2);
            w.loadUrl(newspaper[x]);
        }
        else if(y==25)
        {
            newspaper=getResources().getStringArray(R.array.Tangail2);
            w.loadUrl(newspaper[x]);
        }
        else if(y==26)
        {
            newspaper=getResources().getStringArray(R.array.Bagerhat2);
            w.loadUrl(newspaper[x]);
        }
        else if(y==27)
        {
            newspaper=getResources().getStringArray(R.array.Chuadanga2);
            w.loadUrl(newspaper[x]);
        }
        else if(y==28)
        {
            newspaper=getResources().getStringArray(R.array.Jessore2);
            w.loadUrl(newspaper[x]);
        }
        else if(y==29)
        {
            newspaper=getResources().getStringArray(R.array.Jhenaidah2);
            w.loadUrl(newspaper[x]);
        }
        else if(y==30)
        {
            newspaper=getResources().getStringArray(R.array.Khulna2);
            w.loadUrl(newspaper[x]);
        }
        else if(y==31)
        {
            newspaper=getResources().getStringArray(R.array.Kustia2);
            w.loadUrl(newspaper[x]);
        }
        else if(y==32)
        {
            newspaper=getResources().getStringArray(R.array.Magura2);
            w.loadUrl(newspaper[x]);
        }
        else if(y==33)
        {
            newspaper=getResources().getStringArray(R.array.Meherpur2);
            w.loadUrl(newspaper[x]);
        }
        else if(y==34)
        {
            newspaper=getResources().getStringArray(R.array.Narail2);
            w.loadUrl(newspaper[x]);
        }
        else if(y==35)
        {
            newspaper=getResources().getStringArray(R.array.Sathkhira2);
            w.loadUrl(newspaper[x]);
        }
        else if(y==36)
        {
            newspaper=getResources().getStringArray(R.array.Jamalpur2);
            w.loadUrl(newspaper[x]);
        }
        else if(y==37)
        {
            newspaper=getResources().getStringArray(R.array.Mymensingh2);
            w.loadUrl(newspaper[x]);
        }
        else if(y==38)
        {
            newspaper=getResources().getStringArray(R.array.Netrokona2);
            w.loadUrl(newspaper[x]);
        }
        else if(y==39)
        {
            newspaper=getResources().getStringArray(R.array.Sherpur2);
            w.loadUrl(newspaper[x]);
        }
        else if(y==40)
        {
            newspaper=getResources().getStringArray(R.array.Bogura2);
            w.loadUrl(newspaper[x]);
        }
        else if(y==41)
        {
            newspaper=getResources().getStringArray(R.array.Jaypurhat2);
            w.loadUrl(newspaper[x]);
        }
        else if(y==42)
        {
            newspaper=getResources().getStringArray(R.array.Naogaon2);
            w.loadUrl(newspaper[x]);
        }
        else if(y==43)
        {
            newspaper=getResources().getStringArray(R.array.Natore2);
            w.loadUrl(newspaper[x]);
        }
        else if(y==44)
        {
            newspaper=getResources().getStringArray(R.array.Chapainawabganj2);
            w.loadUrl(newspaper[x]);
        }
        else if(y==45)
        {
            newspaper=getResources().getStringArray(R.array.Pabna2);
            w.loadUrl(newspaper[x]);
        }
        else if(y==46)
        {
            newspaper=getResources().getStringArray(R.array.Rajshshi2);
            w.loadUrl(newspaper[x]);
        }
        else if(y==47)
        {
            newspaper=getResources().getStringArray(R.array.Sirajganj2);
            w.loadUrl(newspaper[x]);
        }
        else if(y==48)
        {
            newspaper=getResources().getStringArray(R.array.Dinajpur2);
            w.loadUrl(newspaper[x]);
        }
        else if(y==49)
        {
            newspaper=getResources().getStringArray(R.array.Gaibandha2);
            w.loadUrl(newspaper[x]);
        }
        else if(y==50)
        {
            newspaper=getResources().getStringArray(R.array.Kurigram2);
            w.loadUrl(newspaper[x]);
        }
        else if(y==51)
        {
            newspaper=getResources().getStringArray(R.array.Lalmonirhat2);
            w.loadUrl(newspaper[x]);
        }
        else if(y==52)
        {
            newspaper=getResources().getStringArray(R.array.Nilphamari2);
            w.loadUrl(newspaper[x]);
        }
        else if(y==53)
        {
            newspaper=getResources().getStringArray(R.array.Panchagar2);
            w.loadUrl(newspaper[x]);
        }
        else if(y==54)
        {
            newspaper=getResources().getStringArray(R.array.Rangpur2);
            w.loadUrl(newspaper[x]);
        }
        else if(y==55)
        {
            newspaper=getResources().getStringArray(R.array.Thakurgaon2);
            w.loadUrl(newspaper[x]);
        }
        else if(y==56)
        {
            newspaper=getResources().getStringArray(R.array.Hobiganj2);
            w.loadUrl(newspaper[x]);
        }
        else if(y==57)
        {
            newspaper=getResources().getStringArray(R.array.Moulovibazar2);
            w.loadUrl(newspaper[x]);
        }
        else if(y==58)
        {
            newspaper=getResources().getStringArray(R.array.Sunamganj2);
            w.loadUrl(newspaper[x]);
        }
        else if(y==59)
        {
            newspaper=getResources().getStringArray(R.array.Sylhet2);
            w.loadUrl(newspaper[x]);
        }

    }

}
