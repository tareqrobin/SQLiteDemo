package com.mamun.sqlitedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddDataActivity extends AppCompatActivity {

    EditText etName, etAge;
    Button btnSave;

    MyDB db ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);
        etName = findViewById(R.id.et_activity_add_data_name);
        etAge = findViewById(R.id.et_activity_add_data_age);
        btnSave = findViewById(R.id.btn_activity_add_data_save);

        db = new MyDB(getApplicationContext());

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name =  etName.getText().toString();
                String age = etAge.getText().toString();

                db.insertData(name,age);

                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
