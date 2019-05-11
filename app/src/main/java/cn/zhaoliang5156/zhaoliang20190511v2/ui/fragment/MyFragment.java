package cn.zhaoliang5156.zhaoliang20190511v2.ui.fragment;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cn.zhaoliang5156.zhaoliang20190511v2.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment extends Fragment {

    private TextView tvPhone;
    private SharedPreferences sharedPreferences;

    public MyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_my, container, false);

        tvPhone = inflate.findViewById(R.id.tv_phone);

        sharedPreferences = getActivity().getSharedPreferences("user", Context.MODE_PRIVATE);
        String phone = sharedPreferences.getString("phone", "");

        tvPhone.setText(phone);

        return inflate;
    }

}
