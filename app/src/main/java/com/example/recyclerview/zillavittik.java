package com.example.recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

public class zillavittik extends AppCompatActivity {

    private RecyclerView recyclerView;
    zillaVittikRecyclerAdapter adapter;
    private List<Pair<String, Integer>> is = new ArrayList<>();

    final int[] districtimage = {R.drawable.barisal, R.drawable.bhola, R.drawable.patuakhali, R.drawable.pirojpur, R.drawable.brahmanbaria, R.drawable.chandpur,
            R.drawable.chitagong, R.drawable.comilla, R.drawable.coxs_bazar, R.drawable.feni, R.drawable.khagrachari, R.drawable.lakshmipur,
            R.drawable.noakhali, R.drawable.rangamati, R.drawable.dhaka, R.drawable.faridpur, R.drawable.gazipur, R.drawable.gopalganj,
            R.drawable.kishoreganj, R.drawable.madaripur, R.drawable.munshiganj, R.drawable.narayanganj, R.drawable.narsingdi, R.drawable.rajbari,
            R.drawable.shariatpur, R.drawable.tangail, R.drawable.bagerhat, R.drawable.chuadanga, R.drawable.jessore, R.drawable.jhenaidah, R.drawable.khulna,
            R.drawable.kushtia, R.drawable.magura, R.drawable.meherpur, R.drawable.narail, R.drawable.sathkhira, R.drawable.jamalpur, R.drawable.mymensingh,
            R.drawable.netrokona, R.drawable.sherpur, R.drawable.bogura, R.drawable.joypurhat, R.drawable.naogaon, R.drawable.natore, R.drawable.chapainawabganj,
            R.drawable.pabna, R.drawable.rajshahi, R.drawable.sirajganj, R.drawable.dinajpur, R.drawable.gaibandha, R.drawable.kurigram, R.drawable.lalmonirhat,
            R.drawable.nilfamari, R.drawable.panchagarh, R.drawable.rangpur, R.drawable.thakurgaon, R.drawable.hobiganj, R.drawable.moulvibazar, R.drawable.sunamganj,
            R.drawable.sylhet};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zillavittik);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.recyclerview);

        final String[] districtnames=getResources().getStringArray(R.array.district);

        int length = districtnames.length;

        for(int i=0; i<length; i++)
        {
            is.add(new Pair(districtnames[i], districtimage[i]));
        }

        adapter = new zillaVittikRecyclerAdapter(is,districtnames);
        recyclerView.setAdapter(adapter);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return false;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        MenuItem menuItem = menu.findItem(R.id.searchview);
        SearchView searchView = (SearchView) menuItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                adapter.filter(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.filter(newText);
                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

}
