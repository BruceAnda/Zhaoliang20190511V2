package cn.zhaoliang5156.zhaoliang20190511v2.ui.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONObject;

import cn.zhaoliang5156.zhaoliang20190511v2.R;
import cn.zhaoliang5156.zhaoliang20190511v2.mvp.user.IUserContract;
import cn.zhaoliang5156.zhaoliang20190511v2.mvp.user.UserPresenterImpl;

/**
 * Copyright (C), 2015-2019, 八维集团
 * Author: zhaoliang
 * Date: 2019/5/11 10:13 AM
 * Description:  登录注册页面 V
 */
public class ReigstAndLoginActivity extends AppCompatActivity implements IUserContract.IUserView {

    private EditText etUsername;
    private EditText etPassword;
    private CheckBox cbRemeberMe;

    private Button btnReigst;
    private Button btnLogin;

    private IUserContract.IUserPresenter userPresenter;

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist_and_login);

        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        cbRemeberMe = findViewById(R.id.cb_remember_me);

        btnReigst = findViewById(R.id.btn_regist);
        btnLogin = findViewById(R.id.btn_login);

        btnReigst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 注册
                userPresenter.regist(etUsername.getText().toString(), etPassword.getText().toString());
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 登录
                userPresenter.login(etUsername.getText().toString(), etPassword.getText().toString());
            }
        });

        // 实例化 user p
        userPresenter = new UserPresenterImpl();
        // 绑定
        userPresenter.attach(this);

        sharedPreferences = getSharedPreferences("user", MODE_PRIVATE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        userPresenter.detach();
    }

    @Override
    public void onRegistSuccess(String result) {
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginSuccess(String result) {
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();

        String phone = sharedPreferences.getString("phone", "");
        if (TextUtils.isEmpty(phone)) {
            sharedPreferences.edit().putString("phone", etUsername.getText().toString()).commit();
        }

        startActivity(new Intent(this, MainActivity.class));
    }
}
