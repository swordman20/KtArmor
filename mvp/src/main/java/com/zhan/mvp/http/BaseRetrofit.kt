package com.zhan.mvp.http

import com.zhan.mvp.KtArmor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 *  @author:  hyzhan
 *  @date:    2019/7/10
 *  @desc:    TODO
 */
object BaseRetrofit {

    fun init(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(KtArmor.retrofit.baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(KtArmor.retrofit.initOkHttpClient())
            .build()
    }
}