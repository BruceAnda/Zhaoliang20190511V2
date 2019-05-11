package cn.zhaoliang5156.zhaoliang20190511v2.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import cn.zhaoliang5156.zhaoliang20190511v2.R;
import cn.zhaoliang5156.zhaoliang20190511v2.bean.HomeBean;

/**
 * Copyright (C), 2015-2019, 八维集团
 * Author: zhaoliang
 * Date: 2019/5/11 3:00 PM
 * Description:
 */
public class HomeAdapter extends BaseAdapter {

    private Context context;
    private HomeBean homeBean;

    // 定义条目类型
    private final int item_type_one = 1;
    private final int item_type_two = 2;

    public HomeAdapter(Context context, HomeBean homeBean) {
        this.context = context;
        this.homeBean = homeBean;
    }

    @Override
    public int getCount() {
        return homeBean.result.pzsh.commodityList.size() + homeBean.result.rxxp.commodityList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int itemViewType = getItemViewType(position);
        switch (itemViewType) {
            case item_type_one:
                TypeOneViewHodler hodler = null;
                if (convertView == null) {
                    hodler = new TypeOneViewHodler();
                    convertView = View.inflate(context, R.layout.item_type_one, null);
                    hodler.icon = convertView.findViewById(R.id.icon);
                    hodler.name = convertView.findViewById(R.id.name);
                    convertView.setTag(hodler);
                } else {
                    hodler = (TypeOneViewHodler) convertView.getTag();
                }
                // 赋值
                HomeBean.ShopInfo shopInfo = homeBean.result.rxxp.commodityList.get(position);
                hodler.name.setText(shopInfo.commodityName);
                // Glide
                Glide.with(context).load(shopInfo.masterPic).into(hodler.icon);
                break;
            case item_type_two:
                TypeTwoViewHodler hodler1 = null;
                if (convertView == null) {
                    hodler1 = new TypeTwoViewHodler();
                    convertView = View.inflate(context, R.layout.item_type_two, null);
                    hodler1.icon = convertView.findViewById(R.id.icon);
                    hodler1.name = convertView.findViewById(R.id.name);
                    convertView.setTag(hodler1);
                } else {
                    hodler1 = (TypeTwoViewHodler) convertView.getTag();
                }
                // 赋值
                HomeBean.ShopInfo shopInfo1 = homeBean.result.pzsh.commodityList.get(position - 3);
                hodler1.name.setText(shopInfo1.commodityName);
                // Glide
                Glide.with(context).load(shopInfo1.masterPic).into(hodler1.icon);
                break;
        }

        return convertView;
    }

    class TypeOneViewHodler {
        TextView name;
        ImageView icon;
    }

    class TypeTwoViewHodler {
        TextView name;
        ImageView icon;
    }

    @Override
    public int getItemViewType(int position) {
        if (position < homeBean.result.rxxp.commodityList.size()) {
            return item_type_one;
        } else {
            return item_type_two;
        }
    }

    @Override
    public int getViewTypeCount() {
        return 3;
    }
}
