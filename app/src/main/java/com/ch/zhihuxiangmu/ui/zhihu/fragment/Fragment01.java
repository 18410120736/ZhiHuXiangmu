package com.ch.zhihuxiangmu.ui.zhihu.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.ch.zhihuxiangmu.R;
import com.ch.zhihuxiangmu.ui.zhihu.contract.adapter.MyFr1Adapter;
import com.ch.zhihuxiangmu.ui.zhihu.contract.bean.LunBo;
import com.ch.zhihuxiangmu.ui.zhihu.contract.util.LunBaoUtil;
import com.ch.zhihuxiangmu.ui.zhihu.contract.util.OkHttp;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Request;

/**
 * Created by 123 on 2017/1/4.
 */
public class Fragment01 extends Fragment {

    private View view;
    private ConvenientBanner con;
    private String lunbourl="http://news-at.zhihu.com/api/4/news/latest";
    private LunBo lunBo;
    private List<LunBo.TopStoriesBean> list=new ArrayList<>();
    private List<LunBo.Stories> list1=new ArrayList<>();
    private RecyclerView recyclerView;
    private MyFr1Adapter myFr1Adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.zhufragment01,container,false);
        con = (ConvenientBanner) view.findViewById(R.id.convenientBanner);
        recyclerView = (RecyclerView) view.findViewById(R.id.f1_re);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    private void urldata() {

        OkHttp.getAsync(lunbourl, new OkHttp.DataCallBack() {
            @Override
            public void requestFailure(Request request, IOException e) {

            }

            @Override
            public void requestSuccess(String result) throws Exception {
                Gson gson=new Gson();
                lunBo = gson.fromJson(result, LunBo.class);
                list.addAll(lunBo.getTop_stories());
                LunBaoUtil lunBaoUtil=new LunBaoUtil();
                //轮播图
                lunBaoUtil.urlTupian(con,list);
                //展示条目
                list1.addAll(lunBo.getStories());
                zhanshitiaomu();
            }
        });
    }
    public void zhanshitiaomu(){
        //创建布局管理器
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //创建适配器
        myFr1Adapter = new MyFr1Adapter(getActivity(),list1);
        recyclerView.setAdapter(myFr1Adapter);
    }
    @Override
    public void onResume() {
        super.onResume();
        list1.clear();
        urldata();
        con.startTurning(1000);
    }
    @Override
    public void onPause() {
        super.onPause();
        list1.clear();
        list.clear();
        con.stopTurning();
    }
}
