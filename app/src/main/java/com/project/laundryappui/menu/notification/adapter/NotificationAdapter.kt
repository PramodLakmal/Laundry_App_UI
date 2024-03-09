package com.project.laundryappui.menu.notification.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.project.laundryappui.R
import com.project.laundryappui.menu.notification.model.NotificationModel

class NotificationAdapter(var listNotification: List<NotificationModel>?) :
    RecyclerView.Adapter<NotificationAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_order, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val list = listNotification!![position]
        holder.imageOrder.setImageResource(list.image)
        holder.textName.text = list.name
        holder.textStatusOrder.text = list.status_order
        holder.containerRecommended.setOnClickListener { view: View ->
//                view.getContext().startActivity(new Intent(view.getContext(), HomeDetailActivity.class));
            Toast.makeText(view.context, "Clicked!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return listNotification!!.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var containerRecommended: CardView
        var imageOrder: ImageView
        var textName: TextView
        var textStatusOrder: TextView

        init {
            containerRecommended = itemView.findViewById(R.id.container_order)
            imageOrder = itemView.findViewById(R.id.item_order_image)
            textName = itemView.findViewById(R.id.item_order_name)
            textStatusOrder = itemView.findViewById(R.id.item_order_status_order)
        }
    }
}
