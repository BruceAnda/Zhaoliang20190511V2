package cn.zhaoliang5156.zhaoliang20190511v2.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.json.JSONObject;

import cn.zhaoliang5156.zhaoliang20190511v2.R;
import cn.zhaoliang5156.zhaoliang20190511v2.adapter.HomeAdapter;
import cn.zhaoliang5156.zhaoliang20190511v2.bean.HomeBean;
import cn.zhaoliang5156.zhaoliang20190511v2.mvp.home.HomePresenterImpl;
import cn.zhaoliang5156.zhaoliang20190511v2.mvp.home.IHomeContract;

/**
 * Copyright (C), 2015-2019, 八维集团
 * Author: zhaoliang
 * Date: 2019/5/11 2:32 PM
 * Description:  首页多条目列表
 */
public class HomeFragment extends Fragment implements IHomeContract.IHomeView {


    private View view;
    private ListView homeList;
    private IHomeContract.IHomePresenter presenter;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);

        homeList = view.findViewById(R.id.home_list);


        // 调用业务层 请求展示列表的业务
        presenter = new HomePresenterImpl();

        presenter.attach(this);

        String url = "http://172.17.8.100/small/commodity/v1/commodityList";
        presenter.requstList(url);

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.detach();
    }

    @Override
    public void showList(String result) {
        // 展示列表
        // 1. 创建Gson对象
        // 2. 调用Gson对象的fromJson方法，把Json对象转换成Json字符串
        Gson gson = new Gson();
        HomeBean homeBean = gson.fromJson(result, HomeBean.class);

        homeList.setAdapter(new HomeAdapter(getActivity(), homeBean));
    }
}
