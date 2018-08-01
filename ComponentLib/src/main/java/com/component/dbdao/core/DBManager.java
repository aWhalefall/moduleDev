package com.component.dbdao.core;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;


import com.component.activity.AppConfig;
import com.component.activity.BaseApp;
import com.component.dbdao.dao.DaoMaster;
import com.component.dbdao.dao.DaoSession;


/**
 * @author AcmenXD
 * @version v1.0
 * @github https://github.com/AcmenXD
 * @date 2017/2/28 10:00
 * @detail 数据库管理
 */
public class DBManager {
    private final String TAG = this.getClass().getSimpleName();
    private static final String DB_NAME = AppConfig.config.DB_NAME; //数据库名字
    private static DBManager instance;

    private DBManager() {
    }

    public static DBManager getInstance() {
        if (instance == null) {
            instance = new DBManager();
        }
        return instance;
    }

    private boolean mInited = false; //是否初始化过
    private Context mContext = null;//上下文对象
    /**
     * 数据库操作
     */
    private DaoMaster.OpenHelper mOpenHelper = null;
    private SQLiteDatabase mDatabase = null;
    private DaoMaster mDaoMaster = null;
    private DaoSession mDaoSession = null;

    /**
     * 初始化数据库
     */
    public final void init() {
        if (!mInited || mContext == null) {
            this.mContext = BaseApp.getInstance().getApplicationContext();
            mOpenHelper = new DBOpenHelper(mContext, DB_NAME, null);
            mDatabase = mOpenHelper.getWritableDatabase();
            mDaoMaster = new DaoMaster(mDatabase);
            mDaoSession = mDaoMaster.newSession();
        }
    }

    public SQLiteDatabase getDatabase() {
        return mDatabase;
    }

    public DaoSession getDaoSession() {
        return mDaoSession;
    }
}
