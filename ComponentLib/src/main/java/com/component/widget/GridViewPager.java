package com.component.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;

import com.acmenxd.frame.utils.Utils;
import com.acmenxd.logger.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.component.model.db.CategoryEntity;
import com.ftoutiao.component.R;

/**
 * Created by liumeng on 10/30/15.
 * blog: https://github.com/MasonLiuChn/GridViewPager
 * 测量gridView 动态生成gridView，更具
 */
public class GridViewPager<T extends ListAdapter> extends ViewPager {
    private T t;
    private List<GridView> mLists = new ArrayList<>();
    private GridViewPagerAdapter adapter;
    private List<CategoryEntity> listAll = new ArrayList();
    Map<Integer,T> adapterMap; //缓存adapter

    private int rowInOnePage;
    private int columnInOnePage;
    private GridViewPagerDataAdapter gridViewPagerDataAdapter;

    public GridViewPager(Context context) {
        super(context);
    }

    public GridViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public GridViewPagerDataAdapter getGridViewPagerDataAdapter() {
        return gridViewPagerDataAdapter;
    }
    public void setGridViewPagerDataAdapter(GridViewPagerDataAdapter gridViewPagerDataAdapter) {
        this.gridViewPagerDataAdapter = gridViewPagerDataAdapter;
        if (gridViewPagerDataAdapter.listAll == null || gridViewPagerDataAdapter.listAll.size() == 0) {
            return;
        }
        listAll = gridViewPagerDataAdapter.listAll;
        rowInOnePage = gridViewPagerDataAdapter.rowInOnePage; //行
        columnInOnePage = gridViewPagerDataAdapter.columnInOnePage;
        init();
    }

    public void addData(List<CategoryEntity> list) {
        if (listAll.size() > 0) {
            listAll.clear();
        }
        listAll.addAll(list);
    }

    public void init() {
        final int sizeInOnePage = rowInOnePage * columnInOnePage;
        int pageCount = listAll.size() / sizeInOnePage;
        pageCount += listAll.size() % sizeInOnePage == 0 ? 0 : 1;

        //一个页面一个GridView
        if (mLists.size() > pageCount) {
            for (int i = mLists.size() - 1; i >= pageCount; i--) {
                mLists.remove(i);
            }
        }

        WrapContentGridView gv;
        int end;
        //缓存adapter
        Map<Integer,T > adapterMap = new HashMap<>();

        for (int i = 0; i < pageCount; i++) {
            final int pageIndex = i;
            if (i < mLists.size()) {
                gv = (WrapContentGridView) mLists.get(i);
            } else {
                gv = new WrapContentGridView(getContext());
                gv.setGravity(Gravity.CENTER);
                int space = (int) Utils.dp2px(getContext(), 28);
                gv.setVerticalSpacing(space / 2);
                gv.setPadding(space / 2, space / 2, space / 2, space / 2);
                gv.setHorizontalSpacing(space);
                gv.setSelector(R.color.transparent);
                gv.setClickable(true);
                gv.setFocusable(true);
                mLists.add(gv);
            }
            gv.setNumColumns(columnInOnePage);
            //每屏幕一次，直到结束
            end = Math.min((i + 1) * sizeInOnePage, listAll.size());
            final T adapter = ((T) gridViewPagerDataAdapter.
                    getGridViewAdapter(listAll.subList(i * sizeInOnePage, end), i));
            adapterMap.put(sizeInOnePage, adapter);
            gv.setAdapter(adapter);

            gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                    gridViewPagerDataAdapter.onItemClick(arg0, arg1, arg2, arg3, pageIndex, sizeInOnePage, adapter);

                    Logger.d("pageindex =" + pageIndex + "   adapter" + adapter);
                }
            });
        }
        adapter = new GridViewPagerAdapter(getContext(), mLists);
        setAdapter(adapter);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int height = 0;
        for (int i = 0; mLists != null && i < mLists.size(); i++) {
            View child = mLists.get(i);
            child.measure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
            int h = child.getMeasuredHeight();
            if (h > height)
                height = h;
        }
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(height + getPaddingBottom() + getPaddingTop(), MeasureSpec.EXACTLY);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public Map<Integer, T> getAdapterMap() {
        return adapterMap == null ? new HashMap<Integer, T>() : adapterMap;
    }
}
