package cn.ftoutiao.account.android.rebet.pay

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import cn.ftoutiao.account.android.rebet.R
import cn.ftoutiao.account.android.rebet.viewpresent.AlipayAccountP
import cn.ftoutiao.account.android.rebet.viewpresent.AlipayAccountContract
import com.component.activity.ToolbarBaseActivity
import com.component.model.UserEntity
import kotlinx.android.synthetic.main.activity_add_with_draw_account.*

/**
 * Author: yangweichao
 * Date:   2018/7/26 下午9:57
 * Description: 添加返现账户
 */


class AddWithDrawAccountActivity : ToolbarBaseActivity(), View.OnClickListener, TextWatcher, AlipayAccountContract.View {


    override fun initLayout() {
        super.initLayout()
        setContentView(R.layout.activity_add_with_draw_account)
    }

    private lateinit var alipayAccountP: AlipayAccountP

    override fun init() {
        super.init()
        alipayAccountP = AlipayAccountP(this);
        addPresenters(alipayAccountP)
    }

    override fun initView() {
        super.initView()

    }

    override fun initListener() {
        super.initListener()
        et_phone.addTextChangedListener(this)
        et_pwd.addTextChangedListener(this)
        btn_add_alipay_account.setOnClickListener(this)
    }


    override fun initValue() {
        super.initValue()
        setToolbarBg(R.color.colorPrimary)
        setDefaultTitle("添加支付宝")
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
            R.id.btn_add_alipay_account -> {
                var alipay_alias = et_pwd.text.toString().trim()
                var alipay_account = et_phone.text.toString().trim()
                alipayAccountP.addAccount(alipay_account, alipay_alias);
            }
        }
    }


    override fun afterTextChanged(s: Editable?) {
        btn_add_alipay_account.isEnabled = et_phone.length() > 0 && et_pwd.length() > 0
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
    }

    override fun addAlipayAccountSuccess(result: UserEntity) {
        // TODO: 2018/7/30
    }

    override fun addAlipayAccountFailed(msg: String) {
    }

}
