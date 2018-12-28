package com.example.p_czyunchen.demo;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.example.p_czyunchen.demo.adapter.GalaryAdapter;
import com.example.p_czyunchen.demo.custom.MyRecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GalaryActivity extends Activity {

    List<Integer> list;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galary);
        getDatas();

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void initView() {
        MyRecyclerView recyclerView = findViewById(R.id.my_recycler);
        ImageView imageView = findViewById(R.id.image_galary);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        GalaryAdapter adapter = new GalaryAdapter(this, list);
        adapter.setItemClick((view, i) ->
                Glide.with(this)
                        .load(list.get(i))
                        .transition(new DrawableTransitionOptions()
                                .crossFade()).into(imageView)
        );
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(manager);
        recyclerView.setOnItemScrollChangeListener((view, i) ->
                Glide.with(this)
                        .load(list.get(i))
                        .transition(new DrawableTransitionOptions().transition(R.anim.go_in)
                                ).into(imageView)
        );
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void getDatas() {
        list = new ArrayList<>(Arrays.asList(
                R.drawable.i,
                R.drawable.b,
                R.drawable.c,
                R.drawable.d,
                R.drawable.e,
                R.drawable.i,
                R.drawable.o,
                R.drawable.t,
                R.drawable.y));
        initView();
    }
}
