package com.component.widget

import android.support.annotation.IdRes

/**
 * Created by alan on 2017/11/4.
 */
interface IActionBarResIdProvider {

    @IdRes
    fun getActionBarId(): Int

    @IdRes
    fun getActionBarTitleId(): Int

    @IdRes
    fun getActionBarContainerId(): Int

    @IdRes
    fun getActionBarIconId(): Int

    @IdRes
    fun getActionBarActionId(): Int
}