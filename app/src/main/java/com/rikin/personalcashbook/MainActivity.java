package com.rikin.personalcashbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public Button but1;
    public Button btnViewData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        but1 = findViewById(R.id.add_data);
        btnViewData = findViewById(R.id.view_data);
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent toy = new Intent(MainActivity.this, add.class);

                startActivity(toy);
            }
        });


        btnViewData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShowAll.class);
                startActivity(intent);


            }
        });
    }
    }

