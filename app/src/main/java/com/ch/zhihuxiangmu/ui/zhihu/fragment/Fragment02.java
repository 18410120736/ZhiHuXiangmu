package com.ch.zhihuxiangmu.ui.zhihu.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ch.zhihuxiangmu.R;
import com.ch.zhihuxiangmu.ui.zhihu.contract.adapter.ZhuanLanAdapter;
import com.ch.zhihuxiangmu.ui.zhihu.contract.bean.ZhuanLan;
import com.ch.zhihuxiangmu.ui.zhihu.contract.util.ApiService;
import com.ch.zhihuxiangmu.ui.zhihu.contract.util.OkHttp;
import com.google.gson.Gson;


import java.io.IOException;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by 123 on 2017/1/4.
 */
public class Fragment02 extends Fragment {

    private View view;
    private RecyclerView fr;
    ///api/4/news/before/20131119
    private String url="http://news-at.zhihu.com/api/3/sections";
    //private String url="http://news-at.zhihu.com/api/";
    //private String them="/thems";
    private ArrayList<ZhuanLan.Data> list=new ArrayList<>();
    private ZhuanLan zhuanLan;
    private ZhuanLanAdapter zhuanlianAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.zhufragment02,container,false);
        fr = (RecyclerView) view.findViewById(R.id.fr2_recy);
        return view;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        myok();
    }
    public void myok(){
        /*Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);

        Call<ZhuanLan> call = apiService.getIpInfo(page+"",them);
        call.enqueue(new Callback<ZhuanLan>() {
            @Override
            public void onResponse(Call<ZhuanLan> call, Response<ZhuanLan> response) {
                ZhuanLan body = response.body();
                list.addAll(zhuanLan.getOthers());
                init();
            }

            @Override
            public void onFailure(Call<ZhuanLan> call, Throwable t) {

            }
        });*/


        OkHttp.getAsync(url, new OkHttp.DataCallBack() {
            @Override
            public void requestFailure(Request request, IOException e) {

            }
            @Override
            public void requestSuccess(String result) throws Exception {
                Gson gson=new Gson();
                zhuanLan = gson.fromJson(result, ZhuanLan.class);
                list.addAll(zhuanLan.getData());
                init();
            }
        });
    }
    private void init() {
        fr.setLayoutManager(new GridLayoutManager(getActivity(),2));
        zhuanlianAdapter = new ZhuanLanAdapter(getActivity(),list);
        fr.setAdapter(zhuanlianAdapter);
    }
}
