package com.example.administrator.coordinatortablayoutdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private static final String ARG_CONTENT = "content";
    private List<String> forestIntroductionDatas;
    private String forestIntroductionData;

    /**
     * 如果想傳遞東西到Fragment, 可以透過setArguments, 不要直接new MainFragment(xxx yyy), 否則当某些情景发生, 一切就不一样了,  比如竖屏切换横屏, 切换到横屏时, 构造方法传递的参数就找不到了
     */
    public static MainFragment getInstance(String forestIntroductionData) {

        MainFragment fra = new MainFragment();

        Bundle bundle = new Bundle();
        bundle.putString(ARG_CONTENT, forestIntroductionData);
        fra.setArguments(bundle);
        return fra;
    }

    /**
     * bundle可以获取到 activity传来的参数, 如果訪問View層次結構可能會導致崩潰
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getArguments();
        forestIntroductionData = bundle.getString(ARG_CONTENT);
    }

    /**
     * 為Fragment 指定布局, 並實體化布局內的控件, 以及添加數據
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);

        forestIntroductionDatas = new ArrayList<>();
        forestIntroductionDatas.add(forestIntroductionData);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mRecyclerView.getContext()));
        mRecyclerView.setAdapter(new RecyclerAdapter(mRecyclerView.getContext(), forestIntroductionDatas));

        return view;
    }
}