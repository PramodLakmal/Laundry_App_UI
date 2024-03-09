package com.project.laundryappui.menu.home.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.project.laundryappui.R
import com.project.laundryappui.menu.home.home_detail.HomeDetailActivity
import com.project.laundryappui.menu.home.model.HomeModel

class HomeAdapter(var listHome: List<HomeModel>?) : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_recommended, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val list = listHome!![position]
        holder.imageRecommended.setBackgroundResource(list.image)
        holder.textName.text = list.name
        holder.textPrice.text = list.price
        holder.textLocation.text = list.location
        holder.containerRecommended.setOnClickListener { view ->
            view.context.startActivity(Intent(view.context, HomeDetailActivity::class.java))
            //                Toast.makeText(view.getContext(), "Clicked!", Toast.LENGTH_SHORT).show();
        }
    }

    override fun getItemCount(): Int {
        return listHome!!.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var containerRecommended: CardView
        var imageRecommended: ImageView
        var textPrice: TextView
        var textName: TextView
        var textLocation: TextView

        init {
            containerRecommended = itemView.findViewById(R.id.container_recommended)
            imageRecommended = itemView.findViewById(R.id.item_recommended_image)
            textName = itemView.findViewById(R.id.item_recommended_name)
            textPrice = itemView.findViewById(R.id.item_recommended_price)
            textLocation = itemView.findViewById(R.id.item_recommended_location)
        }
    }
}
