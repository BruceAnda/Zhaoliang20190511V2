package cn.zhaoliang5156.zhaoliang20190511v2.bean;

import java.util.List;

/**
 * Copyright (C), 2015-2019, 八维集团
 * Author: zhaoliang
 * Date: 2019/5/11 2:47 PM
 * Description:
 */
public class HomeBean {

    public String message;
    public String status;
    public Result result;

    public static class Result {
        public Life rxxp;
        public Life pzsh;
    }

    public static class Life {

        public int id;
        public String name;
        public List<ShopInfo> commodityList;
    }

    public static class ShopInfo {
        public String commodityName;
        public String masterPic;
    }
}
