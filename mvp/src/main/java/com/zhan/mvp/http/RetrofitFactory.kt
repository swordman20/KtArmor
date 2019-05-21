package com.zhan.mvp.http

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.zhan.mvp.config.API
import com.zhan.mvp.config.Setting
import com.zhan.mvp.http.intercept.LoggingIntercept
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 *  @author: hyzhan
 *  @date:   2019/5/17
 *  @desc:   TODO
 */
class RetrofitFactory private constructor() {

    companion object {
        val newInstance by lazy { RetrofitFactory() }
    }

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
                .baseUrl(API.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .client(initOkHttpClient())
                .build()
    }

    // 初始化 okHttp
    private fun initOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor(LoggingIntercept.init())
                .readTimeout(Setting.READ_TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(Setting.WRITE_TIME_OUT, TimeUnit.SECONDS)
                .connectTimeout(Setting.CONNECT_TIME_OUT, TimeUnit.SECONDS)
                .build()
    }

    fun <T> create(clz: Class<T>): T {
        return retrofit.create(clz)
    }
}