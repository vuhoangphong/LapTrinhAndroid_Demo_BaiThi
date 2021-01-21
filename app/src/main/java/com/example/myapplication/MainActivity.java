package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //khởi tạo menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return true;
    }

    //chức năng item trong menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        if (item.getItemId() == R.id.Insert) {
            //sử dụng startActivityForResult để lấy kết quả từ Insert trả về, requestCode từ Main -> Insert là 1
            final int result = 1;
            startActivityForResult(new Intent(this, Insert.class), result);

            /*
             * //hoặc viết theo cách sau:
             *  Intent intent = new Intent(this,InsertActivity.class);
             * startActivityForResult(intent, result);
             *
             * */
        }
        return true;
    }

}