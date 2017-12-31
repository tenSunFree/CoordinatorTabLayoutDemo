package com.example.administrator.coordinatortablayoutdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import java.util.ArrayList;

import cn.hugeterry.coordinatortablayout.CoordinatorTabLayout;

public class MainActivity extends AppCompatActivity {

    private CoordinatorTabLayout mCoordinatorTabLayout;
    private int[] mImageArray, mColorArray2;
    private ArrayList<Fragment> mFragments;
    private String[] titles;
    private String[] forestIntroductionDatas;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initDatas();
        initFragments();
        initViewPager();

        mCoordinatorTabLayout = (CoordinatorTabLayout) findViewById(R.id.coordinatortablayout);
        mCoordinatorTabLayout.setTranslucentStatusBar(this)
                .setTitle("美麗的森林")
                .setBackEnable(true)
                .setImageArray(mImageArray, mColorArray2)
                .setupWithViewPager(mViewPager);
    }

    /**
     * 創建一個Fragment類型的动态数组, 並添加自定義的Fragment 進去
     */
    private void initFragments() {
        mFragments = new ArrayList<>();
        for (String forestIntroductionData : forestIntroductionDatas) {
            mFragments.add(MainFragment.getInstance(forestIntroductionData));
        }
    }

    /**
     * 實體化ViewPager
     */
    private void initViewPager() {
        mViewPager = (ViewPager) findViewById(R.id.vp);
        mViewPager.setOffscreenPageLimit(1);
        mViewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(), mFragments, titles));
    }

    /**
     * 建立 標題組& 內容組& 上層圖片組& 對應的顏色組
     */
    private void initDatas() {

        titles = new String[]{"屋久島", "克萊文", "太平山"};
        forestIntroductionDatas = new String[]{
                getApplication().getString(R.string.forestIntroductionData1),
                getApplication().getString(R.string.forestIntroductionData2),
                getApplication().getString(R.string.forestIntroductionData3)
        };

        mImageArray = new int[]{
                R.mipmap.forest1_2,
                R.mipmap.forest2_2,
                R.mipmap.forest3_2};

        mColorArray2 = new int[]{
                R.color.topBarBackground2,
                R.color.topBarBackground2,
                R.color.topBarBackground2
        };
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
