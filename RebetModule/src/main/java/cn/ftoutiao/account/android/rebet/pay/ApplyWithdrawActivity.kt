package cn.ftoutiao.account.android.rebet.pay

import android.view.View
import cn.ftoutiao.account.android.rebet.R
import com.component.activity.ToolbarBaseActivity
import kotlinx.android.synthetic.main.activity_apply_withdraw.*

/**
 * Author: yangweichao
 * Date:   2018/7/26 下午9:58
 * Description:  返现的账户主页
 */


class ApplyWithdrawActivity : ToolbarBaseActivity(), View.OnClickListener {

    override fun initLayout() {
        super.initLayout()
        setContentView(R.layout.activity_apply_withdraw)
    }

    override fun init() {
        super.init()
    }

    override fun initView() {
        super.initView()
    }

    override fun initListener() {
        super.initListener()
        rl_user_area.setOnClickListener(this)
    }


    override fun initValue() {
        super.initValue()
        setToolbarBg(R.color.colorPrimary)
        setDefaultTitle("申请提现")
    }


    override fun getActionBarId(): Int {
        return R.id.toolbar
    }

    override fun getActionBarTitleId(): Int {
        return R.id.actionbar_title
    }

    override fun getActionBarContainerId(): Int {
        return 0
    }

    override fun getActionBarIconId(): Int {
        return 0
    }

    override fun getActionBarActionId(): Int {
        return 0
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.rl_user_area -> {

                startActivity(AddWithDrawAccountActivity::class.java)
            }
        }
    }
}
