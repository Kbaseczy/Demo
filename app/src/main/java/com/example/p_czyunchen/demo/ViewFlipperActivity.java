package com.example.p_czyunchen.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.example.p_czyunchen.demo.bean.News;

import java.util.ArrayList;
import java.util.List;

public class ViewFlipperActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_flipper);

        ViewFlipper viewFlipper  = findViewById(R.id.flipper);
        viewFlipper.addView(View.inflate(this,R.layout.item_viewflipper,null));

        viewFlipper.setOnClickListener(v ->
                Toast.makeText(this, "click viewFlipper.", Toast.LENGTH_SHORT).show());

        TextView content_tv = findViewById(R.id.viewflipper_content);
        List<News> list = new ArrayList<>(); //存储来自网络的数据
        list.add(new News("name1","link"));
        list.add(new News("name2","link"));
        list.add(new News("name3","link"));
        list.add(new News("name4","link"));
        list.add(new News("name5","link"));
        list.add(new News("name6","link"));

        for(News t : list){
            content_tv.setText(t.getName());
            viewFlipper.getCurrentView().setOnClickListener(v ->
                    Toast.makeText(this, "t.getLink() 跳转WebView  当前是第"+(list.indexOf(t)+1)+"个", Toast.LENGTH_SHORT).show());

            if(list.indexOf(t)+1 == list.size()) Toast.makeText(this, "这是最后一个", Toast.LENGTH_SHORT).show();
        }


    }
}
