package cn.ftoutiao.account.android.rebet

import android.content.Context
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.OrientationHelper
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import com.acmenxd.recyclerview.adapter.SimpleAdapter
import com.acmenxd.recyclerview.delegate.ViewHolder
import com.acmenxd.recyclerview.listener.AddItemListener
import com.acmenxd.recyclerview.listener.ItemCallback
import com.alibaba.android.arouter.facade.annotation.Route
import com.component.activity.BaseFragment
import com.component.model.db.ListItemBO
import com.component.router.PathConfig
import com.component.router.delegate.RebateFragmentDelegate
import kotlinx.android.synthetic.main.activity_rebate.*


/**
 * Author: yangweichao
 * Date:   2018/7/13 上午10:36
 * Description: 返利三方接入
 */


@Route(path = PathConfig.BILL_FRAGMENT_REBATE)
class RebateFragment : BaseFragment(), RebateFragmentDelegate {


    override fun setContainerId(id: Int) {
        mContainerId = id
    }


    override fun init(context: Context) {

    }

    private var mContainerId: Int = 0


    override val fragment: BaseFragment
        get() = this


    override fun onCreateView(inflater: LayoutInflater, savedInstanceState: Bundle): View {
        super.onCreateView(inflater, savedInstanceState)
        return inflater.inflate(R.layout.activity_rebate, null)
    }


    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initListener()
        initValue()
    }

    protected fun initView() {
    }

    protected fun initListener() {

        AddItemListener(recycleView, itemCallback)
    }


    private lateinit var listItem: ArrayList<ListItemBO>

    private lateinit var simpleAdapter: SimpleAdapter<ListItemBO>

    protected fun initValue() {
        topbar.setTopbarLeftLayoutHide()
        topbar.setTopbarTitle(resources.getString(R.string.fintace_rebate))


        listItem = ArrayList<ListItemBO>()
        listItem.add(ListItemBO())
        listItem.add(ListItemBO())
        listItem.add(ListItemBO())
        listItem.add(ListItemBO())

        val gridLayoutManager = GridLayoutManager(mActivity, 3)
        gridLayoutManager.offsetChildrenVertical(10)
        gridLayoutManager.orientation = OrientationHelper.VERTICAL
        recycleView.setLayoutManager(gridLayoutManager)

        // 设置数据Adapter
        simpleAdapter = object : SimpleAdapter<ListItemBO>(R.layout.item_rebate_gridview, listItem) {
            override fun convert(viewHolder: ViewHolder, item: ListItemBO, dataPosition: Int) {
                if (dataPosition >= 0) {

                }
            }
        }
        recycleView.setAdapter(simpleAdapter)

        initRecycle()
    }

    private fun initRecycle() {

        val linearLayoutManager = LinearLayoutManager(mActivity)
        linearLayoutManager.offsetChildrenVertical(10)
        linearLayoutManager.orientation = OrientationHelper.VERTICAL
        recycleView_list.setLayoutManager(linearLayoutManager)

        // 设置数据Adapter
       val simpleAdapter = object : SimpleAdapter<ListItemBO>(R.layout.item_credit_card, listItem) {
            override fun convert(viewHolder: ViewHolder, item: ListItemBO, dataPosition: Int) {
                if (dataPosition >= 0) {

                }
            }
        }
        recycleView_list.setAdapter(simpleAdapter)
    }

    val itemCallback = object : ItemCallback() {
        override fun onClick(viewHolder: RecyclerView.ViewHolder, dataPosition: Int) {
            startActivity(MineRebateActivity::class.java)
        }
    }


}
