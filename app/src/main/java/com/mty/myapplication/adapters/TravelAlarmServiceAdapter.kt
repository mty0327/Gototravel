package com.mty.myapplication.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mty.myapplication.R
import com.mty.myapplication.model.TravelAlarmItem

class TravelAlarmServiceAdapter(val travelAlarmlist:MutableList<TravelAlarmItem>): RecyclerView.Adapter<TravelAlarmServiceAdapter.AlarmViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlarmViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_countrysafetynotice, parent, false)
        return AlarmViewHolder(view)
    }

    override fun getItemCount(): Int {
        return travelAlarmlist.size
    }

    override fun onBindViewHolder(
        holder: TravelAlarmServiceAdapter.AlarmViewHolder, position: Int
    ) {
        holder.region_ty.setText(travelAlarmlist.get(position).region_ty)
        holder.tv_alarm_lvl.setText(travelAlarmlist.get(position).alarm_lvl)
        holder.remark.setText(travelAlarmlist.get(position).remark)
        holder.wrt_dt.setText(travelAlarmlist.get(position).written_dt)
    }

    class AlarmViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        val region_ty = itemView.findViewById<TextView>(R.id.tv_region_ty2)
        val tv_alarm_lvl = itemView.findViewById<TextView>(R.id.tv_alarm_lvl)
        val remark = itemView.findViewById<TextView>(R.id.tv_remark2)
        val wrt_dt = itemView.findViewById<TextView>(R.id.written_dt)
    }
}

