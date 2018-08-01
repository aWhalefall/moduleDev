package com.component.dbdao.migrator;


import org.greenrobot.greendao.database.Database;

import com.component.dbdao.core.MigrationHelperUtil;
import com.component.dbdao.dao.BudgetBoDao;
import com.component.dbdao.dao.CategoryEntityDao;
import com.component.dbdao.dao.ListItemBODao;

/**
 * 数据库升级
 * 版本号对应着升级的号码。
 */
public class MigratorHelper2 extends BaseMigratorHelper {

    private final String TAG = this.getClass().getSimpleName();

    @Override
    public void onUpgrade(Database db) {
        //更新数据库表结构
        MigrationHelperUtil.getInstance().migrate(db, new DefaultCallback() {
            @Override
            public String onText(String tablename, String columnName) {
                return null;
            }

            public Long onInteger(String tablename, String columnName) {
                return null;
            }

            @Override
            public Double onReal(String tablename, String columnName) {
                return null;
            }

            @Override
            public Boolean onBoolean(String tablename, String columnName) {
                return null;
            }
        }, CategoryEntityDao.class, ListItemBODao.class, BudgetBoDao.class);
    }
}