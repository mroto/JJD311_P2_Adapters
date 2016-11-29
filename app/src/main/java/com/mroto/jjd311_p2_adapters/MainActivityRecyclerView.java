package com.mroto.jjd311_p2_adapters;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivityRecyclerView extends AppCompatActivity {

    private static final String TAG = MainActivityRecyclerView.class.getSimpleName();
    private static final int SIZE = 20;
    private List<Item> listItem = new ArrayList<>();

    private void fillArrayList() {
        Log.e(MainActivityRecyclerView.TAG, "fillArrayList");
        for (int i = 0; i < MainActivityRecyclerView.SIZE; i++) {
            this.listItem.add(new Item("@mipmap/ic_launcher", "title_" + i, "body_" + i));
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.e(MainActivityRecyclerView.TAG, "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_with_recycler_view);

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view_main);
        this.fillArrayList();

        //optimize code:
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        recyclerView.setAdapter(new MyListAdapterRecycler(this, this.listItem));
    }
}
