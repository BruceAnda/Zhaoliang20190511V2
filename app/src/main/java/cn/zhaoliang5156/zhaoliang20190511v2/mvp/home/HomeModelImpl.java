package cn.zhaoliang5156.zhaoliang20190511v2.mvp.home;

import cn.zhaoliang5156.zhaoliang20190511v2.net.CallBack;
import cn.zhaoliang5156.zhaoliang20190511v2.net.HttpUtil;

/**
 * Copyright (C), 2015-2019, 八维集团
 * Author: zhaoliang
 * Date: 2019/5/11 2:32 PM
 * Description: Home mode
 */
public class HomeModelImpl implements IHomeContract.IHomeModel {

    private HttpUtil util;

    public HomeModelImpl() {
        util = HttpUtil.getInstance();
    }

    @Override
    public void requstList(String url, CallBack callBack) {
        util.doHttpGet(url, callBack);
    }
}
