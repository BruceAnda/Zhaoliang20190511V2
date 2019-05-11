package cn.zhaoliang5156.zhaoliang20190511v2.net;

import android.os.AsyncTask;

import com.google.common.io.CharStreams;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Copyright (C), 2015-2019, 八维集团
 * Author: zhaoliang
 * Date: 2019/5/11 10:54 AM
 * Description: 单例模式封装网络工具类
 * 支持get请求
 * 支持post请求
 */
public class HttpUtil {
    private static final HttpUtil ourInstance = new HttpUtil();

    public static HttpUtil getInstance() {
        return ourInstance;
    }

    private HttpUtil() {
    }

    /**
     * get 请求数据
     *
     * @param url
     * @param callBack
     */
    public void doHttpGet(String url, final CallBack callBack) {
        new AsyncTask<String, Void, String>() {

            @Override
            protected String doInBackground(String... strings) {
                HttpURLConnection connection = null;
                try {
                    URL url1 = new URL(strings[0]);
                    connection = (HttpURLConnection) url1.openConnection();
                    connection.setConnectTimeout(5000);
                    connection.setReadTimeout(5000);
                    connection.setRequestMethod("GET");

                    if (connection.getResponseCode() == 200) {
                        return CharStreams.toString(new InputStreamReader(connection.getInputStream()));
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(String s) {
                callBack.onSuccess(s);
            }
        }.execute(url);
    }

    /**
     * post 请求数据
     *
     * @param url
     * @param phone
     * @param pwd
     * @param callBack
     */
    public void doHttpPost(String url, final String phone, final String pwd, final CallBack callBack) {
        new AsyncTask<String, Void, String>() {

            @Override
            protected String doInBackground(String... strings) {
                HttpURLConnection connection = null;
                try {
                    URL url1 = new URL(strings[0]);
                    connection = (HttpURLConnection) url1.openConnection();
                    connection.setConnectTimeout(5000);
                    connection.setReadTimeout(5000);
                    connection.setRequestMethod("POST");

                    // 插入参数
                    String body = "phone=" + URLEncoder.encode(phone) + "&pwd=" + URLEncoder.encode(pwd);
                    connection.setDoOutput(true);
                    connection.getOutputStream().write(body.getBytes());

                    if (connection.getResponseCode() == 200) {
                        return CharStreams.toString(new InputStreamReader(connection.getInputStream()));
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(String s) {
                callBack.onSuccess(s);
            }
        }.execute(url);
    }


}
