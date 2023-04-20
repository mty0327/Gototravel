package com.mty.myapplication.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.RecyclerView
import com.mty.myapplication.R
import com.mty.myapplication.SafetyNoticeItem

class CountrySafetyServiceAdapter(val countrysafetynoticeList:MutableList<SafetyNoticeItem>):RecyclerView.Adapter<CountrySafetyServiceAdapter.noticeViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountrySafetyServiceAdapter.noticeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_countrysafetynotice, parent,false)
        return noticeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return countrysafetynoticeList.size
    }
    override fun onBindViewHolder(holder: CountrySafetyServiceAdapter.noticeViewHolder, position: Int) {
        holder.ctgy_nm.setText(countrysafetynoticeList.get(position).ctgy_nm)// 공지사항

        val s:String= HtmlCompat.fromHtml(countrysafetynoticeList.get(position).txt_origin_cn, HtmlCompat.FROM_HTML_MODE_COMPACT).toString()
        holder.txt_origin_cn.setText(s)//텍스트 원본내용

        holder.wrt_dt.setText(countrysafetynoticeList.get(position).wrt_dt)//작성일자


    }
    class noticeViewHolder(itemView:View) :RecyclerView.ViewHolder(itemView) {
        val ctgy_nm=itemView.findViewById<TextView>(R.id.tv_ctgy_nm2) // 공지사항
        val txt_origin_cn=itemView.findViewById<TextView>(R.id.tv_txt_origin_cn2) //텍스트 원본내용
        val wrt_dt=itemView.findViewById<TextView>(R.id.tv_wrt_dt2) //작성일자
    }

}