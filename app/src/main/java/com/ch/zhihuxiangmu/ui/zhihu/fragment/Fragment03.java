package com.ch.zhihuxiangmu.ui.zhihu.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ch.zhihuxiangmu.R;
import com.ch.zhihuxiangmu.ui.zhihu.contract.adapter.WeiXinAdapter;
import com.ch.zhihuxiangmu.ui.zhihu.contract.adapter.ZhuanLanAdapter;
import com.ch.zhihuxiangmu.ui.zhihu.contract.bean.WeiXin;
import com.ch.zhihuxiangmu.ui.zhihu.contract.bean.ZhuanLan;
import com.ch.zhihuxiangmu.ui.zhihu.contract.util.OkHttp;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Request;

/**
 * Created by 123 on 2017/1/4.
 */
public class Fragment03 extends Fragment {

    private View view;
    private String url="http://news-at.zhihu.com/api/4/section/34/before/1465772400";
    private ArrayList<WeiXin.Stories> list=new ArrayList<>();
    private RecyclerView re;
    private WeiXinAdapter weiXinAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.zhufragment03,container,false);
        re = (RecyclerView) view.findViewById(R.id.fr3_re);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initdata();
    }

    private void initdata() {
        OkHttp.getAsync(url, new OkHttp.DataCallBack() {
            @Override
            public void requestFailure(Request request, IOException e) {

            }
            @Override
            public void requestSuccess(String result) throws Exception {
                Gson gson=new Gson();
                WeiXin weixin = gson.fromJson(result, WeiXin.class);
                list.addAll(weixin.getStories());
                init();
            }
        });
    }

    private void init() {
        re.setLayoutManager(new LinearLayoutManager(getActivity()));
        weiXinAdapter = new WeiXinAdapter(getActivity(),list);
        re.setAdapter(weiXinAdapter);
    }

}
