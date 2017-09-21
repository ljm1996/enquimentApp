package com.example.administrator.enquimentapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Administrator on 2017/9/14.
 */

public class muenActivity extends Activity {
    private AppCompatButton btn_set;
    private ImageView setimg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sethidden();
        setContentView(R.layout.muen);
        btn_set=(AppCompatButton)findViewById(R.id.btn_set);
        btn_set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(muenActivity.this,setUpActivty .class);
                muenActivity.this.startActivity(intent);
            }
        });
        setimg=(ImageView)findViewById(R.id.setimg);
        setimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(muenActivity.this, MainActivity.class);
                muenActivity.this.startActivity(intent);
            }
        });
    }
    //隐藏标题栏
    public void sethidden() {
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
    }
}
