package com.trick5t3r.map.models

import android.content.Context
import android.nfc.Tag
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.trick5t3r.map.MainActivity
import com.trick5t3r.map.models.UserMap

private const val Tag="MapsAdapter"
class MapsAdapter(val context: Context, val userMaps: List<UserMap>, val onClickListener:OnClickListener): RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    interface OnClickListener{
        fun onItemClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1,parent,false)
        return ViewHolder(view)
    }
    override fun getItemCount() =  userMaps.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val userMap= userMaps[position]
        holder.itemView.setOnClickListener{
            Log.i(Tag, "Tapped on position $position")
            onClickListener.onItemClick(position)
        }
        val textViewTitle = holder.itemView.findViewById<TextView>(android.R.id.text1)
        textViewTitle.text = userMap.title
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}