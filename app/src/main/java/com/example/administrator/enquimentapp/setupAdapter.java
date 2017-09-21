package com.example.administrator.enquimentapp;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/9/15.
 */

public class setupAdapter extends RecyclerView.Adapter<setupAdapter.RecVH>{

    List<setUpItemBean> products=new ArrayList<setUpItemBean>();
    //构造方法传入数据
    public setupAdapter(List<setUpItemBean> products){
        this.products=products;
    }
    //创造ViewHolder
    @Override public RecVH onCreateViewHolder(ViewGroup parent, int viewType) {
   //把item的Layout转化成View传给
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.setip_item,parent,false);
        return new RecVH(view);
    }

    // 将数据放入相应的位置
    @Override
    public void onBindViewHolder(RecVH holder, int position) {
        holder.ivPic.setImageResource(products.get(position).getImgid());
        holder.tvNum.setText(products.get(position).getNum());
        holder.tvName.setText(products.get(position).getTitle());
        holder.tvYype.setText(products.get(position).getType());
        holder.tvAddrass.setText(products.get(position).getAddrass());
    }

    //ViewHolder绑定控件
    @Override
    public int getItemCount() {
        return products.size();
    }
    public class RecVH extends RecyclerView.ViewHolder{
        ImageView ivPic;
        TextView tvNum,tvName,tvYype,tvAddrass;

        public RecVH(View itemView) {
            super(itemView);
            ivPic= (ImageView) itemView.findViewById(R.id.ivPic);
            tvNum=(TextView) itemView.findViewById(R.id.tvNum);
            tvName= (TextView) itemView.findViewById(R.id.tvName);
            tvYype=(TextView)itemView.findViewById(R.id.tvType);
            tvAddrass=(TextView)itemView.findViewById(R.id.tvAddras);



        }
    }
}