package com.ch.zhihuxiangmu.ui.zhihu.contract.util;

import com.ch.zhihuxiangmu.ui.zhihu.contract.bean.ZhuanLan;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by 123 on 2017/1/12.
 */
public interface ApiService {
    //http://news-at.zhihu.com/api/4/themes
    @GET("/api/")
    Call<ZhuanLan> getIpInfo(@Query("page")String page,@Query("themes")String them);
}
