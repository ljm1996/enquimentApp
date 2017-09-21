package com.example.administrator.enquimentapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/9/14.
 */

public class setUpActivty extends Activity {
    private ImageView retunimg;
    private RecyclerView recyclerView;
    private List<setUpItemBean> itemArticle = new ArrayList<setUpItemBean>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sethidden();
        setContentView(R.layout.setup_activity);
        initVar();
        initView();
    }

     /*到数据并显示*/
    private void initVar() {
        String[] strTitle = {"电视机","牙刷", "羽毛球", "辣条", "口红", "裙子","吊带"};
        String[] strnum = {"0001，0125", "4798", "8692", "4521", "7854", "0018"};
        String[] strType = {"电器，", "生活用品", "体育用品", "食品", "化妆品", "服装","服装"};
        String[] strAdrass = {"北京", "上海", "湖南", "南京", "湖北", "天津","株洲"};
        int[] resId={R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher};
        for(int i=0;i<6;i++){
            setUpItemBean item=new setUpItemBean();
            item.setImgid(resId[i]);
            item.setNum(strnum[i]);
            item.setTitle(strTitle[i]);
            item.setType(strType[i]);
            item.setAddrass(strAdrass[i]);
            itemArticle.add(item);
        }
        /* 加载适配布局*/
        // RecyclerView.LayoutManager layout = new GridLayoutManager(this,3);//网格布局，每行为3
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layout=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layout);
        recyclerView.setHasFixedSize(true);//适配器内容改变，不会改变RecyclerView的大小
        setupAdapter adapter=new setupAdapter(itemArticle);
        recyclerView.setAdapter(adapter);

    }

    /*初始化控件，返回跳转*/
    private void initView() {
        retunimg=(ImageView)findViewById(R.id.retunimg);
        retunimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(setUpActivty.this, muenActivity.class);
                setUpActivty.this.startActivity(intent);
            }
        });
    }

    /*隐藏标题和状态栏*/
    public void sethidden() {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
        }

}
