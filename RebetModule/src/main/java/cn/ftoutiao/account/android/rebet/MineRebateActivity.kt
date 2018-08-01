package cn.ftoutiao.account.android.rebet

import android.view.View
import cn.ftoutiao.account.android.rebet.pay.ApplyWithdrawActivity
import com.component.activity.ToolbarBaseActivity
import kotlinx.android.synthetic.main.activity_mine_rebate.*

/**
 * Author: yangweichao
 * Date:   2018/7/26 下午9:58
 * Description: 我的返现
 */


class MineRebateActivity : ToolbarBaseActivity(), View.OnClickListener {


    override fun initLayout() {
        setContentView(R.layout.activity_mine_rebate)

    }

    override fun initView() {
        super.initView()
    }

    override fun initListener() {
        super.initListener()
        button.setOnClickListener(this)
    }

    override fun initValue() {
        super.initValue()
        setToolbarBg(R.color.colorPrimary)
        setDefaultTitle("申请返现")
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
            R.id.button -> {
                startActivity(ApplyWithdrawActivity::class.java)
            }
        }
    }
}
