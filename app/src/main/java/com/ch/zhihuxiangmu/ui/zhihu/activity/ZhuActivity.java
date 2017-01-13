package com.ch.zhihuxiangmu.ui.zhihu.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.ch.zhihuxiangmu.R;
import com.ch.zhihuxiangmu.activity.GuanyuActivity;
import com.ch.zhihuxiangmu.activity.ShezhiActivity;
import com.ch.zhihuxiangmu.activity.TVActivity;
import com.ch.zhihuxiangmu.activity.ZhutiActivity;
import com.ch.zhihuxiangmu.ui.zhihu.contract.adapter.MyAdapter;
import com.ch.zhihuxiangmu.ui.zhihu.fragment.Fragment01;
import com.ch.zhihuxiangmu.ui.zhihu.fragment.Fragment02;
import com.ch.zhihuxiangmu.ui.zhihu.fragment.Fragment03;
import com.ch.zhihuxiangmu.ui.zhihu.fragment.Fragment04;
import com.ch.zhihuxiangmu.ui.zhihu.model.MyTabLayout;

import java.util.ArrayList;
import java.util.List;

public class ZhuActivity extends AppCompatActivity implements MyTabLayout{
    private Toolbar to;
    private ViewPager vp;
    private ArrayList<Fragment> list = new ArrayList<>();
    private TabLayout tab;
    private DrawerLayout mDrawerLayout;
    private NavigationView na;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhu);
        initview();
        riye();
        to.inflateMenu(R.menu.menu_zhu);
        to.setTitleTextColor(getResources().getColor(R.color.colorCard));
        addfragment();
        controller();
        dianjishijian();
    }

    private void dianjishijian() {
        na.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.tiaomu_one:
                        Intent intent=new Intent(ZhuActivity.this, ZhutiActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.tiaomu_two:
                        Intent intent1=new Intent(ZhuActivity.this, TVActivity.class);
                        startActivity(intent1);
                        break;
                    case R.id.tiaomu_frou:
                        Intent intent2=new Intent(ZhuActivity.this, ShezhiActivity.class);
                        startActivity(intent2);
                        break;
                    case R.id.tiaomu_five:
                        Intent intent3=new Intent(ZhuActivity.this, GuanyuActivity.class);
                        startActivity(intent3);
                        break;
                }
                return true;
            }
        });

    }


    private void riye() {
        to.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return false;
            }
        });
    }

    private void controller() {
        ActionBarDrawerToggle mDrawerToggle=new ActionBarDrawerToggle(this,mDrawerLayout,to,R.string.open,R.string.close){
            //开
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
            //关
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        mDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mDrawerToggle);

    }
    private void initview() {
        to = (Toolbar) findViewById(R.id.zhu_toor);
        tab = (TabLayout) findViewById(R.id.tablayout);
        vp = (ViewPager) findViewById(R.id.zhu_viewpager);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.zhu_left);
        na = (NavigationView) findViewById(R.id.na);


    }

    @Override
    public void addfragment() {
        List<Fragment> list = new ArrayList<>();
        Fragment01 dailyFragment = new Fragment01();
        Fragment02 columnFragment = new Fragment02();
        Fragment03 weChatFragment = new Fragment03();
        Fragment04 hotFragment = new Fragment04();
        list.add(dailyFragment);
        list.add(columnFragment);
        list.add(weChatFragment);
        list.add(hotFragment);
        MyAdapter myAdapter = new MyAdapter(getSupportFragmentManager(), list);
        vp.setAdapter(myAdapter);
        tab.setupWithViewPager(vp);
    }
}
