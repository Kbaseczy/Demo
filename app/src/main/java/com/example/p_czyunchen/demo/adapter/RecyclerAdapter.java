package com.example.p_czyunchen.demo.adapter;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.bumptech.glide.Glide;
import com.example.p_czyunchen.demo.R;
import com.example.p_czyunchen.demo.util.GlideImageLoader;

import java.util.ArrayList;
import java.util.List;

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
        return 4;
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
        List<Integer> list = new ArrayList<>();
        list.add(R.drawable.ic_launcher_background);
        list.add(R.drawable.ic_launcher_foreground);
        if (viewHolder instanceof ViewHolder_banner) {
            ((ViewHolder_banner) viewHolder).banner
                    .setImageLoader(new GlideImageLoader())
                    .setImages(list)
                    .start();
            //点击监听也在这里实现
        }
        if (viewHolder instanceof ViewHolder_tab) {
                ((ViewHolder_tab) viewHolder).textView_project.setOnClickListener(v->
                        Toast.makeText(context, "jump project activity", Toast.LENGTH_SHORT).show());
            ((ViewHolder_tab) viewHolder).textView_navi.setOnClickListener(v->
                    Toast.makeText(context, "jump Navigate activity", Toast.LENGTH_SHORT).show());
        }
        if (viewHolder instanceof ViewHolder_news) {
            ((ViewHolder_news) viewHolder).flipper.addView(View.inflate(context,R.layout.item_viewflipper,null));
            Glide.with(context).load(R.drawable.ic_launcher_background).into(((ViewHolder_news) viewHolder).imageView);
        }
        if (viewHolder instanceof ViewHolder_recycler) {

            GridLayoutManager manager = new GridLayoutManager(context,2);
            RecyclerAdapterItem adapterItem = new RecyclerAdapterItem();
            ((ViewHolder_recycler) viewHolder).recyclerView.setLayoutManager(manager);
            ((ViewHolder_recycler) viewHolder).recyclerView.setAdapter(adapterItem);
        }

    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0)
            return BANNER;
        else if(position == 1)
            return TAB;
        else if(position == 2)
            return NEWS;
        else
            return RECYCLER;
    }

    static class ViewHolder_banner extends RecyclerView.ViewHolder {
        com.youth.banner.Banner banner;

        ViewHolder_banner(View view) {
            super(view);
            banner = view.findViewById(R.id.banner);
        }
    }

    static class ViewHolder_tab extends RecyclerView.ViewHolder {
        TextView textView_project,textView_navi;
        ViewHolder_tab(View view) {
            super(view);
            textView_project = view.findViewById(R.id.project);
            textView_navi = view.findViewById(R.id.navi);
        }
    }

    static class ViewHolder_news extends RecyclerView.ViewHolder {
        ImageView imageView;
        ViewFlipper flipper;
        ViewHolder_news(View view) {
            super(view);
            imageView = view.findViewById(R.id.news_image);
            flipper = view.findViewById(R.id.news_flipper);
        }
    }

    static class ViewHolder_recycler extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;
        ViewHolder_recycler(View view) {
            super(view);
            recyclerView = view.findViewById(R.id.recycler_item);
        }
    }
}
