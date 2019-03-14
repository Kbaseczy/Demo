package com.example.p_czyunchen.demo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.p_czyunchen.demo.R;
import com.example.p_czyunchen.demo.api.RetrofitApi;
import com.example.p_czyunchen.demo.bean.User;
import com.zhy.http.okhttp.cookie.CookieJarImpl;
import com.zhy.http.okhttp.cookie.store.PersistentCookieStore;
import com.zhy.http.okhttp.log.LoggerInterceptor;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.shuyu.gsyvideoplayer.GSYVideoADManager.TAG;

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

    @OnClick(R.id.http_get)
    public void onButterKnifeBtnClick(View view) {
        Log.e(TAG, "onButterKnifeBtnClick");
        login();
    }

    void login() {
        CookieJarImpl cookieJar = new CookieJarImpl(new PersistentCookieStore(getApplicationContext()));
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(15000L, TimeUnit.MILLISECONDS)
                .readTimeout(15000L, TimeUnit.MILLISECONDS)
                .addInterceptor(new LoggerInterceptor("jankin"))
                .cookieJar(cookieJar)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.wanandroid.com")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
        RetrofitApi api = retrofit.create(RetrofitApi.class);
        Call<User> loginCall = api.login("15541125277", "123456");
        loginCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Log.v("sdfasdf",response.body()+"  yhujg");
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }

    void todoList() {
        String url = "http://www.wanandroid.com/lg/todo/v2/list/1/json";

    }
}
