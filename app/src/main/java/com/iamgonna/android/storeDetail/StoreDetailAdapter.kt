package com.iamgonna.android.storeDetail

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.iamgonna.android.R
import com.iamgonna.android.main.model.ResultSchool

class StoreDetailAdapter(val context : Context) : RecyclerView.Adapter<StoreDetailAdapter.Holder>() {
    val menuList = ArrayList<ResultSchool>()
    inner class Holder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        fun bind(position: Int) {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.menu_rv_item, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(menuList.size)
    }

    override fun getItemCount(): Int {
        return menuList.size
    }
}