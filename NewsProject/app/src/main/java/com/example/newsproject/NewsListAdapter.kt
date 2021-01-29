package com.example.newsproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class NewsListAdapter( private val listener: NewsItemClickListener): RecyclerView.Adapter<NewsViewHolder>() {

    private val items: ArrayList<News> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        val viewHolder = NewsViewHolder(view)

        view.setOnClickListener {
            listener.onItemClicked(items[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        var currentPostion = items[position]
        holder.titleView.text = currentPostion.title
        holder.authorView.text = currentPostion.author
        Glide.with(holder.imageView.context).load(  currentPostion.urlToImage).into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun updateNews(updateNews: ArrayList<News>) {
        items.clear()
        items.addAll(updateNews)
        notifyDataSetChanged()

    }
}

class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var titleView: TextView = itemView.findViewById(R.id.title)
    var authorView: TextView = itemView.findViewById(R.id.author)
    var imageView: ImageView = itemView.findViewById(R.id.imageView)
}
interface NewsItemClickListener {
    fun onItemClicked(item: News)
}
