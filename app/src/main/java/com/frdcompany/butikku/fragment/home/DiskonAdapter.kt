package com.frdcompany.butikku.fragment.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.frdcompany.butikku.R

class DiskonAdapter (private var data: List<Item>,
                     private val listener: (Item) -> Unit)
    : RecyclerView.Adapter<DiskonAdapter.LeagueViewHolder>() {

    lateinit var ContextAdapter : Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeagueViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        ContextAdapter = parent.context
        val inflatedView: View = layoutInflater.inflate(R.layout.item_row_vertical, parent, false)

        return LeagueViewHolder(inflatedView)
    }

    override fun onBindViewHolder(holder: LeagueViewHolder, position: Int) {
        holder.bindItem(data[position], listener, ContextAdapter, position)
    }

    override fun getItemCount(): Int = data.size

    class LeagueViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val tvTitle: TextView = view.findViewById(R.id.tv_title)
        private val tvDiskon: TextView = view.findViewById(R.id.tv_diskon)
        private val tvHarga: TextView = view.findViewById(R.id.tv_harga)

        private val imgGambar: ImageView = view.findViewById(R.id.img_gambar)

        fun bindItem(data: Item, listener: (Item) -> Unit, context : Context, position : Int) {

            tvTitle.text = data.title
            tvDiskon.text = data.diskon
            tvHarga.text = data.harga

            Glide.with(context)
                .load(data.gambar)
                .into(imgGambar)

            itemView.setOnClickListener {
                listener(data)
            }
        }

    }

}