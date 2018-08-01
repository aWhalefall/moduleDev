package com.component.model.evenbus;

/**
 * Created by weichyang on 2018/4/11.
 */

public class RefreshBillTem {
    public String aid;
    public int localDate;

    public RefreshBillTem(String aid) {
        this.aid = aid;
    }

    public RefreshBillTem(String aid, int localDate) {
        this.aid = aid;
        this.localDate = localDate;
    }
}
