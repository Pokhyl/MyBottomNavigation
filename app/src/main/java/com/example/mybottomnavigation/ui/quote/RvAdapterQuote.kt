package com.example.mybottomnavigation.ui.quote

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mybottomnavigation.databinding.SingleItemQuoteBinding

class RvAdapterQuote(var list: MutableList<Result>): RecyclerView.Adapter<QuoteViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteViewHolder {
        var binding =
            SingleItemQuoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return QuoteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {
      var qote = list[position]
        holder.binding.content.text = qote._id
        holder.binding.author.text = qote.author
        holder.binding.authorSlug.text = qote.authorSlug
        holder.binding.dateAdded.text = qote.dateAdded
        holder.binding.dateModified.text = qote.dateModified

    }

    override fun getItemCount(): Int {
    return list.size
    }
    fun addList(list: List<Result>){
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }
}