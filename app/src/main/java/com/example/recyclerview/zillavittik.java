package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

public class zillavittik extends AppCompatActivity {

    private List<Integer> list = new ArrayList<Integer>();
    private RecyclerView recyclerView;
    zillaVittikRecyclerAdapter adapter;

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

        recyclerView = findViewById(R.id.recyclerview);

        final String[] districtnames=getResources().getStringArray(R.array.district);

        for(Integer s:districtimage)
        {
            list.add(s);
        }

        adapter = new zillaVittikRecyclerAdapter(list, districtnames);
        recyclerView.setAdapter(adapter);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
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
