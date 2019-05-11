package cn.zhaoliang5156.zhaoliang20190511v2.mvp.user;

import cn.zhaoliang5156.zhaoliang20190511v2.net.CallBack;

/**
 * Copyright (C), 2015-2019, 八维集团
 * Author: zhaoliang
 * Date: 2019/5/11 11:24 AM
 * Description: 用户相关的契约接口
 * M
 * V
 * P
 * MVP 存在内存泄漏的问题
 */
public interface IUserContract {

    public interface IUserView {

        void onRegistSuccess(String result);

        void loginSuccess(String result);
    }

    public interface IUserModel {

        void regist(String phone, String pwd, CallBack callBack);

        void login(String phone, String pwd, CallBack callBack);
    }

    public interface IUserPresenter {

        void attach(IUserView view);

        void detach();

        void regist(String phone, String pwd);

        void login(String phone, String pwd);
    }
}
