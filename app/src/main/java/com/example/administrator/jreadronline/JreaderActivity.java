package com.example.administrator.jreadronline;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;
import com.youth.banner.loader.ImageLoaderInterface;

import java.util.ArrayList;

public class JreaderActivity extends AppCompatActivity implements OnBannerListener {
    private Banner banner;
    private ArrayList<String> list_path;
    private ArrayList<String> list_title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jreader);
        initView();
    }

    private void initView() {
        banner = findViewById(R.id.banner);
        list_path = new ArrayList<>();
        list_title = new ArrayList<>();

        list_path.add("https://i04picsos.sogoucdn.com/33857b07b8a385b0");
        list_path.add("https://i02picsos.sogoucdn.com/b203e74116aa211f");
        list_path.add("https://i03picsos.sogoucdn.com/0e63c5defcc4d898");

        list_title.add("Android入门到精通");
        list_title.add("Android面试题");
        list_title.add("Java入门到精通");

        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        banner.setImageLoader(new MyLoader());
        banner.setImages(list_path);
        banner.setBannerAnimation(Transformer.Default);
        banner.setBannerTitles(list_title);
        banner.setDelayTime(2000);
        banner.isAutoPlay(true);
        banner.setIndicatorGravity(BannerConfig.CENTER).setOnBannerListener(this).start();
    }

    @Override
    public void OnBannerClick(int position) {
        Log.i("tag","你点了第"+position+"长轮播图");
    }

    private class MyLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load((String)path).into(imageView);
        }
    }
}
