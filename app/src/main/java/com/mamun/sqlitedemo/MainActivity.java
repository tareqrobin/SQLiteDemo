package com.mamun.sqlitedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    Button btnAdd;
    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.lv);
        btnAdd = findViewById(R.id.btn_activity_main_add_info);

        MyDB db = new MyDB(getApplicationContext());

        adapter = new CustomAdapter(getApplicationContext(),db.getAllData());

        listView.setAdapter(adapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),AddDataActivity.class);
                startActivity(intent);
                finish();
            }
        });



    }
}
