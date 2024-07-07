package com.zeddic.session.factory;

import com.zeddic.IOpenAIAPI;
import com.zeddic.interceptor.OpenAIInterceptor;
import com.zeddic.session.DefaultOpenAISession;
import com.zeddic.session.OpenAISession;
import com.zeddic.session.config.OpenAISessionConfig;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.util.concurrent.TimeUnit;

public class DefaultOpenAISessionFactory implements OpenAISessionFactory {

    private final OpenAISessionConfig config;

    public DefaultOpenAISessionFactory(OpenAISessionConfig config) {
        this.config = config;
    }

    @Override
    public OpenAISession createSession() {
        // 1. 日志配置
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS);

        // 2. 开启 Http 客户端
        OkHttpClient okHttpClient = new OkHttpClient
                .Builder()
                .addInterceptor(httpLoggingInterceptor)
                .addInterceptor(new OpenAIInterceptor(config.getApiKey()))
                .connectTimeout(450, TimeUnit.SECONDS)
                .writeTimeout(450, TimeUnit.SECONDS)
                .readTimeout(450, TimeUnit.SECONDS)
                //.proxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1", 21284)))
                .build();

        // 3. 创建 API 服务
        IOpenAIAPI api = new Retrofit.Builder()
                .baseUrl(config.getApiHost())
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(JacksonConverterFactory.create())
                .build().create(IOpenAIAPI.class);

        return new DefaultOpenAISession(api);

    }
}
