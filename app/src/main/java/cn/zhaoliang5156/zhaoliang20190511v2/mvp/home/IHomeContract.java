package cn.zhaoliang5156.zhaoliang20190511v2.mvp.home;

import cn.zhaoliang5156.zhaoliang20190511v2.net.CallBack;

/**
 * Copyright (C), 2015-2019, 八维集团
 * Author: zhaoliang
 * Date: 2019/5/11 2:30 PM
 * Description: home mvp 契约
 */
public interface IHomeContract {

    public interface IHomeView {

        void showList(String result);
    }

    public interface IHomeModel {

        void requstList(String url, CallBack callBack);
    }

    public interface IHomePresenter {

        void attach(IHomeView view);

        void detach();

        void requstList(String url);
    }
}
