package com.example.recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

public class zillanewspaper extends AppCompatActivity {

    private Myadapter myadapter;
    private RecyclerView recyclerView;
    private int[] flag;
    private String[] papernames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zillanewspaper);
        setTitle("Local Newspapers");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle b=getIntent().getExtras();
        int x=b.getInt("key");

        populating(x);

        recyclerView=(RecyclerView)findViewById(R.id.zillaWiseRecyclerView);

        myadapter=new Myadapter(this, flag, papernames, x);
        recyclerView.setAdapter(myadapter);
        GridLayoutManager layoutManager;

        int orientation = this.getResources().getConfiguration().orientation;

        if(orientation == Configuration.ORIENTATION_PORTRAIT)
        {
            int screenSize = getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK;

            switch(screenSize)
            {
                case Configuration.SCREENLAYOUT_SIZE_SMALL:
                    layoutManager = new GridLayoutManager(this, 1);
                    break;

                case Configuration.SCREENLAYOUT_SIZE_NORMAL:
                    layoutManager = new GridLayoutManager(this, 2);
                    break;

                case Configuration.SCREENLAYOUT_SIZE_LARGE:
                    layoutManager = new GridLayoutManager(this, 3);
                    break;

                case Configuration.SCREENLAYOUT_SIZE_XLARGE:
                    layoutManager = new GridLayoutManager(this, 4);
                    break;

                default:
                    layoutManager = new GridLayoutManager(this, 2);
                    break;
            }

        }

        else
        {
            int screenSize = getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK;

            switch(screenSize)
            {
                case Configuration.SCREENLAYOUT_SIZE_SMALL:
                    layoutManager = new GridLayoutManager(this, 2);
                    break;

                case Configuration.SCREENLAYOUT_SIZE_NORMAL:
                    layoutManager = new GridLayoutManager(this, 4);
                    break;

                case Configuration.SCREENLAYOUT_SIZE_LARGE:
                    layoutManager = new GridLayoutManager(this, 6);
                    break;

                case Configuration.SCREENLAYOUT_SIZE_XLARGE:
                    layoutManager = new GridLayoutManager(this, 7);
                    break;

                default:
                    layoutManager = new GridLayoutManager(this, 3);
                    break;
            }

        }


        recyclerView.setLayoutManager(layoutManager);

    }

    private void populating(int x) {
        if(x==0){
            flag = new int[]{R.drawable.barishal1, R.drawable.barishal2, R.drawable.barishal3, R.drawable.barishal4, R.drawable.barishal5, R.drawable.barishal6};
            papernames = getResources().getStringArray(R.array.Barishal1);
        }
        else if(x==1){
            flag = new int[]{R.drawable.vhola1,R.drawable.vhola2};
            papernames = getResources().getStringArray(R.array.Bhola1);
        }
        else if(x==2){
            flag = new int[]{R.drawable.potuakhali1};
            papernames = getResources().getStringArray(R.array.Patuakhali1);
        }
        else if(x==3){
            flag = new int[]{R.drawable.pirojpur1};
            papernames = getResources().getStringArray(R.array.Pirojpur1);
        }
        else if(x==4){
            flag = new int[]{R.drawable.brahmanbaria1,R.drawable.brahmanbaria2};
            papernames = getResources().getStringArray(R.array.Brammonbaria1);
        }
        else if(x==5){
            flag = new int[]{R.drawable.chandpur1,R.drawable.chandpur2,R.drawable.chandpur3,R.drawable.chandpur4,R.drawable.chandpur5};
            papernames = getResources().getStringArray(R.array.Chandpur1);
        }
        else if(x==6){
            flag = new int[]{R.drawable.chittagong1,R.drawable.chittagong2,R.drawable.chittagong3,R.drawable.chittagong4,R.drawable.chittagong5,R.drawable.chittagong6,R.drawable.chittagong7,R.drawable.chittagong8,R.drawable.chittagong9,R.drawable.chittagong10,R.drawable.chittagong11,R.drawable.chittagong12,R.drawable.chittagong13};
            papernames = getResources().getStringArray(R.array.Chittagong1);
        }
        else if(x==7){
            flag = new int[]{R.drawable.comilla1,R.drawable.comilla2,R.drawable.comilla3,R.drawable.comilla4,R.drawable.comilla5};
            papernames = getResources().getStringArray(R.array.Comilla1);
        }
        else if(x==8){
            flag = new int[]{R.drawable.coxsbazar1,R.drawable.coxsbazar2,R.drawable.coxsbazar3};
            papernames = getResources().getStringArray(R.array.Coxsbazar1);
        }
        else if(x==9){
            flag = new int[]{R.drawable.feni1,R.drawable.feni2,R.drawable.feni3};
            papernames = getResources().getStringArray(R.array.Feni1);
        }
        else if(x==10){
            flag = new int[]{R.drawable.khagrachari1,R.drawable.khagrachari2,R.drawable.khagrachari3};
            papernames = getResources().getStringArray(R.array.Khagrachori1);
        }
        else if(x==11){
            flag = new int[]{R.drawable.lakshmipur1,R.drawable.lakshmipur2,R.drawable.lakshmipur3,R.drawable.lakshmipur4,R.drawable.lakshmipur5,R.drawable.lakshmipur6};
            papernames = getResources().getStringArray(R.array.Lakshmipur1);
        }
        else if(x==12){
            flag = new int[]{R.drawable.noakhali1,R.drawable.noakhali2,R.drawable.noakhali3,R.drawable.noakhali4};
            papernames = getResources().getStringArray(R.array.Noakhali1);
        }
        else if(x==13){
            flag = new int[]{R.drawable.rangamati1,R.drawable.rangamati2};
            papernames = getResources().getStringArray(R.array.Rangamati1);
        }
        else if(x==14){
            flag = new int[]{R.drawable.dhaka1,R.drawable.dhaka2,R.drawable.dhaka3,R.drawable.dhaka4};
            papernames = getResources().getStringArray(R.array.Dhaka1);
        }
        else if(x==15){
            flag = new int[]{R.drawable.faridpur1,R.drawable.faridpur2};
            papernames = getResources().getStringArray(R.array.Faridpur1);
        }
        else if(x==16){
            flag = new int[]{R.drawable.gazipur1,R.drawable.gazipur2};
            papernames = getResources().getStringArray(R.array.Gazipur1);
        }
        else if(x==17){
            flag = new int[]{R.drawable.gopalganj1};
            papernames = getResources().getStringArray(R.array.Gopalganj1);
        }
        else if(x==18){
            flag = new int[]{R.drawable.kishorganj1,R.drawable.kishorganj2};
            papernames = getResources().getStringArray(R.array.Kishorganj1);
        }
        else if(x==19){
            flag = new int[]{R.drawable.madaripur1};
            papernames = getResources().getStringArray(R.array.Madaripur1);
        }
        else if(x==20){
            flag = new int[]{R.drawable.munshiganj1,R.drawable.munshiganj2,R.drawable.munshiganj3,R.drawable.munshiganj4};
            papernames = getResources().getStringArray(R.array.Munshiganj1);
        }
        else if(x==21){
            flag = new int[]{R.drawable.narayanganj1,R.drawable.narayanganj2,R.drawable.narayanganj3,R.drawable.narayanganj4};
            papernames = getResources().getStringArray(R.array.Naraynganj1);
        }
        else if(x==22){
            flag = new int[]{R.drawable.narsingdi1};
            papernames = getResources().getStringArray(R.array.Narsinghdi1);
        }
        else if(x==23){
            flag = new int[]{R.drawable.rajbari1,R.drawable.rajbari2,R.drawable.rajbari3};
            papernames = getResources().getStringArray(R.array.Rajbari1);
        }
        else if(x==24){
            flag = new int[]{R.drawable.shariatpur1,R.drawable.shariatpur2,R.drawable.shariatpur3};
            papernames = getResources().getStringArray(R.array.Shariatpur1);
        }
        else if(x==25){
            flag = new int[]{R.drawable.tangail1,R.drawable.tangail2};
            papernames = getResources().getStringArray(R.array.Tangail1);
        }
        else if(x==26){
            flag = new int[]{R.drawable.bagerhat1,R.drawable.bagerhat2};
            papernames = getResources().getStringArray(R.array.Bagerhat1);
        }
        else if(x==27){
            flag = new int[]{R.drawable.chuadanga1,R.drawable.chuadanga2};
            papernames = getResources().getStringArray(R.array.Chuadanga1);
        }
        else if(x==28){
            flag = new int[]{R.drawable.jessore1,R.drawable.jessore2,R.drawable.jessore3,R.drawable.jessore4};
            papernames = getResources().getStringArray(R.array.Jessore1);
        }
        else if(x==29){
            flag = new int[]{R.drawable.jhenaidah1};
            papernames = getResources().getStringArray(R.array.Jhenaidah1);
        }
        else if(x==30){
            papernames = getResources().getStringArray(R.array.Khulna1);
            flag = new int[]{R.drawable.khulna1,R.drawable.khulna2,R.drawable.khulna3,R.drawable.khulna4};
        }
        else if(x==31){
            papernames = getResources().getStringArray(R.array.Kustia1);
            flag = new int[]{R.drawable.kushtia1,R.drawable.kushtia2,R.drawable.kushtia3,R.drawable.kushtia4};
        }
        else if(x==32){
            papernames = getResources().getStringArray(R.array.Magura1);
            flag = new int[]{R.drawable.magura1,R.drawable.magura2,R.drawable.magura3};
        }
        else if(x==33){
            papernames = getResources().getStringArray(R.array.Meherpur1);
            flag = new int[]{R.drawable.meherpur1,R.drawable.meherpur2};
        }
        else if(x==34){
            papernames = getResources().getStringArray(R.array.Narail1);
            flag = new int[]{R.drawable.narail1};
        }
        else if(x==35){
            papernames = getResources().getStringArray(R.array.Sathkhira1);
            flag = new int[]{R.drawable.satkhira1,R.drawable.satkhira2,R.drawable.satkhira3,R.drawable.satkhira4,R.drawable.satkhira5,R.drawable.satkhira6,R.drawable.satkhira7};
        }
        else if(x==36){
            papernames = getResources().getStringArray(R.array.Jamalpur1);
            flag = new int[]{R.drawable.jamalpur1,R.drawable.jamalpur2};
        }
        else if(x==37){
            papernames = getResources().getStringArray(R.array.Mymensingh1);
            flag = new int[]{R.drawable.mymensingh1,R.drawable.mymensingh2,R.drawable.mymensingh3,R.drawable.mymensingh4,R.drawable.mymensingh5,R.drawable.mymensingh6,R.drawable.mymensingh7};
        }
        else if(x==38){
            papernames = getResources().getStringArray(R.array.Netrokona1);
            flag = new int[]{R.drawable.netrokona1};
        }
        else if(x==39){
            papernames = getResources().getStringArray(R.array.Sherpur1);
            flag = new int[]{R.drawable.sherpur1,R.drawable.sherpur2,R.drawable.sherpur3,R.drawable.sherpur4,R.drawable.sherpur5};
        }
        else if(x==40){
            papernames = getResources().getStringArray(R.array.Bogura1);
            flag = new int[]{R.drawable.bogra1,R.drawable.bogra2,R.drawable.bogra3,R.drawable.bogra4,R.drawable.bogra5,R.drawable.bogra6,R.drawable.bogra7,R.drawable.bogra8,R.drawable.bogra9};
        }
        else if(x==41){
            papernames = getResources().getStringArray(R.array.Jaypurhat1);
            flag = new int[]{R.drawable.joypurhat1};
        }
        else if(x==42){
            papernames = getResources().getStringArray(R.array.Naogaon1);
            flag = new int[]{R.drawable.naogaon1,R.drawable.naogaon2};
        }
        else if(x==43){
            papernames = getResources().getStringArray(R.array.Natore1);
            flag = new int[]{R.drawable.natore1,R.drawable.natore2,R.drawable.natore3};
        }
        else if(x==44){
            papernames = getResources().getStringArray(R.array.Chapainawabganj1);
            flag = new int[]{R.drawable.chapainawabganj1};
        }
        else if(x==45){
            papernames = getResources().getStringArray(R.array.Pabna1);
            flag = new int[]{R.drawable.pabna1,R.drawable.pabna2,R.drawable.pabna3};
        }
        else if(x==46){
            papernames = getResources().getStringArray(R.array.Rajshshi1);
            flag = new int[]{R.drawable.rajshahi1,R.drawable.rajshahi2,R.drawable.rajshahi3,R.drawable.rajshahi4,R.drawable.rajshahi5,R.drawable.rajshahi6,R.drawable.rajshahi7,R.drawable.rajshahi8};
        }
        else if(x==47){
            papernames = getResources().getStringArray(R.array.Sirajganj1);
            flag = new int[]{R.drawable.sirajganj1,R.drawable.sirajganj2};
        }
        else if(x==48){
            papernames = getResources().getStringArray(R.array.Dinajpur1);
            flag = new int[]{R.drawable.dinajpur1,R.drawable.dinajpur2};
        }
        else if(x==49){
            papernames = getResources().getStringArray(R.array.Gaibandha1);
            flag = new int[]{R.drawable.gaibandha1};
        }
        else if(x==50){
            papernames = getResources().getStringArray(R.array.Kurigram1);
            flag = new int[]{R.drawable.kurigram1,R.drawable.kurigram2};
        }
        else if(x==51){
            papernames = getResources().getStringArray(R.array.Lalmonirhat1);
            flag = new int[]{R.drawable.lalmonirhat1,R.drawable.lalmonirhat2};
        }
        else if(x==52){
            papernames = getResources().getStringArray(R.array.Nilphamari1);
            flag = new int[]{R.drawable.nilphamari1,R.drawable.nilphamari2};
        }
        else if(x==53){
            papernames = getResources().getStringArray(R.array.Panchagar1);
            flag = new int[]{R.drawable.panchagar1,R.drawable.panchagar2};
        }
        else if(x==54){
            papernames = getResources().getStringArray(R.array.Rangpur1);
            flag = new int[]{R.drawable.rangpur1,R.drawable.rangpur2,R.drawable.rangpur3,R.drawable.rangpur4,R.drawable.rangpur5,R.drawable.rangpur6};
        }
        else if(x==55){
            papernames = getResources().getStringArray(R.array.Thakurgaon1);
            flag = new int[]{R.drawable.thakurgaon1,R.drawable.thakurgaon2};
        }
        else if(x==56){
            papernames = getResources().getStringArray(R.array.Hobiganj1);
            flag = new int[]{R.drawable.habiganj1,R.drawable.habiganj2,R.drawable.habiganj3,R.drawable.habiganj4,R.drawable.habiganj5};
        }
        else if(x==57){
            papernames = getResources().getStringArray(R.array.Moulovibazar1);
            flag = new int[]{R.drawable.moulvibazar1,R.drawable.moulvibazar2};
        }
        else if(x==58){
            papernames = getResources().getStringArray(R.array.Sunamganj1);
            flag = new int[]{R.drawable.sunamganj1,R.drawable.sunamganj2,R.drawable.sunamganj3,R.drawable.sunamganj4};
        }
        else if(x==59){
            papernames = getResources().getStringArray(R.array.Sylhet1);
            flag = new int[]{R.drawable.sylhet1,R.drawable.sylhet2,R.drawable.sylhet3,R.drawable.sylhet4,R.drawable.sylhet5,
                    R.drawable.sylhet6,R.drawable.sylhet7,R.drawable.sylhet8,R.drawable.sylhet9,R.drawable.sylhet10,
                    R.drawable.sylhet11,R.drawable.sylhet12,R.drawable.sylhet13,R.drawable.sylhet14,R.drawable.sylhet15,
                    R.drawable.sylhet16,R.drawable.sylhet17,R.drawable.sylhet18,R.drawable.sylhet19,R.drawable.sylhet20,
                    R.drawable.sylhet21,R.drawable.sylhet22,R.drawable.sylhet23,R.drawable.sylhet24,R.drawable.sylhet25,R.drawable.sylhet26};
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home)
        {
            this.finish();
            return true;
        }
        else
        {
            return false;
        }
    }
}
