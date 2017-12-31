package com.example.administrator.coordinatortablayoutdemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * FragmentPagerAdapter 有可能会导致使用大量内存, 因为Fragment实例可以持有任意数量的状态; 所以对于较大的页面, 可以考虑 FragmentStatePagerAdapter
 */
public class MyPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private final String[] mTitles;

    public MyPagerAdapter(FragmentManager fm, ArrayList<Fragment> mFragments, String[] mTitles) {
        super(fm);
        this.mFragments = mFragments;
        this.mTitles = mTitles;
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    /**
     * CharSequence是表示字符序列的标准Java接口,  String是CharSequence最常用的具体实现
     * @return, 返回ViewPager 每頁對應的標題, 並顯示在Tab
     */
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }
}
