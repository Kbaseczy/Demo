package com.example.p_czyunchen.demo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.bumptech.glide.Glide;
import com.example.p_czyunchen.demo.bean.News;
import com.example.p_czyunchen.demo.bean.ProjectChapter;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;
import com.zhy.http.okhttp.utils.L;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Request;

public class ViewFlipperActivity extends Activity {

    String url = "http://wanandroid.com/project/tree/json";
    List<ProjectChapter.DataBean> beanList = new ArrayList<>();
    TextView content_tv;
    ViewFlipper viewFlipper;
    LinearLayout item_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_flipper);
        viewFlipper = findViewById(R.id.flipper);
        ImageView flipper_image = findViewById(R.id.flipper_image);
        Glide.with(this).load(R.drawable.icon_news).into(flipper_image);
        getData();
    }

    private void setData() {
        for (ProjectChapter.DataBean t : beanList) {
            item_view = (LinearLayout) LayoutInflater.from(this).inflate( R.layout.item_viewflipper, null);
            content_tv = item_view.findViewById(R.id.viewflipper_content);
            content_tv.setText(t.getName());
            Log.v("jankin_chapter", t.getName() );
            content_tv.setOnClickListener(v ->
                    Toast.makeText(this, t.getName() + (beanList.indexOf(t) + 1) + "个", Toast.LENGTH_SHORT).show());
            viewFlipper.addView(item_view);
        }
    }

    private void getData() {
        OkHttpUtils
                .get()
                .url(url)
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

                    @Override
                    public void onResponse(String response, int id) {

                        Log.v("flipper ", response);
                        Gson gson = new Gson();
                        beanList = gson.fromJson(response, ProjectChapter.class).getData();
                        setData();
                    }
                });
    }

}
