package com.frdcompany.butikku

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.frdcompany.butikku.fragment.home.Item
import com.google.firebase.database.DatabaseReference
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    lateinit var mDatabase: DatabaseReference
    private var dataList = ArrayList<Item>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val data = intent.getParcelableExtra<Item>("data")

        tv_detail_title.text = data.title
        tv_harga.text = data.harga
        tv_kategori.text = data.katagori

        Glide.with(this)
            .load(data.gambar)
            .into(img_gambar)

        btn_back.setOnClickListener {
            finish()
        }
    }
}
