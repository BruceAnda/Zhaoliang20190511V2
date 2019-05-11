package cn.zhaoliang5156.zhaoliang20190511v2.mvp.user;

import cn.zhaoliang5156.zhaoliang20190511v2.net.CallBack;
import cn.zhaoliang5156.zhaoliang20190511v2.net.HttpUtil;

/**
 * Copyright (C), 2015-2019, 八维集团
 * Author: zhaoliang
 * Date: 2019/5/11 11:27 AM
 * Description: 用户 M
 */
public class UserModelImpl implements IUserContract.IUserModel {

    private HttpUtil httpUtil;

    public UserModelImpl() {
        httpUtil = HttpUtil.getInstance();
    }

    @Override
    public void regist(String phone, String pwd, CallBack callBack) {
        String registUrl = "http://172.17.8.100/small/user/v1/register";
        httpUtil.doHttpPost(registUrl, phone, pwd, callBack);
    }

    @Override
    public void login(String phone, String pwd, CallBack callBack) {
        String loginUrl = "http://172.17.8.100/small/user/v1/login";
        httpUtil.doHttpPost(loginUrl, phone, pwd, callBack);
    }
}
