package com.project.laundryappui.menu.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.project.laundryappui.R

class SearchAdapter(private var listSearch: List<SearchModel>?) :
    RecyclerView.Adapter<SearchAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_maps, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val list = listSearch!![position]
        holder.textName.text = list.name
        holder.textScore.text = list.score
        holder.textLocation.text = list.location
        holder.containerMaps.setOnClickListener { view: View ->
            Toast.makeText(
                view.context,
                "Clicked!",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun getItemCount(): Int {
        return listSearch!!.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var containerMaps: CardView
        var textScore: TextView
        var textName: TextView
        var textLocation: TextView

        init {
            containerMaps = itemView.findViewById(R.id.container_recommended)
            textName = itemView.findViewById(R.id.item_recommended_name)
            textScore = itemView.findViewById(R.id.item_recommended_price)
            textLocation = itemView.findViewById(R.id.item_recommended_location)
        }
    }
}
