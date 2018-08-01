package com.component.model.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Unique;

import java.io.Serializable;

/**
 * 添加预算表
 */
@Entity(nameInDb = "tbl_budget")
public class BudgetBo implements Serializable {
    static final long serialVersionUID = 42L;
    @Id
    private Long id;

    public String aId; //账本id
    public String uid; //用户id

    public float amount;
    public String year;
    @Unique
    public String aDate;
    public String month;
    public String day;

    @Generated(hash = 1753632132)
    public BudgetBo(Long id, String aId, String uid, float amount, String year,
                    String aDate, String month, String day) {
        this.id = id;
        this.aId = aId;
        this.uid = uid;
        this.amount = amount;
        this.year = year;
        this.aDate = aDate;
        this.month = month;
        this.day = day;
    }

    @Generated(hash = 1996844102)
    public BudgetBo() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAId() {
        return this.aId;
    }

    public void setAId(String aId) {
        this.aId = aId;
    }

    public String getUid() {
        return this.uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public float getAmount() {
        return this.amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getYear() {
        return this.year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return this.month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return this.day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getADate() {
        return this.aDate;
    }

    public void setADate(String aDate) {
        this.aDate = aDate;
    }

}