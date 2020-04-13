package com.frdcompany.butikku

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.frdcompany.butikku.fragment.home.Item
import com.frdcompany.butikku.utils.Preferences
import kotlinx.android.synthetic.main.activity_pengiriman.*

class PengirimanActivity : AppCompatActivity() {

    lateinit var preferences: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pengiriman)

        preferences = Preferences(this)
        tv_alamat.setText(preferences.getValues("alamat"))
        tv_telp.setText(preferences.getValues("telp"))
        val data = intent.getParcelableExtra<Item>("data")

        tv_title.text = data.title
        tv_diskon.text = data.diskon
        tv_harga.text = data.harga
        tv_total.text = data.harga


        Glide.with(this)
            .load(data.gambar)
            .into(img_gambar)

        btn_back.setOnClickListener {
            finish()
        }

    }
}
