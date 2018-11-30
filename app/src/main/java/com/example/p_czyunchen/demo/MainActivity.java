package com.example.p_czyunchen.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //viewFlipper
        findViewById(R.id.viewflipper).setOnClickListener(v->
                startActivity(new Intent(MainActivity.this,ViewFlipperActivity.class)));

    }
}
