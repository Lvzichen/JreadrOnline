package com.example.administrator.jreadronline.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.administrator.jreadronline.JreaderActivity;

import java.util.ArrayList;
import java.util.List;

public class FragmentAdatper extends FragmentStatePagerAdapter{
    List<Fragment>list = new ArrayList<Fragment>();

    public FragmentAdatper(JreaderActivity jreaderActivity, FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.list = list;
    }


    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
