package com.rikin.personalcashbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class add extends AppCompatActivity {

    private static final String TAG = "add";

    private Button btn_ok;
     EditText editText3;
     EditText editText5;
    DatabaseHelper mDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        mDatabaseHelper = new DatabaseHelper(this);

        btn_ok = (Button) findViewById(R.id.btn_ok);
        editText3 = (EditText) findViewById(R.id.editText3);
        editText5 = (EditText) findViewById(R.id.editText5);

//        btn_ok.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String amt = editText3.getText().toString();
//                String name = editText5.getText().toString();
//                if (amt.length() != 0 && name.length() != 0) {
//                    AddData2(amt);
//                    AddData1(name);
//                    editText3.setText("");
//                } else {
//                    toastMessage("You must put something in the text field!");
//                }
//
//            }
//        });

        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amount = editText3.getText().toString();
                String description = editText5.getText().toString();
                if(amount.isEmpty() && description.isEmpty())
                {
                    toastMessage("Please enter some data!");
                    editText3.setText("");
                    editText5.setText("");
                }
                else{
                    mDatabaseHelper.insertDatax(amount, description);
                    toastMessage("Data successfully added!");
                    editText3.setText("");
                    editText5.setText("");
                }
            }
        });


    }
        private void toastMessage(String message){
            Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
        }
//
//    public void AddData1(String name) {
//        mDatabaseHelper = new DatabaseHelper(add.this);
//        boolean insertData = mDatabaseHelper.addData1(name);
//
//        if (insertData) {
//            toastMessage("Data Successfully Inserted!");
//        } else {
//            toastMessage("Something went wrong");
//        }
//    }
//
//
//    public void AddData2(String amt) {
//        mDatabaseHelper = new DatabaseHelper(add.this);
//        boolean insertData1 = mDatabaseHelper.addData2(amt);
//
//        if (insertData1) {
//            toastMessage("Data Successfully Inserted!");
//        } else {
//            toastMessage("Something went wrong");
//        }
//    }
}
