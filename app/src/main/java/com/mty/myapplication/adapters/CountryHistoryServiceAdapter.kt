package com.mty.myapplication.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mty.myapplication.R
import com.mty.myapplication.model.CountryHistoryItem

class CountryHistoryServiceAdapter (val countryHistoryList:MutableList<CountryHistoryItem>):RecyclerView.Adapter<CountryHistoryServiceAdapter.HistoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_countryhistory, parent, false)
        return HistoryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return countryHistoryList.size
    }

    override fun onBindViewHolder(holder:HistoryViewHolder, position: Int) {
        holder.title.setText(countryHistoryList.get(position).title)
        holder.txt_origin_cn.setText(countryHistoryList.get(position).txt_origin_cn)
        holder.wrt_dt.setText(countryHistoryList.get(position).wrt_dt)
        Glide.with(holder.itemView.context).load(countryHistoryList[position].file_download_url)
    }
    class HistoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title = itemView.findViewById<TextView>(R.id.tv_title)
        val txt_origin_cn = itemView.findViewById<TextView>(R.id.tv_txt_origin_cn6)
        val wrt_dt = itemView.findViewById<TextView>(R.id.tv_wrt_dt6)
        val file_download_url = itemView.findViewById<ImageView>(R.id.iv_file_download_url6)
    }
}