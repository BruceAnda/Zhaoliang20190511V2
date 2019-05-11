package cn.zhaoliang5156.zhaoliang20190511v2.mvp.user;

import cn.zhaoliang5156.zhaoliang20190511v2.net.CallBack;

/**
 * Copyright (C), 2015-2019, 八维集团
 * Author: zhaoliang
 * Date: 2019/5/11 11:27 AM
 * Description: 用户 P
 */
public class UserPresenterImpl implements IUserContract.IUserPresenter {

    private IUserContract.IUserView view;
    private IUserContract.IUserModel model;

    @Override
    public void attach(IUserContract.IUserView view) {
        this.view = view;
        model = new UserModelImpl();
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
    public void regist(String phone, String pwd) {
        model.regist(phone, pwd, new CallBack() {
            @Override
            public void onSuccess(String result) {
                view.onRegistSuccess(result);
            }

            @Override
            public void onFail(String msg) {

            }
        });
    }

    @Override
    public void login(String phone, String pwd) {
        model.login(phone, pwd, new CallBack() {
            @Override
            public void onSuccess(String result) {
                view.loginSuccess(result);
            }

            @Override
            public void onFail(String msg) {

            }
        });
    }
}
