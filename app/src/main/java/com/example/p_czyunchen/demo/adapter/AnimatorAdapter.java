package com.example.p_czyunchen.demo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.p_czyunchen.demo.R;

import java.util.List;


public class AnimatorAdapter extends RecyclerView.Adapter<AnimatorAdapter.ViewHolder> {
    public void setmDatas(List<String> mDatas) {
        this.mDatas = mDatas;
    }

    private Context mContext;
    private List<String> mDatas;

    public AnimatorAdapter(Context context) {
        this.mContext = context;
    }

    @NonNull
    @Override
    public AnimatorAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_animator, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimatorAdapter.ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    public void add(int position) {
        mDatas.add(1, "insert");
        notifyItemInserted(position);
    }

    public void remove(int position) {
        mDatas.remove(1);
        notifyItemRemoved(position);
    }
}
