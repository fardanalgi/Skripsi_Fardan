package com.frdcompany.butikku

import android.content.Intent
import android.net.Uri
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

        btn_message.setOnClickListener {
            val uri = Uri.parse("https://api.whatsapp.com/send?phone=6287848491962&text=Permisi%20min%20saya%20mau%20pesan")
            val intent = Intent(Intent.ACTION_VIEW,uri)
            startActivity(intent)
        }

        btn_add_to_chart.setOnClickListener {

        }
    }
}
