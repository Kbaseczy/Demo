package com.example.p_czyunchen.demo;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.p_czyunchen.demo.adapter.AnimatorAdapter;

import java.util.ArrayList;
import java.util.List;

public class RemoveAddActivity extends AppCompatActivity {
    AnimatorAdapter adapter;
    List<String> mDatas = new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_add);
        initView();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void initView() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        RecyclerView recyclerView = findViewById(R.id.recycler_animator);
        GridLayoutManager manager = new GridLayoutManager(this, 4);
        adapter = new AnimatorAdapter(this);
        getData();
        adapter.setmDatas(mDatas);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_addremove, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add:
                adapter.add(1);
                break;
            case R.id.action_remove:
                adapter.remove(1);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    void getData() {
        for (int i = 0; i < 50; i++) {
            mDatas.add(i, "");
        }
    }
}
