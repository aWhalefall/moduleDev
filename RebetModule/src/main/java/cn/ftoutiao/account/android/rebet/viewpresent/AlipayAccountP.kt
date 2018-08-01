package cn.ftoutiao.account.android.rebet.viewpresent

import com.acmenxd.retrofit.exception.HttpException
import com.acmenxd.toaster.Toaster
import com.component.activity.BasePresenter
import com.component.model.NullEntity

/**
 * Author: yangweichao
 * Date:   2018/7/30 下午5:46
 * Description:  请求service
 */


class AlipayAccountP(pView: AlipayAccountContract.View?) :
        BasePresenter<AlipayAccountContract.View>(pView), AlipayAccountContract.Presenter {

    override fun addAccount(account: String, alias: String) {
        request().addAlipayAccount("", account, alias).enqueue(object : BindCallback<NullEntity>() {
            override fun succeed(pData: NullEntity) {
                super.succeed(pData)
            }

            override fun failed(pE: HttpException) {
                super.failed(pE)
                Toaster.show(pE.msg)
            }
        })

    }


}