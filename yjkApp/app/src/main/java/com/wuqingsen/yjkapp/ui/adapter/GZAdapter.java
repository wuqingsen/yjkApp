package com.wuqingsen.yjkapp.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.wuqingsen.yjkapp.R;
import com.wuqingsen.yjkapp.common.base.BaseAdapter;
import com.wuqingsen.yjkapp.common.base.BaseRecyclerViewHolder;

import java.util.List;

public class GZAdapter extends BaseAdapter<String> {

    public GZAdapter(Context context, List<String> datas) {
        super(context, datas);
    }

    @Override
    protected void showViewHolder(BaseRecyclerViewHolder baseHolder, final int position) {
        MyViewHolder holder = (MyViewHolder) baseHolder;

    }

    @Override
    protected BaseRecyclerViewHolder createView(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.adapter_gz, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }


    class MyViewHolder extends BaseRecyclerViewHolder {

        public MyViewHolder(View itemView) {
            super(itemView);

        }

    }
}