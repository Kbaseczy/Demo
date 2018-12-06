package com.example.p_czyunchen.demo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.p_czyunchen.demo.R;

/*
    RecyclerView.ViewHolder
    RecyclerAdapter.ViewHolder  搞混
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;

    private static final int BANNER = 1;
    private static final int TAB = 2;
    private static final int NEWS = 3;
    private static final int RECYCLER = 4;

    @Override
    public int getItemCount() {
        return 0;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        if (context == null) {
            context = viewGroup.getContext();
        }
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {
            case BANNER:
                View item_banner = LayoutInflater.from(context).inflate(R.layout.item_banner, viewGroup, false);
                viewHolder = new ViewHolder_banner(item_banner);
                break;
            case TAB:
                View item_tab = LayoutInflater.from(context).inflate(R.layout.item_tab, viewGroup, false);
                viewHolder = new ViewHolder_tab(item_tab);
                break;
            case NEWS:
                View item_news = LayoutInflater.from(context).inflate(R.layout.item_news, viewGroup, false);
                viewHolder = new ViewHolder_news(item_news);
                break;
            case RECYCLER:
                View item_recycler = LayoutInflater.from(context).inflate(R.layout.item_recycler, viewGroup, false);
                viewHolder = new ViewHolder_recycler(item_recycler);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof ViewHolder_banner) {

        }
        if (viewHolder instanceof ViewHolder_tab) {

        }
        if (viewHolder instanceof ViewHolder_news) {

        }
        if (viewHolder instanceof ViewHolder_recycler) {

        }

    }

    @Override
    public int getItemViewType(int position) {
        int type = BANNER;
        switch (position) {
            case 1:
                type = BANNER;
                break;
            case 2:
                type = TAB;
                break;
            case 3:
                type = NEWS;
                break;
            case 4:
                type = RECYCLER;
                break;
        }
        return type;
    }

    static class ViewHolder_banner extends RecyclerView.ViewHolder {
        ViewHolder_banner(View view) {
            super(view);
        }
    }

    static class ViewHolder_tab extends RecyclerView.ViewHolder {
        ViewHolder_tab(View view) {
            super(view);
        }
    }

    static class ViewHolder_news extends RecyclerView.ViewHolder {
        ViewHolder_news(View view) {
            super(view);
        }
    }

    static class ViewHolder_recycler extends RecyclerView.ViewHolder {
        ViewHolder_recycler(View view) {
            super(view);
        }
    }
}
