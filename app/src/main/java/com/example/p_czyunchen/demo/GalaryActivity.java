package com.example.p_czyunchen.demo;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
<<<<<<< HEAD
=======
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.ContextMenu;
>>>>>>> a78d473b36823d3c74025451503c729d974a0714
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.example.p_czyunchen.demo.adapter.GalaryAdapter;
import com.example.p_czyunchen.demo.bean.Beauty;
import com.example.p_czyunchen.demo.custom.MyRecyclerView;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import okhttp3.Call;
import okhttp3.Request;

public class GalaryActivity extends AppCompatActivity {

    List<Integer> list;
    private GalaryAdapter adapter;
    private List<Beauty.ResultsBean> resultsBeans;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galary);
//        getDatas();
        initData();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void initView() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        MyRecyclerView recyclerView = findViewById(R.id.my_recycler);
        ImageView imageView = findViewById(R.id.image_galary);
        imageView.setOnClickListener(v -> fullScreen());
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        adapter = new GalaryAdapter(this, list);
        adapter.setResultsBeans(resultsBeans);
        adapter.setItemClick((view, i) ->
                Glide.with(this)
                        .load(resultsBeans.get(i).getUrl())
                        .transition(new DrawableTransitionOptions().crossFade())
                        .into(imageView));
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(manager);

        recyclerView.setOnItemScrollChangeListener((view, i) ->
                Glide.with(this)
                        .load(resultsBeans.get(i).getUrl())
                        .transition(new DrawableTransitionOptions().transition(R.anim.go_in))
                        .into(imageView));

        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void fullScreen() {
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
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

    private void initData() {

        OkHttpUtils
                .post()
                .url("http://gank.io/api/data/" + "福利" + "/" + 20 + "/" + 1)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onBefore(Request request, int id) {
                        super.onBefore(request, id);
                    }

                    @RequiresApi(api = Build.VERSION_CODES.M)
                    @Override
                    public void onResponse(String response, int id) {
                        Gson gson = new Gson();
                        resultsBeans = gson.fromJson(response, Beauty.class).getResults();
                        initView();
                    }
                });
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
                //上下文菜单
                adapter.add(0);
                adapter.notifyDataSetChanged();
                break;
            case R.id.action_remove:
                if(resultsBeans.size() > 1) {
                    adapter.remove(0);
                    adapter.notifyDataSetChanged();
                }else{
                    Toast.makeText(this, "数据长度不足", Toast.LENGTH_SHORT).show();
                }
                break;
            case android.R.id.home:
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
