package cn.ftoutiao.account.android.rebet.viewpresent

import com.acmenxd.frame.basis.BasePresenter
import com.acmenxd.frame.basis.BaseView
import com.component.model.UserEntity

/**
 * Author: yangweichao
 * Date:   2018/7/30 下午5:18
 * Description: 添加支付宝账户
 */

interface AlipayAccountContract {

    interface View : BaseView {

        fun addAlipayAccountSuccess(result: UserEntity)

        fun addAlipayAccountFailed(msg: String)

    }

    interface Presenter : BasePresenter {

        fun addAccount(account: String, alias: String)

    }
}