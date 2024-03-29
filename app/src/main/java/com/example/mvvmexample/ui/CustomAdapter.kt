package com.example.mvvmexample.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmexample.R
import com.example.mvvmexample.network.data.Result

class CustomAdapter(var results: List<Result>) :RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.itemview, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return results.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemsViewModel = results[position]
        holder.textAuthor.text = itemsViewModel.author
        holder.textContent.text = itemsViewModel.content
    }

    class ViewHolder(ItemView: View): RecyclerView.ViewHolder(ItemView) {
        val textAuthor: TextView = itemView.findViewById(R.id.textView)
        val textContent: TextView = itemView.findViewById(R.id.textView2)
    }
}