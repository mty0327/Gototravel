package com.mty.myapplication.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.RecyclerView
import com.mty.myapplication.R
import com.mty.myapplication.model.LocalContactitem

class LocalContactServiceAdapter (val localContactList:MutableList<LocalContactitem>): RecyclerView.Adapter<LocalContactServiceAdapter.ContactViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_localcontactservice,parent,false)
        return ContactViewHolder(view)
    }

    class ContactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val contact_remark= itemView.findViewById<TextView>(R.id.tv_contact_remark8)
        val wrt_dt=itemView.findViewById<TextView>(R.id.tv_wrt_dt8)
    }
    override fun getItemCount(): Int {
        return localContactList.size
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {

        val s:String= HtmlCompat.fromHtml(localContactList.get(position).contact_remark,HtmlCompat.FROM_HTML_MODE_COMPACT).toString()
        holder.contact_remark.setText(s)
        holder.wrt_dt.setText(localContactList.get(position).wrt_dt)
    }

}


