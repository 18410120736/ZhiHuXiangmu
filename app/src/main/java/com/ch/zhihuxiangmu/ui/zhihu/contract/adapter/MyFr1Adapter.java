package com.ch.zhihuxiangmu.ui.zhihu.contract.adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ch.zhihuxiangmu.R;
import com.ch.zhihuxiangmu.ui.zhihu.contract.bean.LunBo;

import java.util.List;

/**
 * Created by 123 on 2017/1/9.
 */
public class MyFr1Adapter extends RecyclerView.Adapter<MyFr1Adapter.ViewHolder> {


    private Context context;
    private List<LunBo.Stories> list1;
    public MyFr1Adapter(Context context, List<LunBo.Stories> list1) {
        this.context=context;
        this.list1=list1;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder holder = new ViewHolder(LayoutInflater.from(
                context).inflate(R.layout.fr1_item, parent,
                false));
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Glide.with(context)
                .load(list1.get(position).getImages().get(0))
                .into(holder.im);
        holder.te.setText(list1.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return list1.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView im;
        private TextView te;
        public ViewHolder(View itemView) {
            super(itemView);
            im=  (ImageView) itemView.findViewById(R.id.it_image);
            te= (TextView) itemView.findViewById(R.id.it_title);
        }
    }
}
