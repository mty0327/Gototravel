package com.mty.myapplication.adapters

import android.text.Spanned
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mty.myapplication.R
import com.mty.myapplication.model.SafetyNewsItem
import org.w3c.dom.Text

class SafetyNewsAdapter (val safetynewsList:MutableList<SafetyNewsItem>): RecyclerView.Adapter<SafetyNewsAdapter.newsViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SafetyNewsAdapter.newsViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_safetynews, parent, false)
        return newsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return safetynewsList.size
    }

    class newsViewHolder (itemView: View) :RecyclerView.ViewHolder(itemView) {
        val title=itemView.findViewById<TextView>(R.id.tv_title9)
        val wrtDt=itemView.findViewById<TextView>(R.id.tv_wrtDt9)
        val content=itemView.findViewById<TextView>(R.id.tv_content9)
        val countryName=itemView.findViewById<TextView>(R.id.tv_countryName9)
        val countryEnName=itemView.findViewById<TextView>(R.id.tv_countryEnName9)
        val contentHtml=itemView.findViewById<TextView>(R.id.tv_contentHtml9)
        val fileUrl=itemView.findViewById<TextView>(R.id.tv_fileUrl9)
    }

    override fun onBindViewHolder(holder: newsViewHolder, position: Int) {
        val t:String= HtmlCompat.fromHtml(safetynewsList.get(position).title, HtmlCompat.FROM_HTML_MODE_COMPACT).toString()
        holder.title.setText(t)
        holder.wrtDt.setText(safetynewsList[position].wrtDt)
        holder.content.setText(safetynewsList.get(position).content)
        holder.contentHtml.setText(safetynewsList.get(position).contentHtml)
        holder.countryName.setText(safetynewsList.get(position).countryName)
        holder.countryEnName.setText(safetynewsList.get(position).countryEnName)
        holder.fileUrl.setText(safetynewsList.get(position).fileUrl)
    }
}
