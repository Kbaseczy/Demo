package com.example.p_czyunchen.demo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

import com.example.p_czyunchen.demo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HttpActivity extends Activity {

    @BindView(R.id.http_get)
    Button httpGet;
    @BindView(R.id.http_post)
    Button httpPost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http);
        ButterKnife.bind(this);
    }

}
