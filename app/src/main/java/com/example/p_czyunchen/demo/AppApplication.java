package com.example.p_czyunchen.demo;

import android.app.Application;
import android.content.Context;

import com.example.p_czyunchen.demo.intercepter.AddCookiesInterceptor;
import com.example.p_czyunchen.demo.intercepter.ReceivedCookiesInterceptor;
import com.franmontiel.persistentcookiejar.ClearableCookieJar;
import com.franmontiel.persistentcookiejar.PersistentCookieJar;
import com.franmontiel.persistentcookiejar.cache.SetCookieCache;
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AppApplication extends Application {
    public static Retrofit retrofit;
    Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        initRetrofit();
    }

    void initRetrofit() {
        ClearableCookieJar cookieJar =
                new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(getApplicationContext()));
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(15000L, TimeUnit.MILLISECONDS)
                .readTimeout(15000L, TimeUnit.MILLISECONDS)
//                .addInterceptor(new ReceivedCookiesInterceptor())
//                .addInterceptor(new AddCookiesInterceptor())
                .cookieJar(cookieJar)
                .build();
        retrofit = new Retrofit.Builder()
                .baseUrl("https://www.wanandroid.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
    }

    public static AppApplication getContext() {
        return MyApplicationHolder.MY_APPLICATION;
    }

    private static class MyApplicationHolder {
        private static final AppApplication MY_APPLICATION = new AppApplication();
    }
}
