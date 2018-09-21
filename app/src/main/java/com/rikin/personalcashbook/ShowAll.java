package com.rikin.personalcashbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ShowAll extends AppCompatActivity {

    ListView lvShow;
    CustomAdapter customAdapter;
    ArrayList<DataModel> arrayList;
    DatabaseHelper mDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all);
        lvShow =  (ListView) findViewById(R.id.lvShow);
        mDatabaseHelper = new DatabaseHelper(this);

        arrayList = new ArrayList<>();
        arrayList = mDatabaseHelper.getAllData();
        customAdapter = new CustomAdapter(this,arrayList);
        lvShow.setAdapter(customAdapter);
    }
}
