package com.mroto.jjd311_p2_adapters;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    private static final int SIZE = 20;

    private ListView listView;
    private String[] arrayString = new String[MainActivity.SIZE];

    private ArrayAdapter<String> arrayAdapter;
    private List<Item> listItem = new ArrayList<>();

    private void fillArrayString() {
        Log.e(MainActivity.TAG, "fillArrayString");
        for (int i = 0; i < MainActivity.SIZE; i++) {
            this.arrayString[i] = "string_" + i;
        }
    }

    private void fillArrayList() {
        Log.e(MainActivity.TAG, "fillArrayList");
        for (int i = 0; i < MainActivity.SIZE; i++) {
            this.listItem.add(new Item("@mipmap/ic_launcher", "title_" + i, "body_" + i));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.listView = (ListView) findViewById(R.id.list_view_main);
        this.listView.setOnItemClickListener(this);
        this.listView.setOnItemLongClickListener(this);

        //Simple Adapter:
        //this.fillArrayString();
        //this.arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayString);
        //this.listView.setAdapter(this.arrayAdapter);

        //Custom Adapter:
        this.fillArrayList();
        this.listView.setAdapter(new MyListAdapter(this, 0, this.listItem));
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        int adapterViewId = adapterView.getId();
        Log.e(MainActivity.TAG, "onItemClick, adapterView.getId()=" + adapterViewId);
        if (adapterViewId == R.id.list_view_main) {
            Toast.makeText(this, "Element " + position + ", with ID=" + id, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {
        int adapterViewId = adapterView.getId();
        Log.e(MainActivity.TAG, "onItemLongClick, adapterView.getId()=" + adapterViewId);
        if (adapterViewId == R.id.list_view_main) {
            Toast.makeText(this, "Long click on element " + position + ", with ID=" + id, Toast.LENGTH_SHORT).show();
            return true;
        } else {
            return false;
        }
    }
}
