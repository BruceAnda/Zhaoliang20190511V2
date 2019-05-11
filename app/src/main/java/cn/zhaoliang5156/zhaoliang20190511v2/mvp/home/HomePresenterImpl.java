package cn.zhaoliang5156.zhaoliang20190511v2.mvp.home;

import cn.zhaoliang5156.zhaoliang20190511v2.net.CallBack;

/**
 * Copyright (C), 2015-2019, 八维集团
 * Author: zhaoliang
 * Date: 2019/5/11 2:31 PM
 * Description: Home 业务
 */
public class HomePresenterImpl implements IHomeContract.IHomePresenter {

    private IHomeContract.IHomeView view;
    private IHomeContract.IHomeModel model;

    @Override
    public void attach(IHomeContract.IHomeView view) {
        this.view = view;
        model = new HomeModelImpl();
    }

    @Override
    public void detach() {
        if (view != null) {
            view = null;
        }
        if (model != null) {
            model = null;
        }
    }

    @Override
    public void requstList(String url) {
        model.requstList(url, new CallBack() {
            @Override
            public void onSuccess(String result) {
                view.showList(result);
            }

            @Override
            public void onFail(String msg) {

            }
        });
    }
}
