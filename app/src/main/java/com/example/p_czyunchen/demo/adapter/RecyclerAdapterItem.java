package com.example.p_czyunchen.demo.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.p_czyunchen.demo.R;

public class RecyclerAdapterItem extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recycler_card,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if(viewHolder instanceof ViewHolder){
            ((ViewHolder) viewHolder).textView.setText("JANKIN");
            ((ViewHolder) viewHolder).author.setText("author");
            ((ViewHolder) viewHolder).date.setText("date");
        }
    }

    @Override
    public int getItemCount() {
        return 8;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView,author,date;
        CardView cardView;
        ViewHolder(View view) {
            super(view);
            cardView = (CardView) view;
            textView = view.findViewById(R.id.article_title);
            author = view.findViewById(R.id.tv_article_author);
            date = view.findViewById(R.id.tv_article_date);
        }
    }
}
