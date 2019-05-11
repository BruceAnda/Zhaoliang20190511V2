package cn.zhaoliang5156.zhaoliang20190511v2.net;

/**
 * Copyright (C), 2015-2019, 八维集团
 * Author: zhaoliang
 * Date: 2019/5/11 10:55 AM
 * Description: 网络响应
 */
public interface CallBack {

    void onSuccess(String result);

    void onFail(String msg);
}
