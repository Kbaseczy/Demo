package com.example.p_czyunchen.demo;

import android.app.Activity;
import android.os.Bundle;

public class TODOActivity extends Activity {

    public final String url_list ="";
    public final String url_add = null;
    public final String url_delete = "";
    public final String url_list_todo = "";
    public final String url_list_done = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);
    }
}
