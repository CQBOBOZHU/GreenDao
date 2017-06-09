package com.recyclerviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by BoBoZhu on 2017/6/9.
 */

public class BaseAdapter<T> extends RecyclerView.Adapter<BaseViewHolder> {
    List<T> mData;
    Context context;
    SparseArray<View> HeaderViews = new SparseArray<>();
    SparseArray<View> FooterViews = new SparseArray<>();

    public int ITEM_VIEW = 0;

    public BaseAdapter(Context context, List<T> mData) {
        this.context = context;
        this.mData = mData;
    }

    public void addHeaderView(View view) {
        HeaderViews.put(HeaderViews.size()+1 , view);
        notifyDataSetChanged();
    }

    public void addFooterView(View view) {
        FooterViews.put(-(FooterViews.size()+1), view);
        notifyDataSetChanged();
    }

    public void deleteFooterView(){
        if (FooterViews.size()>0){
            FooterViews.removeAt(0);

        }
        notifyDataSetChanged();
    }

    public  void deleteHeaderView(){
        if (HeaderViews.size()>0){
            HeaderViews.removeAt(HeaderViews.size()-1);

        }
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        if (HeaderViews.get(position+1) != null) {
            return HeaderViews.keyAt(position);
        }
        int a = position - getChildItemCount() - getHeaderCount();
        if (a >=0) {
            return FooterViews.keyAt(a);
        }

        return ITEM_VIEW;
    }


    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (HeaderViews.get(viewType) != null) {
            return new BaseViewHolder(HeaderViews.get(viewType));
        } else if (FooterViews.get(viewType) != null) {
            return new BaseViewHolder(FooterViews.get(viewType));
        }
        View view = LayoutInflater.from(context).inflate(R.layout.item_view, parent, false);
        return new BaseViewHolder(view);
    }


    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        if (getItemViewType(position) == ITEM_VIEW) {
            Log.v("this","position"+position);
            TextView textView = (TextView) holder.itemView.findViewById(R.id.item_tv);
            textView.setText(mData.get(position - getHeaderCount()) + "");
        }
    }


    @Override
    public int getItemCount() {
        return getChildItemCount() + getHeaderCount() + getFooterCount();
    }

    public int getHeaderCount() {
        return HeaderViews.size();
    }

    public int getChildItemCount() {
        return mData.size();
    }

    public int getFooterCount() {
        return FooterViews.size();
    }
}
