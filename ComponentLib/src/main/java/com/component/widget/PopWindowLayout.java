package com.component.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.acmenxd.frame.utils.Utils;

import java.util.ArrayList;
import java.util.List;

import com.ftoutiao.component.R;


/**
 * Created by weichyang on 2016/6/14.
 * 弹窗view
 */
public class PopWindowLayout extends LinearLayout {

    private Context mContext;
    private OnClickCallback mCallback;
    private List<TextView> txtViewList;
    private List<Integer> drawables = new ArrayList<>();


    public PopWindowLayout(Context context) {
        this(context, null);
    }

    public PopWindowLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PopWindowLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setOrientation(VERTICAL);
        setBackgroundResource(R.drawable.bmap_bg);
        init();
    }

    private void init() {
        txtViewList = new ArrayList<>();

    }

    /**
     * 设置标题内容
     *
     * @param context
     * @param titles  标题文字内容
     */
    public void initViews(Context context, List<String> titles) {
        initViews(context, titles, false);
    }

    public void initViews(Context context, List<String> titles, List<Integer> drawables) {
        this.drawables = drawables;
        initViews(context, titles, false);
    }

    /**
     * 设置标题内容
     *
     * @param context
     * @param titles  标题文字内容
     * @param hasDraw 是否带右侧向下箭头
     */
    public void initViews(Context context, List<String> titles, boolean hasDraw) {
        this.mContext = context;
        setLayoutContent(mContext, titles, hasDraw);
    }

    /**
     * 设置条目点击监听
     */
    public void setClickListener(OnClickCallback callback) {
        this.mCallback = callback;
    }

    /**
     * 设置内容
     *
     * @param context
     * @param titles
     * @param hasDraw
     */
    private void setLayoutContent(Context context, final List<String> titles, boolean hasDraw) {
        removeAllViews();
        if (titles != null && titles.size() > 0) {
            // 不带箭头
            if (!hasDraw) {
                for (int i = 0; i < titles.size(); i++) {
                    final int index = i;
                    final TextView textView = new TextView(context);
                    textView.setCompoundDrawablesWithIntrinsicBounds(drawables.get(i), 0, 0, 0);
                    textView.setCompoundDrawablePadding(5);
                    // 文本
                    textView.setText(titles.get(i));
                    // 颜色
                    float titleSize = getContext().getResources().getDimension(R.dimen.sp_14);
                    // 字体
                    textView.setTextSize(Utils.px2dp(context, titleSize));
                    textView.setGravity(Gravity.CENTER);
                    textView.setPadding(20, 0, 20, 0);
                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                            LayoutParams.MATCH_PARENT, (int) Utils.dp2px(context, 35), Gravity.CENTER);
                    params.gravity = Gravity.CENTER;
                    textView.setLayoutParams(params);
                    textView.setTextColor(createColorStateList(0xffffffff, 0xffb6b6b6, 0xffffffff, 0xffffffff));
                    textView.setBackgroundDrawable(getResources().getDrawable(R.drawable.investment_pop_selector));
                    addView(textView);
                    // addDividingLine(context, titles, i);
                    textView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (mCallback != null) {
                                mCallback.onItemClick(PopWindowLayout.this, titles.size(), index);
                            }
                        }
                    });
                    // TODO: 2016/6/22 避免重复添加
                    if (i == 0) {
                        txtViewList.clear();
                        txtViewList.add(textView);
                    } else {
                        txtViewList.add(textView);
                    }
                }
            }
        } else {
            throw new RuntimeException("title counts is less than 0");
        }
    }

    /**
     * 增加中间分割线
     *
     * @param context
     * @param titles
     * @param i
     */
    private void addDividingLine(Context context, List<String> titles, int i) {
        if (i < titles.size() - 1) {
            LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 1);
            layoutParams.gravity = Gravity.CENTER_VERTICAL;
            View view = new View(context);
            view.setLayoutParams(layoutParams);
            view.setBackgroundResource(R.color.text_gray);
            addView(view);
        }
    }

    /**
     * http://blog.csdn.net/abc6368765/article/details/51482317
     *
     * @param normal
     * @param pressed
     * @param focused
     * @param unable
     * @return
     */
    private ColorStateList createColorStateList(int normal, int pressed, int focused, int unable) {
        int[] colors = new int[]{pressed, focused, normal, focused, unable, normal};
        int[][] states = new int[6][];
        states[0] = new int[]{android.R.attr.state_pressed, android.R.attr.state_enabled};
        states[1] = new int[]{android.R.attr.state_enabled, android.R.attr.state_focused};
        states[2] = new int[]{android.R.attr.state_enabled};
        states[3] = new int[]{android.R.attr.state_focused};
        states[4] = new int[]{android.R.attr.state_window_focused};
        states[5] = new int[]{};
        ColorStateList colorList = new ColorStateList(states, colors);
        return colorList;
    }

    /**
     * 点击事件接口
     */
    public interface OnClickCallback {
        /**
         * 点击子视图时调用
         *
         * @param parentView 当前操作的View视图
         * @param size       当前视图中子视图数量
         * @param index      当前点击子视图索引
         */
        void onItemClick(LinearLayout parentView, int size, int index);
    }

    /**
     * 选中
     *
     * @param index
     */
    public void setSelectedIndex(int index) {
        if (!txtViewList.isEmpty())
            for (int i = 0; i < txtViewList.size(); i++) {
                if (i == index) {
                    txtViewList.get(i).setPressed(true);
                } else {
                    txtViewList.get(i).setPressed(false);
                }
            }
    }

}
