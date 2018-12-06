package com.example.p_czyunchen.demo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

public class GetViewTypeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_view_type);
    }

    private void initView(){
        RecyclerView recyclerView = findViewById(R.id.recycler_view_type);

    }

}
