package com.frdcompany.butikku

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.frdcompany.butikku.fragment.home.Item
import kotlinx.android.synthetic.main.activity_metode_pembayaran.*

class MetodePembayaranActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_metode_pembayaran)

        val data = intent.getParcelableExtra<Item>("data")

        btn_bayardiTempat.setOnClickListener {
            val intent = Intent(this@MetodePembayaranActivity, BayarDitempatActivity::class.java)
                .putExtra("data", data)
            startActivity(intent)
        }
    }
}
