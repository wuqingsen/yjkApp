package com.wuqingsen.yjkapp.common.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Name: 吴庆森
 * Date: 2019/10/24
 * Mailbox: 1243411677@qq.com
 * Describe:BaseAdapter
 */
public abstract class BaseAdapter<T> extends RecyclerView.Adapter<BaseRecyclerViewHolder> {
    protected Context mContext;
    protected LayoutInflater mInflater;
    protected List<T> mDatas = new ArrayList<T>();
    protected OnItemClickListener<T> mOnItemClickListener;
    protected IOnClickListener<T> onClickListener;
    protected IOnClickListener2<T> onClickListener2;
    protected IOnCheckListener<T> onCheckListener;

    public BaseAdapter(Context context, List<T> datas) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
        if (datas != null) {
            mDatas = datas;
        }
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }


    @Override
    public int getItemCount() {
        int count = 0;
        if (mDatas.size() > 0) {
            count = mDatas.size();
        }
        return count;
    }

    public void addItemLast(List<T> datas) {
        mDatas.addAll(datas);
        notifyDataSetChanged();
    }

    public void addItemTop(List<T> datas) {
        mDatas = datas;
        notifyDataSetChanged();
    }

    public void remove(int position) {
        mDatas.remove(position);
        notifyItemRemoved(position);
    }

    public void removeAll() {
        mDatas.clear();
        notifyDataSetChanged();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public List<T> getDatas() {
        return mDatas;
    }

    // 点击事件接口
    public interface OnItemClickListener<T> {
        void onItemClick(View view, int position, T model);

        void onItemLongClick(View view, int position, T model);
    }


    public void setOnItemClickListener(OnItemClickListener<T> listener) {
        this.mOnItemClickListener = listener;
    }

    @Override
    public void onBindViewHolder(BaseRecyclerViewHolder baseHolder, final int position) {
        showViewHolder(baseHolder, position);
        baseHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemClick(v, position, mDatas.get(position));
                }
            }
        });
    }


    @Override
    public BaseRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return createView(parent, viewType);
    }


    protected abstract void showViewHolder(BaseRecyclerViewHolder baseHolder, int position);

    /***
     *
     * @param parent
     * @param viewType
     * @return
     */
    protected abstract BaseRecyclerViewHolder createView(ViewGroup parent, int viewType);

    public interface IOnClickListener<T> {
        void OnClickListener(View view, int position, T t);
    }

    public interface IOnClickListener2<T> {
        void OnClickListener2(View view, int position, T t, Object tag);
    }

    /***
     * 点击事件方法
     * @param OnClickListener
     */
    public void setOnClickListener(IOnClickListener<T> OnClickListener) {
        this.onClickListener = OnClickListener;
    }

    public interface IOnCheckListener<T> {
        void onCheckListener(View view, int position, T t);
    }

    /***
     * 点击事件方法
     * @param OnClickListener
     */
    public void setOnClickListener2(IOnClickListener2<T> OnClickListener) {
        this.onClickListener2 = OnClickListener;
    }

    public void setOnCheckListener(IOnCheckListener<T> onCheckListener) {
        this.onCheckListener = onCheckListener;
    }
}
