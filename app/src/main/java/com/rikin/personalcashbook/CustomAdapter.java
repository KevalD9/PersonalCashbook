package com.rikin.personalcashbook;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    private Activity activity;
    private LayoutInflater inflater;
    private ArrayList<DataModel> Items;
    DataModel sm;

    TextView tvID,tvamount,tvDescription;

    public CustomAdapter(Activity activity,ArrayList<DataModel> Items){
        this.activity = activity;
        this.Items = Items;

    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public DataModel getItem(int i) {
        return Items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertview, ViewGroup parent) {
        if(inflater == null){
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if(convertview == null){
           convertview = inflater.inflate(R.layout.row,null);
        }

        tvID = (TextView) convertview.findViewById(R.id.iD);
        tvamount = (TextView) convertview.findViewById(R.id.amount);
        tvDescription = (TextView) convertview.findViewById(R.id.description);

        sm = Items.get(i);
        tvID.setText(sm.getId());
        tvamount.setText(sm.getAmount());
        tvDescription.setText(sm.getDescription());

        return convertview;
    }
}
