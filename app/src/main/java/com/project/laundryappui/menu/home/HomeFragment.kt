package com.project.laundryappui.menu.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.laundryappui.R
import com.project.laundryappui.menu.home.adapter.HomeAdapter
import com.project.laundryappui.menu.home.model.HomeModel

class HomeFragment : Fragment() {
    private var mContext: Context? = null
    private var recyclerView: RecyclerView? = null
    private var layoutManager: LinearLayoutManager? = null
    private var homeAdapter: HomeAdapter? = null
    private var homeModelList: MutableList<HomeModel>? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAdapterType(view)
        setAdapter()
    }

    private fun initData() {
        homeModelList = ArrayList()
        (homeModelList as ArrayList<HomeModel>).add(
            HomeModel(
                R.drawable.bg_post1,
                "Amanda Laundry",
                "$10-$20",
                "Distance 1.2 km"
            )
        )
        (homeModelList as ArrayList<HomeModel>).add(
            HomeModel(
                R.drawable.bg_post2,
                "Papa Laundry",
                "$30-$40",
                "Distance 1.3 km"
            )
        )
        (homeModelList as ArrayList<HomeModel>).add(
            HomeModel(
                R.drawable.bg_post3,
                "Mama Laundry",
                "$50-$60",
                "Distance 1.4 km"
            )
        )
    }

    private fun setAdapterType(view: View) {
        recyclerView = view.findViewById(R.id.recyclerview_recommended)
        layoutManager = LinearLayoutManager(mContext)
        recyclerView?.setHasFixedSize(true)
        recyclerView?.setLayoutManager(
            LinearLayoutManager(
                mContext,
                LinearLayoutManager.HORIZONTAL,
                false
            )
        )
        recyclerView?.setNestedScrollingEnabled(true)
    }

    private fun setAdapter() {
        initData()
        homeAdapter = HomeAdapter(homeModelList)
        recyclerView!!.setAdapter(homeAdapter)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }
}