package com.example.noti.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.noti.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 10264 on 2018/4/19.
 */

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Log.e("TAG", "2onCreate: " );
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View view) {
                finish();
                if (onTitleCallBack != null){
                    onTitleCallBack.onTitle("这是第二个页面");
                }
            }
        });
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("TAG", "2onRestart: " );
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("TAG", "2onPause: " );
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("TAG", "2onStart: " );
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("TAG", "2onStop: " );
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("TAG", "2onResume: " );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("TAG", "2onDestroy: " );
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.e("TAG", "2onRestoreInstanceState: " );
    }

    public interface OnTitleCallBack{
        void onTitle(String str);
    }
    public OnTitleCallBack onTitleCallBack;
    public void setOnTitleCallBack(OnTitleCallBack onTitleCallBack){
        this.onTitleCallBack = onTitleCallBack;
    }
}
