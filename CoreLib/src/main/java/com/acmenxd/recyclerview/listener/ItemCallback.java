package com.acmenxd.recyclerview.listener;

import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

/**
 * /**
 * Modify Author: weichyang
 * Date:   2018/6/8
 * Description:
 * item 单击 & 长按 事件回调
 */
public abstract class ItemCallback {
    
    // 当前开启长按事件, 解决事件冲突
    private boolean isLongEnabled = false;

    protected boolean isLongEnabled() {
        return isLongEnabled;
    }

    protected void setLongEnabled(boolean pLongEnabled) {
        isLongEnabled = pLongEnabled;
    }

    /**
     * item单击事件回调
     *
     * @param dataPosition 定位数据的position
     */
    public abstract void onClick(@NonNull RecyclerView.ViewHolder viewHolder, @IntRange(from = 0) int dataPosition);

    /**
     * item长按事件回调
     *
     * @param dataPosition 定位数据的position
     */
    public void onLongClick(@NonNull RecyclerView.ViewHolder viewHolder, @IntRange(from = 0) int dataPosition) {
    }
}

