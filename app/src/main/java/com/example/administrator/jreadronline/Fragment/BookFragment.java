package com.example.administrator.jreadronline.Fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.administrator.jreadronline.JreaderActivity;
import com.example.administrator.jreadronline.R;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class BookFragment extends Fragment implements OnBannerListener {
    public Banner banner;
    private ArrayList<String> list_path;
    private ArrayList<String> list_title;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view =  inflater.inflate(R.layout.fragment_book, container, false);
        banner = view.findViewById(R.id.banner);
        list_path = new ArrayList<>();
        list_title = new ArrayList<>();

        list_path.add("https://i04picsos.sogoucdn.com/33857b07b8a385b0");
        list_path.add("https://i02picsos.sogoucdn.com/b203e74116aa211f");
        list_path.add("https://i03picsos.sogoucdn.com/0e63c5defcc4d898");

        list_title.add("Android入门到精通");
        list_title.add("Android面试题");
        list_title.add("Java入门到精通");

        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        banner.setImageLoader(new JreaderActivity.MyLoader());
        banner.setImages(list_path);
        banner.setBannerAnimation(Transformer.Default);
        banner.setBannerTitles(list_title);
        banner.setDelayTime(2000);
        banner.isAutoPlay(true);
        banner.setIndicatorGravity(BannerConfig.CENTER).setOnBannerListener(this).start();
        return view;
    }

    @Override
    public void OnBannerClick(int position) {
        Log.i("tag", "你点了第"+position+"张轮播图");
    }
}
