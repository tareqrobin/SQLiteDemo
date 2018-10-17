package com.mamun.sqlitedemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter {

    List<Model> userDataInfo = new ArrayList<Model>();


    public CustomAdapter(@NonNull Context context, List<Model> userDataInfo) {
        super(context, R.layout.custom_layout, userDataInfo);
        this.userDataInfo = userDataInfo;

    }




    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.custom_layout,parent,false);

        TextView tvName = row.findViewById(R.id.name);
        TextView tvAge = row.findViewById(R.id.age);


        tvName.setText(userDataInfo.get(position).getNAME());
        tvAge.setText(userDataInfo.get(position).getAGE());


        return row;
    }


}