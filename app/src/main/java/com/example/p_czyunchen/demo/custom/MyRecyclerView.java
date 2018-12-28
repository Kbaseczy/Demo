package com.example.p_czyunchen.demo.custom;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

public class MyRecyclerView extends RecyclerView {

    private View currentView;
    private OnItemScrollChangeListener OnItemScrollChangeListener;

    public MyRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.setOnItemScrollChangeListener(OnItemScrollChangeListener);
    }

    public interface OnItemScrollChangeListener {
        void change(View view, int i);
    }

    public void setOnItemScrollChangeListener(OnItemScrollChangeListener onScrollChange) {
        this.OnItemScrollChangeListener = onScrollChange;
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        currentView = getChildAt(0);
        if (OnItemScrollChangeListener != null) {
            OnItemScrollChangeListener.change(currentView, getChildAdapterPosition(currentView));
        }
    }

    @Override
    public void onScrollStateChanged(int state) {
        super.onScrollStateChanged(state);
    }

    @Override
    public void onScrolled(int dx, int dy) {
        super.onScrolled(dx, dy);
        View newView = getChildAt(0);
        if (OnItemScrollChangeListener != null) {
            if (newView != null && newView != currentView) {
                currentView = newView;
                OnItemScrollChangeListener.change(currentView, getChildAdapterPosition(currentView));
            }
        }
    }
}
