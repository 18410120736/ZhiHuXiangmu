package com.ch.zhihuxiangmu.ui.zhihu.contract.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ch.zhihuxiangmu.R;
import com.ch.zhihuxiangmu.ui.zhihu.contract.bean.WeiXin;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

/**
 * Created by 123 on 2017/1/11.
 */
public class WeiXinAdapter extends RecyclerView.Adapter<WeiXinAdapter.ViewHolder> {
    private Context context;
    private ArrayList<WeiXin.Stories> list;

    public WeiXinAdapter(Context context, ArrayList<WeiXin.Stories> list) {
        this.context=context;
        this.list=list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder holder = new ViewHolder(LayoutInflater.from(
                context).inflate(R.layout.weixin_item,parent,
                false));
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ImageLoader.getInstance().displayImage(list.get(position).getImages().get(0),holder.im);
        holder.te.setText(list.get(position).getTitle());
        holder.te1.setText(list.get(position).getDisplay_date());
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView im;
        TextView  te;
        TextView te1;
        public ViewHolder(View itemView) {
            super(itemView);
            im= (ImageView) itemView.findViewById(R.id.wei_im);
            te= (TextView) itemView.findViewById(R.id.wei_title);
            te1= (TextView) itemView.findViewById(R.id.wei_date);
        }
    }
}
