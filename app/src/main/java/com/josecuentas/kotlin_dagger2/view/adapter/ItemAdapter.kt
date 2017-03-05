package com.josecuentas.kotlin_dagger2.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.josecuentas.kotlin_dagger2.R
import com.josecuentas.kotlin_dagger2.domain.model.User
import kotlinx.android.synthetic.main.row_item.view.*
/**
 * Created by iPibeDx on 4/03/17.
 */
class ItemAdapter constructor(var values: List<User> = emptyList()) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        var view: View = LayoutInflater.from(parent?.context).inflate(R.layout.row_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = values.get(position)
        holder.tviItem.text = user.name
    }

    override fun getItemCount(): Int {
        return values.size
    }
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var tviItem = view.tviItem
    }
}