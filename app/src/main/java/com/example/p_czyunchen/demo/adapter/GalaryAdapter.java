package com.example.p_czyunchen.demo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.p_czyunchen.demo.R;
import com.example.p_czyunchen.demo.bean.Beauty;

import java.util.List;

public class GalaryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private List<Integer> list;
    private OnItemClick itemClick;
    private List<Beauty.ResultsBean> resultsBeans;

    public void setmDatas(List<String> mDatas) {
        this.mDatas = mDatas;
    }

    private List<String> mDatas;

    public void setResultsBeans(List<Beauty.ResultsBean> resultsBeans) {
        this.resultsBeans = resultsBeans;
    }

    public void setItemClick(OnItemClick itemClick) {
        this.itemClick = itemClick;
    }

    public GalaryAdapter(Context context, List<Integer> list) {
        this.mContext = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (mContext == null) {
            mContext = viewGroup.getContext();
        }
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_galary, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof ViewHolder) {
//            ((ViewHolder) viewHolder).imageView.setImageResource(list.get(i));
            Glide.with(mContext).load(resultsBeans.get(i).getUrl()).into(((ViewHolder) viewHolder).imageView);
            ((ViewHolder) viewHolder).linearLayout.setOnClickListener(v ->
                    itemClick.onClick(viewHolder, i)
            );
            ((ViewHolder) viewHolder).linearLayout.setOnLongClickListener(v -> {
                        Toast.makeText(mContext, "long click", Toast.LENGTH_SHORT).show();
                        remove(i);
                        return true;
                    }
            );
        }
    }

    @Override
    public int getItemCount() {
        return resultsBeans.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout linearLayout;
        ImageView imageView;
        TextView textView;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            linearLayout = (LinearLayout) itemView;
            imageView = itemView.findViewById(R.id.image_galary_indicator);
            textView = itemView.findViewById(R.id.tv_galary);
        }
    }

    public interface OnItemClick {
        void onClick(RecyclerView.ViewHolder view, int position);
    }

    public void add(int position) {
        mDatas.add(position, "insert");
        notifyItemInserted(position);
    }

    public void remove(int position) {
        mDatas.remove(position);
        notifyItemRemoved(position);
    }
}
