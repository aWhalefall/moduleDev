package com.component.dbdao;

import android.database.sqlite.SQLiteDatabase;

import org.greenrobot.greendao.query.Query;

import java.util.ArrayList;
import java.util.List;

import com.component.dbdao.core.DBManager;
import com.component.dbdao.dao.BudgetBoDao;
import com.component.dbdao.dao.DaoSession;
import com.component.model.db.BudgetBo;

/**
 * Author: weichyang
 * Date:   2018/6/6
 * Description:
 * 添加预算
 */

public final class BudgetBillDB {

    private static BudgetBillDB instance;
    private SQLiteDatabase db;
    private DaoSession ds;
    private BudgetBoDao budgetBoDao;

    private BudgetBillDB() {
        db = DBManager.getInstance().getDatabase();
        ds = DBManager.getInstance().getDaoSession();
        budgetBoDao = ds.getBudgetBoDao();
    }

    public static BudgetBillDB getInstance() {
        if (instance == null) {
            instance = new BudgetBillDB();
        }
        return instance;
    }


    /**
     * 添加预算
     *
     * @param budgetBo
     */
    public void addBudget(BudgetBo budgetBo) {
        budgetBoDao.insertOrReplace(budgetBo);
    }

    /**
     * @param aid 类别
     * @return
     */
    public List<BudgetBo> queryBudget(String aid) {
        Query<BudgetBo> query = budgetBoDao.queryBuilder()
                .where(BudgetBoDao.Properties.AId.eq(aid)).
                        orderDesc(BudgetBoDao.Properties.ADate)
                .build();
        return query.list().size() == 0 ? new ArrayList<BudgetBo>() : query.list();
    }

    public BudgetBo queryBudget(String currentAid, String currentYear, String currentMonth) {
        Query<BudgetBo> query = budgetBoDao.queryBuilder()
                .where(BudgetBoDao.Properties.AId.eq(currentAid),
                        BudgetBoDao.Properties.Year.eq(currentYear),
                        BudgetBoDao.Properties.Month.eq(currentMonth)).
                        orderDesc(BudgetBoDao.Properties.ADate)
                .build();
        if (query.list().size() <= 0) {
            return null;
        }

        return query.list().get(0);

    }
}
