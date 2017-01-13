package com.ch.zhihuxiangmu.ui.zhihu.contract.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * 作用：
 * 作者：
 * 时间：
 */
public class MyAdapter extends FragmentPagerAdapter {

    private List<Fragment> list;
    String [] titles = new String[]{"日报","专栏","微信","热门"};
    public MyAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.list = list;
    }

    /**
     * Return the Fragment associated with a specified position.
     *
     * @param position
     */
    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    /**
     * Return the number of views available.
     */
    @Override
    public int getCount() {
        return list.size();
    }
    @Override
    public CharSequence getPageTitle(int position)
    {
        return titles[position];
    }
}
