package com.example.administrator.jreadronline;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private ImageView main_iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        main_iv = findViewById(R.id.main_iv);
        //设置图片动画效果
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.alpha);
        //图片渐变为4秒
        main_iv.startAnimation(animation);
        //设置自动跳转主页面
        final Intent intent = new Intent(this,JreaderActivity.class);
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                startActivity(intent);
            }
        };
        //自动跳转主页面为5秒
        timer.schedule(timerTask,1000*5);
    }
}
