package com.mty.myapplication.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mty.myapplication.R
import com.mty.myapplication.model.SpTravelWarningitem

class SpTravelWarningServiceAdapter(val sptravelWarningList:MutableList<SpTravelWarningitem>): RecyclerView.Adapter<SpTravelWarningServiceAdapter.warningViewHolder>(){
        override fun onCreateViewHolder (parent: ViewGroup, viewType: Int): warningViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_sptravelwarning,parent,false)
        return warningViewHolder(view)
    }
    class warningViewHolder (itemView:View) :RecyclerView.ViewHolder(itemView) {
        val evacuate_rcmnd_remark =itemView.findViewById<TextView>(R.id.tv_evacuate_rcmnd_remark4)
        val region=itemView.findViewById<TextView>(R.id.tv_region_ty4)
        val written_dt=itemView.findViewById<TextView>(R.id.tv_written_dt4)
        val dang_map_download_url=itemView.findViewById<ImageView>(R.id.iv_dang_map_download_url4)
    }
    override fun getItemCount(): Int {
        return sptravelWarningList.size
    }

    override fun onBindViewHolder(holder: warningViewHolder, position: Int)
    {
        holder.evacuate_rcmnd_remark.setText(sptravelWarningList.get(position).evacuate_rcmnd_remark) //철수 권고비고
        holder.region.setText(sptravelWarningList.get(position).region_ty) //지역유형
        holder.written_dt.setText(sptravelWarningList.get(position).written_dt) //작성일자
        Glide.with(holder.itemView.context).load(sptravelWarningList[position].dang_map_download_url).into(holder.dang_map_download_url)
    }
}