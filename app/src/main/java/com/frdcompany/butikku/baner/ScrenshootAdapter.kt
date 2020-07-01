package com.frdcompany.butikku.baner

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.frdcompany.butikku.R

class ScrenshootAdapter (private var data: ArrayList<Banner>,
                         private val listener : (Banner) -> Unit)
    : RecyclerView.Adapter<ScrenshootAdapter.MyViewHolder>(){

    private lateinit var contextAdapter : Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        contextAdapter = parent.context
        val inflaterView : View = layoutInflater.inflate(R.layout.item_row_ss, parent, false)

        return MyViewHolder(inflaterView)

    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.bindItem(data[position], listener, contextAdapter)

    }

    class MyViewHolder(view : View) : RecyclerView.ViewHolder(view) {

        private val img: ImageView = view.findViewById(R.id.imageVieww)

        fun bindItem (data: Banner, listener: (Banner) -> Unit, context: Context){

            Glide.with(context)
                .load(data.gambar)
                .into(img)

            itemView.setOnClickListener {
                listener(data)
            }
        }

    }

}