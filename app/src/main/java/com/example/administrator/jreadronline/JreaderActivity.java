package com.example.administrator.jreadronline;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.jreadronline.Adapter.FragmentAdatper;
import com.example.administrator.jreadronline.Fragment.BookFragment;
import com.example.administrator.jreadronline.Fragment.FaceFragment;
import com.example.administrator.jreadronline.Fragment.MyFragment;
import com.example.administrator.jreadronline.Fragment.WordFragment;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class JreaderActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView title,bookTv,faceTv,meTv,guanyuTv;
    private ViewPager vp;
    private BookFragment bookFragment;
    private FaceFragment faceFragment;
    private MyFragment   myFragment;
    private WordFragment wordFragment;
    private List<Fragment> list = new ArrayList<Fragment>();
    private FragmentAdatper adatper;
    private Banner banner;
    String[] titles = new String[]{"书籍","面试题目","我的","关于"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jreader);
        setTitle("书籍");
        initView();

        adatper = new FragmentAdatper(this,getSupportFragmentManager(),list);
        vp.setOffscreenPageLimit(4);
        vp.setAdapter(adatper);
        vp.setCurrentItem(0);
        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                title.setText(titles[position]);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    private void initView() {
        title = findViewById(R.id.jreader_title);
        bookTv = findViewById(R.id.item_book);
        faceTv = findViewById(R.id.item_face);
        guanyuTv = findViewById(R.id.item_guanyu);
        meTv = findViewById(R.id.item_me);

        bookTv.setOnClickListener(this);
        faceTv.setOnClickListener(this);
        guanyuTv.setOnClickListener(this);
        meTv.setOnClickListener(this);

        vp = findViewById(R.id.mainViewPager);

        bookFragment = new BookFragment();
        faceFragment = new FaceFragment();
        myFragment = new MyFragment();
        wordFragment = new WordFragment();

        list.add(bookFragment);
        list.add(faceFragment);
        list.add(myFragment);
        list.add(wordFragment);

    }
    public static class MyLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load((String) path).into(imageView);
        }
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.item_book:
                break;
            case R.id.item_face:
                break;
            case R.id.item_guanyu:
                break;
            case R.id.item_me:
                break;
        }
    }
}
