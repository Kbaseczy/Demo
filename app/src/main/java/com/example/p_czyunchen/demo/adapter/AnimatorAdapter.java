package com.example.p_czyunchen.demo.adapter;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
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
        viewHolder.cardView.setOnLongClickListener(v -> {
                    remove(i);
                    return true;
                }
        );
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardView_animator);

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
