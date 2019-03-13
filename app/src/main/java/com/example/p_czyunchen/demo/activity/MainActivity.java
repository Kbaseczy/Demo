package com.example.p_czyunchen.demo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.p_czyunchen.demo.R;

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

    public void notication(View view) {
        startActivity(new Intent(this,NotificationActivity.class));
    }

    public void small_video(View view) {
        startActivity(new Intent(this,RecyclerView2Activity.class));
    }

    public void httpClick(View view) {
        startActivity(new Intent(this,HttpActivity.class));
    }
}
