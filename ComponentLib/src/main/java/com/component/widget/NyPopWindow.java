package com.component.widget;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.acmenxd.logger.Logger;

import java.util.List;

import com.ftoutiao.component.R;

/**
 * Author: yangweichao
 * Date:  2016/6/15.
 * Description: 通用弹窗
 */


public class NyPopWindow extends PopupWindow {

    private Context context;
    /**
     * 展示列表
     */
    private List<String> titles;
    /**
     * 图标
     */
    private List<Integer> drawables;
    /**
     * 依附于view
     */
    private View anchorView;
    private PopWindowLayout popUpwindowLayout;
    private View contentView;


    /**
     * 构造方式
     *
     * @param context
     * @param anchorView
     */
    public NyPopWindow(Context context, View anchorView, List<String> titles) {
        super(context, null);
        this.titles = titles;
        this.context = context;
        this.anchorView = anchorView;
        initPopWindowParameter();
    }

    public NyPopWindow(Context context, View anchorView, List<String> titles, List<Integer> drawable) {
        super(context, null);
        this.titles = titles;
        this.drawables = drawable;
        this.context = context;
        this.anchorView = anchorView;
        initPopWindowParameter();
    }

    private void initPopWindowParameter() {

        contentView = LayoutInflater.from(context).inflate(R.layout.view_popupwindow, null);

        this.setContentView(contentView);
        this.setWidth(LinearLayout.LayoutParams.WRAP_CONTENT);
        this.setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
        this.setFocusable(true);

        popUpwindowLayout = contentView.findViewById(R.id.llayout_popupwindow);
        if (drawables.size() > 0) {
            popUpwindowLayout.initViews(context, titles, drawables);
        } else {
            popUpwindowLayout.initViews(context, titles);
        }

        contentView.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        // 允许点击外部消失
        this.setBackgroundDrawable(new BitmapDrawable());
        this.setOutsideTouchable(true);
        this.setAnimationStyle(R.style.popwindow_anim_style);
    }


    /**
     * 设置显示位置
     *
     * @param anchorView
     */
    public void showVpAsDropDown(View anchorView) {
        this.showAsDropDown(anchorView);
    }

    /**
     * 显示偏移量
     *
     * @param anchorView
     * @param x
     * @param y
     */
    public void showVpAsDropDown(View anchorView, int x, int y) {
        int[] location = new int[2];
        anchorView.getLocationOnScreen(location);
        this.showAsDropDown(anchorView, x, y);
    }

    /**
     * 设置点击监听
     *
     * @param onItemClick
     */
    public void setOnItemClick(PopWindowLayout.OnClickCallback onItemClick) {
        if (popUpwindowLayout == null) {
            popUpwindowLayout = (PopWindowLayout) contentView.findViewById(R.id.llayout_popupwindow);
        }
        popUpwindowLayout.setClickListener(onItemClick);
    }

    /**
     * 设置默认选中项
     *
     * @param index
     */
    public void itemSelected(int index) {
        if (popUpwindowLayout != null) {
            popUpwindowLayout.setSelectedIndex(index);
        } else {
            Logger.e("popUpWindowLayout is null");
        }
    }
}
