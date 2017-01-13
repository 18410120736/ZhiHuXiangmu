package com.ch.zhihuxiangmu.ui.zhihu.contract.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 123 on 2017/1/11.
 */
public class MyTime {
    public static void mytime(){
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String dateNowStr = sdf.format(d);
    }
}
