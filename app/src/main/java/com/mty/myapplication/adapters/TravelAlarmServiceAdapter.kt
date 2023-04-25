package com.mty.myapplication.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mty.myapplication.R
import com.mty.myapplication.model.TravelAlarmItem

class TravelAlarmServiceAdapter(val travelAlarmlist:MutableList<TravelAlarmItem>):RecyclerView.Adapter<TravelAlarmServiceAdapter.AlarmViewHolder>() {
    override fun onCreateViewHolder (parent: ViewGroup, viewType: Int): AlarmViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_travelalarm, parent, false)
        return AlarmViewHolder(view)
    }
    class AlarmViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tv_alarm_lvl = itemView.findViewById<TextView>(R.id.tv_alarm_lvl5)
        val remark = itemView.findViewById<TextView>(R.id.tv_remark5)
        val written_dt = itemView.findViewById<TextView>(R.id.tv_written_dt5)
        val dang_map_download_url=itemView.findViewById<ImageView>(R.id.iv_dang_map_download_url5)
    }
    override fun getItemCount(): Int {
        return travelAlarmlist.size
    }
    override fun onBindViewHolder(holder:AlarmViewHolder, position: Int) {
        Glide.with(holder.itemView.context).load(travelAlarmlist[position].dang_map_download_url).into(holder.dang_map_download_url)
        holder.tv_alarm_lvl.setText(travelAlarmlist.get(position).alarm_lvl)
        holder.remark.setText(travelAlarmlist.get(position).remark)
        holder.written_dt.setText(travelAlarmlist.get(position).written_dt)
    }


}

