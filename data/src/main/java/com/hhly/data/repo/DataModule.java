package com.hhly.data.repo;

import android.content.Context;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hhly.data.api.BaseApi;

import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 描    述：
 * 作    者：xul@13322.com
 * 时    间：2016/9/7
 */

@Module
public class DataModule {

    // OkHttp Constants
    public static final String RESPONSE_CACHE_FILE = "response_cache";
    public static final long RESPONSE_CACHE_SIZE = 10 * 1024 * 1024L;
    public static final long HTTP_CONNECT_TIMEOUT = 10L;
    public static final long HTTP_READ_TIMEOUT = 30L;
    public static final long HTTP_WRITE_TIMEOUT = 10L;

    //API地址
    public final String API_HOST_URL;

    Context context ;

    public DataModule(Context context, String apiHostUrl) {
        this.API_HOST_URL = apiHostUrl;
        this.context = context;
    }

    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder()
                .create();
    }

    @Provides
    @Singleton
    Cache provideOKHttpCache() {
        File cacheDir = new File(context.getCacheDir(), RESPONSE_CACHE_FILE);
        return new Cache(cacheDir, RESPONSE_CACHE_SIZE);
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(Cache cache) {
        return new OkHttpClient.Builder()
                .cache(cache)
                .connectTimeout(HTTP_CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .addNetworkInterceptor(new StethoInterceptor())
                .build();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient okHttpClient, Gson gson) {
        return new Retrofit.Builder()
                .baseUrl(API_HOST_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okHttpClient)
                .build();

    }

    @Provides
    @Singleton
    BaseApi provideBaseApi(Retrofit retrofit) {
        return retrofit.create(BaseApi.class);
    }

}
