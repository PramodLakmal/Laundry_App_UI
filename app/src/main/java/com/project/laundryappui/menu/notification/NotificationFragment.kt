package com.project.laundryappui.menu.notification

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.laundryappui.R
import com.project.laundryappui.menu.notification.adapter.NotificationAdapter
import com.project.laundryappui.menu.notification.model.NotificationModel

class NotificationFragment : Fragment() {
    private var mContext: Context? = null
    private var recyclerView: RecyclerView? = null
    private var layoutManager: LinearLayoutManager? = null
    private var notificationAdapter: NotificationAdapter? = null
    private var notificationModelList: MutableList<NotificationModel>? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_notification, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAdapterType(view)
        setAdapter()
    }

    private fun initData() {
        notificationModelList = ArrayList()
        (notificationModelList as ArrayList<NotificationModel>).add(
            NotificationModel(
                R.drawable.ic_box,
                "Order No : #73636265",
                "Order Confirmed"
            )
        )
        (notificationModelList as ArrayList<NotificationModel>).add(
            NotificationModel(
                R.drawable.ic_box,
                "Order No : #63231323",
                "Order Confirmed"
            )
        )
    }

    private fun setAdapterType(view: View) {
        recyclerView = view.findViewById(R.id.recyclerview_order)
        layoutManager = LinearLayoutManager(mContext)
        recyclerView?.setHasFixedSize(true)
        recyclerView?.setLayoutManager(
            LinearLayoutManager(
                mContext,
                LinearLayoutManager.VERTICAL,
                false
            )
        )
        recyclerView?.isNestedScrollingEnabled = true
    }

    private fun setAdapter() {
        initData()
        notificationAdapter = NotificationAdapter(notificationModelList)
        recyclerView!!.setAdapter(notificationAdapter)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }
}