package com.example.noti.test;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by 10264 on 2018/4/7.
 */

public class RecyclerLayoutManager extends RecyclerView.LayoutManager {
    @Override
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(RecyclerView.LayoutParams.WRAP_CONTENT, RecyclerView.LayoutParams.WRAP_CONTENT);
    }

    @Override
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        super.onLayoutChildren(recycler, state);
        int count = getItemCount();
        Log.e("TAG", "onLayoutChildren: "+count );
        for (int i = 0; i < count; i++) {
            View view = recycler.getViewForPosition(i);
            Log.e("TAG", "onLayoutChildren: "+getPosition(view) );
            addView(view);
            measureChildWithMargins(view,0,0);
            layoutDecoratedWithMargins(view,0,getDecoratedMeasuredHeight(view)*i,getDecoratedMeasuredWidth(view),getDecoratedMeasuredHeight(view)*(i+1));
        }
    }
}
