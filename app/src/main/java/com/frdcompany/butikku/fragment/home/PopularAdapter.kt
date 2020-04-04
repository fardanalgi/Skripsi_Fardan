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

class PopularAdapter(private var data: List<Item>,
                     private val listener:(Item) -> Unit)
    :RecyclerView.Adapter<PopularAdapter.ViewHolder>(){

    lateinit var contextAdapter: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        contextAdapter = parent.context
        val inflatedView: View = layoutInflater.inflate(R.layout.item_row_horizontal,parent,false)

        return ViewHolder(inflatedView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(data[position],listener, contextAdapter,position)
    }

    override fun getItemCount(): Int = data.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
         private val tvTitle: TextView = view.findViewById(R.id.tv_title)
         private val imgGambar: ImageView = view.findViewById(R.id.img_gambar)

        fun bindItem(data: Item, listener: (Item) -> Unit, contex: Context, position:Int ){

            tvTitle.text= data.title
            Glide.with(contex)
                .load(data.gambar)
                .into(imgGambar)

            itemView.setOnClickListener {
                listener(data)
            }

        }
    }

}