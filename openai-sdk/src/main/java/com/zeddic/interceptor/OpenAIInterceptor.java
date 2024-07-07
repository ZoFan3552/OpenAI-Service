package com.zeddic.interceptor;

import cn.hutool.http.ContentType;
import cn.hutool.http.Header;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import java.io.IOException;

public class OpenAIInterceptor implements Interceptor {
    private final String apiKey;

    public OpenAIInterceptor(String apiKey) {
        this.apiKey = apiKey;
    }

    @Override
    @NotNull
    public Response intercept(Chain chain) throws IOException {
        return chain.proceed(this.buildRequest(apiKey , chain.request()));
    }

    private Request buildRequest(String apiKey , Request originalRequest) {
        //拦截原始请求,设置apiKey以及content-type为json
        return originalRequest.newBuilder()
                .url(originalRequest.url())
                .header(Header.AUTHORIZATION.getValue() , "Bearer " + apiKey)
                .header(Header.CONTENT_TYPE.getValue(), ContentType.JSON.getValue())
                .method(originalRequest.method() , originalRequest.body())
                .build();
    }
}
