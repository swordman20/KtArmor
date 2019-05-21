package com.zhan.mvp.widget.loading

import android.support.annotation.StringRes

/**
 *  @author: hyzhan
 *  @date:   2019/5/20
 *  @desc:   基础占位布局接口定义
 */
interface PlaceHolderView {

    /**
     *  没有数据
     *  显示空布局, 隐藏当前数据布局
     */
    fun triggerEmpty()

    /**
     *  网络错误
     *  显示一个网络错误的图标
     */
    fun triggerNetError()

    /**
     * 加载错误, 并显示错误信息
     */
    fun triggerError(@StringRes strRes: Int)

    /**
     * 加载错误, 并显示错误信息
     */
    fun triggerError(str: String)

    /**
     * 显示正在加载的状态
     */
    fun triggerLoading()

    /**
     * 数据加载成功,调用该方法时应该隐藏当前占位布局
     */
    fun triggerOk()

    /**
     * 该方法如果传入的isOk为True则为成功状态，
     * 此时隐藏布局，反之显示空数据布局
     *
     * @param isOk 是否加载成功数据
     */
    fun triggerOkOrEmpty(isOk: Boolean)
}