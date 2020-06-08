package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.ads.MobileAds;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView zillaVittik, jatiyo, english, international, khela, chakri, sikkha, binodon,
            liveTv, liveRadio, islamicRadio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Home");

        MobileAds.initialize(this, "ca-app-pub-7076860777204313~2986517262");

        viewSettings();

    }

    private void viewSettings() {
        zillaVittik=(ImageView)findViewById(R.id.zilaVittik);
        jatiyo=(ImageView)findViewById(R.id.jatiyo);
        english=(ImageView)findViewById(R.id.english);
        international=(ImageView)findViewById(R.id.international);
        khela=(ImageView)findViewById(R.id.khela);
        chakri=(ImageView)findViewById(R.id.chakri);
        sikkha=(ImageView)findViewById(R.id.sikkha);
        binodon=(ImageView)findViewById(R.id.binodon);
        liveTv=(ImageView)findViewById(R.id.liveTv);
        liveRadio=(ImageView)findViewById(R.id.liveRadio);
        islamicRadio=(ImageView)findViewById(R.id.islamic);

        zillaVittik.setOnClickListener(this);
        jatiyo.setOnClickListener(this);
        english.setOnClickListener(this);
        international.setOnClickListener(this);
        khela.setOnClickListener(this);
        chakri.setOnClickListener(this);
        sikkha.setOnClickListener(this);
        binodon.setOnClickListener(this);
        liveTv.setOnClickListener(this);
        liveRadio.setOnClickListener(this);
        islamicRadio.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        if(!isInternetAvailable())
        {
            Toast.makeText(getApplicationContext(), "Please check your internet connection", Toast.LENGTH_SHORT).show();
            return;
        }

        else
        {
            switch(v.getId())
            {

                case R.id.zilaVittik: {
                    Intent intent = new Intent(MainActivity.this, zillavittik.class);
                    startActivity(intent);
                    break;
                }

                case R.id.jatiyo:
                {
                    Intent intent = new Intent(MainActivity.this, jatiyo.class);
                    startActivity(intent);
                    break;
                }

                case R.id.english:
                {
                    Intent intent = new Intent(MainActivity.this, english.class);
                    startActivity(intent);
                    break;
                }

                case R.id.international:
                {
                    Intent intent = new Intent(MainActivity.this, international.class);
                    startActivity(intent);
                    break;
                }

                case R.id.khela:
                {
                    Intent intent = new Intent(MainActivity.this, khela.class);
                    startActivity(intent);
                    break;
                }

                case R.id.chakri:
                {
                    Intent intent = new Intent(MainActivity.this, chakri.class);
                    startActivity(intent);
                    break;
                }

                case R.id.sikkha:
                {
                    Intent intent = new Intent(MainActivity.this, sikkha.class);
                    startActivity(intent);
                    break;
                }
                case R.id.binodon:
                {
                    Intent intent = new Intent(MainActivity.this, binodon.class);
                    startActivity(intent);
                    break;
                }

                case R.id.liveTv:
                {
                    Intent intent = new Intent(MainActivity.this, livetv.class);
                    startActivity(intent);
                    break;
                }
                case R.id.liveRadio:
                {
                    Intent intent = new Intent(MainActivity.this, liveradio.class);
                    startActivity(intent);
                    break;
                }
                case R.id.islamic:
                {
                    Intent intent = new Intent(MainActivity.this, islamic.class);
                    startActivity(intent);
                    break;
                }
            }
        }

    }

    public boolean isInternetAvailable() {
        ConnectivityManager cm =
                (ConnectivityManager)getApplicationContext().getSystemService(getApplicationContext().CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();

        boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();

        return isConnected;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_menu, menu);

        MenuItem menuItem1 = menu.findItem(R.id.exit);
        MenuItem menuItem2 = menu.findItem(R.id.feedback);

        menuItem1.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                finish();
                return true;
            }
        });

        menuItem2.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent intent = new Intent(getApplicationContext(), feedback.class);
                startActivity(intent);
                return true;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

}
