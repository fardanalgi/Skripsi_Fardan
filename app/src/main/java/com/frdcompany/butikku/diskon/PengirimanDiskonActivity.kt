package com.frdcompany.butikku.diskon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.frdcompany.butikku.R
import com.frdcompany.butikku.fragment.home.Diskon
import com.frdcompany.butikku.utils.Preferences
import kotlinx.android.synthetic.main.activity_pengiriman.btn_back
import kotlinx.android.synthetic.main.activity_pengiriman.img_gambar
import kotlinx.android.synthetic.main.activity_pengiriman.tv_alamat
import kotlinx.android.synthetic.main.activity_pengiriman.tv_harga
import kotlinx.android.synthetic.main.activity_pengiriman.tv_telp
import kotlinx.android.synthetic.main.activity_pengiriman.tv_title
import kotlinx.android.synthetic.main.activity_pengiriman.tv_total
import kotlinx.android.synthetic.main.activity_pengiriman_diskon.*

class PengirimanDiskonActivity : AppCompatActivity() {

    lateinit var preferences: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pengiriman_diskon)

        preferences = Preferences(this)
        tv_alamat.setText(preferences.getValues("alamat"))
        tv_telp.setText(preferences.getValues("telp"))
        val data = intent.getParcelableExtra<Diskon>("datadiskon")

        tv_title.text = data.title
        tv_diskon.text = data.harga
        tv_harga.text = data.diskon
        tv_total.text = data.diskon


        Glide.with(this)
            .load(data.gambar)
            .into(img_gambar)

        btn_back.setOnClickListener {
            finish()
        }

    }
}
