package com.example.recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class zillanewspaper extends AppCompatActivity {

    private String[] newsname;
    private Myadapter myadapter;
    private RecyclerView recyclerView;
    int[] flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zillanewspaper);
        setTitle("Local Newspaper");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle b=getIntent().getExtras();
        int x=b.getInt("key");

        populating(x);

        recyclerView=(RecyclerView)findViewById(R.id.recyclerviewid);

        myadapter=new Myadapter(this,flag);
        recyclerView.setAdapter(myadapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        myadapter.setOnItemClickListener(new Myadapter.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                Bundle b=getIntent().getExtras();
                int x=b.getInt("key");
                Intent intent2=new Intent(zillanewspaper.this,commonweb.class);
                intent2.putExtra("key1",position);
                intent2.putExtra("key2",x);
                startActivity(intent2);
            }

            @Override
            public void onItemLongClick(int position, View v) {
                Bundle b=getIntent().getExtras();
                int x=b.getInt("key");
                Intent intent2=new Intent(zillanewspaper.this,commonweb.class);
                intent2.putExtra("key1",position);
                intent2.putExtra("key2",x);
                startActivity(intent2);
            }

        });
    }

    private void populating(int x) {
        if(x==0){
            flag= new int[]{R.drawable.barishal1, R.drawable.barishal2, R.drawable.barishal3, R.drawable.barishal4, R.drawable.barishal5, R.drawable.barishal6};
        }
        else if(x==1){
            flag= new int[]{R.drawable.vhola1,R.drawable.vhola2};
        }
        else if(x==2){
            flag= new int[]{R.drawable.potuakhali1};
        }
        else if(x==3){
            flag= new int[]{R.drawable.pirojpur1};
        }
        else if(x==4){
            flag= new int[]{R.drawable.brahmanbaria1,R.drawable.brahmanbaria2};
        }
        else if(x==5){
            flag= new int[]{R.drawable.chandpur1,R.drawable.chandpur2,R.drawable.chandpur3,R.drawable.chandpur4,R.drawable.chandpur5};
        }
        else if(x==6){
            flag= new int[]{R.drawable.chittagong1,R.drawable.chittagong2,R.drawable.chittagong3,R.drawable.chittagong4,R.drawable.chittagong5,R.drawable.chittagong6,R.drawable.chittagong7,R.drawable.chittagong8,R.drawable.chittagong9,R.drawable.chittagong10,R.drawable.chittagong11,R.drawable.chittagong12,R.drawable.chittagong13};
        }
        else if(x==7){
            flag= new int[]{R.drawable.comilla1,R.drawable.comilla2,R.drawable.comilla3,R.drawable.comilla4,R.drawable.comilla5};
        }
        else if(x==8){
            flag= new int[]{R.drawable.coxsbazar1,R.drawable.coxsbazar2,R.drawable.coxsbazar3};
        }
        else if(x==9){
            flag= new int[]{R.drawable.feni1,R.drawable.feni2,R.drawable.feni3};
        }
        else if(x==10){
            flag= new int[]{R.drawable.khagrachari1,R.drawable.khagrachari2,R.drawable.khagrachari3};
        }
        else if(x==11){
            flag= new int[]{R.drawable.lakshmipur1,R.drawable.lakshmipur2,R.drawable.lakshmipur3,R.drawable.lakshmipur4,R.drawable.lakshmipur5,R.drawable.lakshmipur6};
        }
        else if(x==12){
            flag= new int[]{R.drawable.noakhali1,R.drawable.noakhali2,R.drawable.noakhali3,R.drawable.noakhali4};
        }
        else if(x==13){
            flag= new int[]{R.drawable.rangamati1,R.drawable.rangamati2};
        }
        else if(x==14){
            flag= new int[]{R.drawable.dhaka1,R.drawable.dhaka2,R.drawable.dhaka3,R.drawable.dhaka4};
        }
        else if(x==15){
            flag= new int[]{R.drawable.faridpur1,R.drawable.faridpur2};
        }
        else if(x==16){
            flag= new int[]{R.drawable.gazipur1,R.drawable.gazipur2};
        }
        else if(x==17){
            flag= new int[]{R.drawable.gopalganj1};
        }
        else if(x==18){
            flag= new int[]{R.drawable.kishorganj1,R.drawable.kishorganj2};
        }
        else if(x==19){
            flag= new int[]{R.drawable.madaripur1};
        }
        else if(x==20){
            flag= new int[]{R.drawable.munshiganj1,R.drawable.munshiganj2,R.drawable.munshiganj3,R.drawable.munshiganj4};
        }
        else if(x==21){
            flag= new int[]{R.drawable.narayanganj1,R.drawable.narayanganj2,R.drawable.narayanganj3,R.drawable.narayanganj4};
        }
        else if(x==22){
            flag= new int[]{R.drawable.narsingdi1};
        }
        else if(x==23){
            flag= new int[]{R.drawable.rajbari1,R.drawable.rajbari2,R.drawable.rajbari3};
        }
        else if(x==24){
            flag= new int[]{R.drawable.shariatpur1,R.drawable.shariatpur2,R.drawable.shariatpur3};
        }
        else if(x==25){
            flag= new int[]{R.drawable.tangail1,R.drawable.tangail2};
        }
        else if(x==26){
            flag= new int[]{R.drawable.bagerhat1,R.drawable.bagerhat2};
        }
        else if(x==27){
            flag= new int[]{R.drawable.chuadanga1,R.drawable.chuadanga2};
        }
        else if(x==28){
            flag= new int[]{R.drawable.jessore1,R.drawable.jessore2,R.drawable.jessore3,R.drawable.jessore4};
        }
        else if(x==29){
            flag= new int[]{R.drawable.jhenaidah1};
        }
        else if(x==30){
            flag= new int[]{R.drawable.khulna1,R.drawable.khulna2,R.drawable.khulna3,R.drawable.khulna4};
        }
        else if(x==31){
            flag= new int[]{R.drawable.kushtia1,R.drawable.kushtia2,R.drawable.kushtia3,R.drawable.kushtia4};
        }
        else if(x==32){
            flag= new int[]{R.drawable.magura1,R.drawable.magura2,R.drawable.magura3};
        }
        else if(x==33){
            flag= new int[]{R.drawable.meherpur1,R.drawable.meherpur2};
        }
        else if(x==34){
            flag= new int[]{R.drawable.narail1};
        }
        else if(x==35){
            flag= new int[]{R.drawable.satkhira1,R.drawable.satkhira2,R.drawable.satkhira3,R.drawable.satkhira4,R.drawable.satkhira5,R.drawable.satkhira6,R.drawable.satkhira7};
        }
        else if(x==36){
            flag= new int[]{R.drawable.jamalpur1,R.drawable.jamalpur2};
        }
        else if(x==37){
            flag= new int[]{R.drawable.mymensingh1,R.drawable.mymensingh2,R.drawable.mymensingh3,R.drawable.mymensingh4,R.drawable.mymensingh5,R.drawable.mymensingh6,R.drawable.mymensingh7};
        }
        else if(x==38){
            flag= new int[]{R.drawable.netrokona1};
        }
        else if(x==39){
            flag= new int[]{R.drawable.sherpur1,R.drawable.sherpur2,R.drawable.sherpur3,R.drawable.sherpur4,R.drawable.sherpur5};
        }
        else if(x==40){
            flag= new int[]{R.drawable.bogra1,R.drawable.bogra2,R.drawable.bogra3,R.drawable.bogra4,R.drawable.bogra5,R.drawable.bogra6,R.drawable.bogra7,R.drawable.bogra8,R.drawable.bogra9};
        }
        else if(x==41){
            flag= new int[]{R.drawable.joypurhat1};
        }
        else if(x==42){
            flag= new int[]{R.drawable.naogaon1,R.drawable.naogaon2};
        }
        else if(x==43){
            flag= new int[]{R.drawable.natore1,R.drawable.natore2,R.drawable.natore3};
        }
        else if(x==44){
            flag= new int[]{R.drawable.chapainawabganj1};
        }
        else if(x==45){
            flag= new int[]{R.drawable.pabna1,R.drawable.pabna2,R.drawable.pabna3};
        }
        else if(x==46){
            flag= new int[]{R.drawable.rajshahi1,R.drawable.rajshahi2,R.drawable.rajshahi3,R.drawable.rajshahi4,R.drawable.rajshahi5,R.drawable.rajshahi6,R.drawable.rajshahi7,R.drawable.rajshahi8};
        }
        else if(x==47){
            flag= new int[]{R.drawable.sirajganj1,R.drawable.sirajganj2};
        }
        else if(x==48){
            flag= new int[]{R.drawable.dinajpur1,R.drawable.dinajpur2};
        }
        else if(x==49){
            flag= new int[]{R.drawable.gaibandha1};
        }
        else if(x==50){
            flag= new int[]{R.drawable.kurigram1,R.drawable.kurigram2};
        }
        else if(x==51){
            flag= new int[]{R.drawable.lalmonirhat1,R.drawable.lalmonirhat2};
        }
        else if(x==52){
            flag= new int[]{R.drawable.nilphamari1,R.drawable.nilphamari2};
        }
        else if(x==53){
            flag= new int[]{R.drawable.panchagar1,R.drawable.panchagar2};
        }
        else if(x==54){
            flag= new int[]{R.drawable.rangpur1,R.drawable.rangpur2,R.drawable.rangpur3,R.drawable.rangpur4,R.drawable.rangpur5,R.drawable.rangpur6};
        }
        else if(x==55){
            flag= new int[]{R.drawable.thakurgaon1,R.drawable.thakurgaon2};
        }
        else if(x==56){
            flag= new int[]{R.drawable.habiganj1,R.drawable.habiganj2,R.drawable.habiganj3,R.drawable.habiganj4,R.drawable.habiganj5};
        }
        else if(x==57){
            flag= new int[]{R.drawable.moulvibazar1,R.drawable.moulvibazar2};
        }
        else if(x==58){
            flag= new int[]{R.drawable.sunamganj1,R.drawable.sunamganj2,R.drawable.sunamganj3,R.drawable.sunamganj4};
        }
        else if(x==59){
            flag= new int[]{R.drawable.sylhet1,R.drawable.sylhet2,R.drawable.sylhet3,R.drawable.sylhet4,R.drawable.sylhet5,
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
