package com.example.p_czyunchen.demo.api;

import com.example.p_czyunchen.demo.bean.TodoTodo;
import com.example.p_czyunchen.demo.bean.User;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RetrofitApi {
    @POST("user/login")
    Call<User> login(@Query("username") String username,
                     @Query("password") String password);

    @GET("lg/todo/v2/list/")
    Call<TodoTodo> getTodoList();

}
