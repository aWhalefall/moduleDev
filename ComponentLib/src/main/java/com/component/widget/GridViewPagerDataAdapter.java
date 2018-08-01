package com.component.widget;

import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;

import java.util.ArrayList;
import java.util.List;


public abstract class GridViewPagerDataAdapter<T> {
    protected List<T> listAll;
    protected int rowInOnePage;
    protected int columnInOnePage;

    public GridViewPagerDataAdapter(List<T> listAll, int rowInOnePage, int columnInOnePage) {
        this.listAll = listAll;
        this.rowInOnePage = rowInOnePage;
        this.columnInOnePage = columnInOnePage;
    }

    public abstract BaseAdapter getGridViewAdapter(List<T> currentList, int pageIndex);

    public void addData(List<T> list) {
        if (listAll == null) {
            listAll = new ArrayList<>();
        }
        listAll = list;

    }

    public abstract void onItemClick(
            AdapterView parent,
            View view,
            int position,
            long id,
            int pageIndex,
            int sizeInOnePage,
            ListAdapter currentAdapter);
}
