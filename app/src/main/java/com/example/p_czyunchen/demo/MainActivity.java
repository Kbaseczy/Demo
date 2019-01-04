package com.example.p_czyunchen.demo;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //viewFlipper
        findViewById(R.id.viewflipper).setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, ViewFlipperActivity.class)));

        //recyclerView -> getViewType
        findViewById(R.id.getViewType).setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, GetViewTypeActivity.class)));

        //TODO
        findViewById(R.id.TODO).setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, TODOActivity.class)));

        findViewById(R.id.Galary).setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, GalaryActivity.class)));

        findViewById(R.id.remove_add).setOnClickListener(v ->
                startActivity(new Intent(this, RemoveAddActivity.class)));


    }
}
