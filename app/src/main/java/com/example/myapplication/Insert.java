
package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Insert extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);


    }
    public void HideButton(View view){
        Button btnEdit = (Button)findViewById(R.id.edit);
        Button btnDelete = (Button)findViewById(R.id.xoa);
        Button btnSave = (Button)findViewById(R.id.save);

        btnEdit.setVisibility(View.VISIBLE);
        btnDelete.setVisibility(View.VISIBLE);
        btnSave.setVisibility(View.INVISIBLE);
    }

}