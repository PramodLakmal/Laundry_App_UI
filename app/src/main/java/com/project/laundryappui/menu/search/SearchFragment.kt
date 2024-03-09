package com.project.laundryappui.menu.search

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.laundryappui.R

class SearchFragment : Fragment() {
    private var mContext: Context? = null
    private var recyclerView: RecyclerView? = null
    private var homeAdapter: SearchAdapter? = null
    private var searchModelList: MutableList<SearchModel>? = null
    var layoutManager: LinearLayoutManager? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAdapterType(view)
        setAdapter()
    }

    private fun initData() {
        searchModelList = ArrayList()
        (searchModelList as ArrayList<SearchModel>).add(
            SearchModel(
                R.drawable.bg_post1,
                "Pasindu Laundry \nCompany and Co.",
                "7.5",
                "Distance 1.5 km"
            )
        )
        (searchModelList as ArrayList<SearchModel>).add(
            SearchModel(
                R.drawable.bg_post2,
                "Sachin Laundry \nCompany and Co.",
                "8.5",
                "Distance 2.5 km"
            )
        )
        (searchModelList as ArrayList<SearchModel>).add(
            SearchModel(
                R.drawable.bg_post3,
                "Sanjuka Laundry \nCompany and Co.",
                "9.5",
                "Distance 3.5 km"
            )
        )
    }

    private fun setAdapterType(view: View) {
        recyclerView = view.findViewById(R.id.recyclerview_maps)
        layoutManager = LinearLayoutManager(mContext)
        recyclerView?.setHasFixedSize(true)
        recyclerView?.setLayoutManager(
            LinearLayoutManager(
                mContext,
                LinearLayoutManager.HORIZONTAL,
                false
            )
        )
        recyclerView?.isNestedScrollingEnabled = true
    }

    private fun setAdapter() {
        initData()
        homeAdapter = SearchAdapter(searchModelList)
        recyclerView!!.setAdapter(homeAdapter)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }
}