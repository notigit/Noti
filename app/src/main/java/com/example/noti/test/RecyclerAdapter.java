package com.example.noti.test;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.noti.R;

import java.util.List;

/**
 * Created by 10264 on 2018/4/7.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerVH> {
    List<String> mList;
    Context mContext;

    public RecyclerAdapter(List<String> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
    }

    @Override
    public RecyclerAdapter.RecyclerVH onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.e("TAG", "onCreateViewHolder: " );
        View view = LayoutInflater.from(mContext).inflate(R.layout.recycler_item,null,false);
        RecyclerVH recyclerVH = new RecyclerVH(view);
        return recyclerVH;
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.RecyclerVH holder, int position) {
        holder.nameTv.setText(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class RecyclerVH extends RecyclerView.ViewHolder {
        TextView nameTv;

        public RecyclerVH(View itemView) {
            super(itemView);
            nameTv = itemView.findViewById(R.id.nameTv);
        }
    }
}
