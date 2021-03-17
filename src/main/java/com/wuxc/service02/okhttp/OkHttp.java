package com.wuxc.service02.okhttp;

import com.alibaba.fastjson.JSONObject;
import com.wuxc.service02.bulider.UrlParamsBuilder;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class OkHttp {
    private static final Logger logger = LoggerFactory.getLogger(OkHttp.class);

    public static JSONObject okHttp(String method, String fullUrl, UrlParamsBuilder builder) {
        Request requestHttp;
        if ("get".equals(method)) {

            requestHttp = get(fullUrl);


        } else {
            requestHttp = post(fullUrl, builder);
        }
        String result = Call(requestHttp);
//        logger.warn(result);

        JSONObject result_json = null;
        try {
            result_json = JSONObject.parseObject(result);
        } catch (Exception e) {
            logger.warn("catch ", e);
        }
        return result_json;
    }

    private static String Call(Request request) {
        OkHttpClient okHttpClient = new OkHttpClient();
        Call call = okHttpClient.newCall(request);
        try {
            Response response = call.execute();

            if (response.isSuccessful()) {
                ResponseBody body = response.body();
                String result = body.string();
//                  logger.warn("body is {}", result);
                //logger.warn("message is {}", response.message());
                return result;
            }

        } catch (IOException e) {
            logger.warn("catch a exception is {}", e);


        } catch (Exception w1) {
            logger.warn("catch a exception is {}", w1);
        }
        return null;
    }

    public static Request get(String url) {
        //     logger.warn("url is {}", url);
        return new Request.Builder().url(url)
                .addHeader("Content-Type", "application/x-www-form-urlencoded").build();
    }

    private static Request post(String url, UrlParamsBuilder builder) {
        //  logger.warn("url is {}", url);

        return new Request.Builder().url(url).post(builder.buildPostBody())
                .addHeader("Content-Type", "application/json").build();
    }
}
