package com.mty.myapplication.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mty.myapplication.R
import com.mty.myapplication.model.GetEntranceVisaItem

class GetEntranceVisaAdapter (val getEntranceVisaList:MutableList<GetEntranceVisaItem>): RecyclerView.Adapter<GetEntranceVisaAdapter.visaViewHolder>()
{override fun onCreateViewHolder (parent: ViewGroup, viewType: Int): GetEntranceVisaAdapter.visaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_getentrancevisa, parent,false)
        return visaViewHolder(view)
    }
    override fun getItemCount(): Int {
        return getEntranceVisaList.size
    }

    override fun onBindViewHolder(holder: GetEntranceVisaAdapter.visaViewHolder, position: Int) {
        holder.have_yn.setText(getEntranceVisaList.get(position).have_yn) //여권소지여부
        holder.gnrl_pspt_visa_yn.setText(getEntranceVisaList.get(position).gnrl_pspt_visa_yn)//일반여권 입국허가요건 여부
        holder.gnrl_pspt_visa_cn.setText(getEntranceVisaList.get(position).gnrl_pspt_visa_cn)//일반여권 입국허가내용
        holder.ofclpspt_visa_yn.setText(getEntranceVisaList.get(position).ofclpspt_visa_yn) // 관용여권 입국허가요건 여부
        holder.ofclpspt_visa_cn.setText(getEntranceVisaList.get(position).ofclpspt_visa_cn) //관용여권 입국허가내용
        holder.dplmt_pspt_visa_yn.setText(getEntranceVisaList.get(position).dplmt_pspt_visa_yn)// 외교관여권 입국허가요건 여부
        holder.dplmt_pspt_visa_cn.setText(getEntranceVisaList.get(position).dplmt_pspt_visa_cn)//외교관여권 입국허가요건 내용
        holder.nvisa_entry_evdc_cn.setText(getEntranceVisaList.get(position).nvisa_entry_evdc_cn)//무비자 입국근거내용
        holder.remark.setText(getEntranceVisaList.get(position).remark) //비고

    }

    class visaViewHolder (itemView: View) :RecyclerView.ViewHolder(itemView) {

        val have_yn =itemView.findViewById<TextView>(R.id.tv_have_yn)
        val gnrl_pspt_visa_yn=itemView.findViewById<TextView>(R.id.tv_gnrl_pspt_visa_yn)
        val gnrl_pspt_visa_cn=itemView.findViewById<TextView>(R.id.tv_gnrl_pspt_visa_cn)
        val ofclpspt_visa_yn=itemView.findViewById<TextView>(R.id.tv_ofclpspt_visa_yn)
        val ofclpspt_visa_cn=itemView.findViewById<TextView>(R.id.tv_ofclpspt_visa_cn)
        val dplmt_pspt_visa_yn=itemView.findViewById<TextView>(R.id.tv_dplmt_pspt_visa_yn)
        val dplmt_pspt_visa_cn=itemView.findViewById<TextView>(R.id.tv_dplmt_pspt_visa_cn)
        val nvisa_entry_evdc_cn=itemView.findViewById<TextView>(R.id.tv_nvisa_entry_evdc_cn)
        val remark=itemView.findViewById<TextView>(R.id.tv_remark)

    }

}