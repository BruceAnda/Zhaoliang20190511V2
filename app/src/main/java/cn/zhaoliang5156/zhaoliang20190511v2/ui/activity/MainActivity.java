package cn.zhaoliang5156.zhaoliang20190511v2.ui.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import cn.zhaoliang5156.zhaoliang20190511v2.R;
import cn.zhaoliang5156.zhaoliang20190511v2.adapter.MainPagerAdapter;
import cn.zhaoliang5156.zhaoliang20190511v2.ui.fragment.HomeFragment;
import cn.zhaoliang5156.zhaoliang20190511v2.ui.fragment.MyFragment;

/**
 * Copyright (C), 2015-2019, 八维集团
 * Author: zhaoliang
 * Date: 2019/5/11 11:18 AM
 * Description: 首页
 * <p>
 * phone:15116970781
 * pwd:123456
 */
public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private List<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tab_layout);

        fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new MyFragment());

        viewPager.setAdapter(new MainPagerAdapter(getSupportFragmentManager(), fragments));
        tabLayout.setupWithViewPager(viewPager);
    }
}
