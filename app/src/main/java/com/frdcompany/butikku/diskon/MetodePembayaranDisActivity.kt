package com.frdcompany.butikku.diskon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.frdcompany.butikku.R
import com.frdcompany.butikku.fragment.home.Diskon
import com.frdcompany.butikku.fragment.home.Item
import com.frdcompany.butikku.nodiskon.BayarDibankActivity
import com.frdcompany.butikku.nodiskon.BayarDitempatActivity
import kotlinx.android.synthetic.main.activity_metode_pembayaran.*
import kotlinx.android.synthetic.main.activity_metode_pembayaran.btn_bayarBank
import kotlinx.android.synthetic.main.activity_metode_pembayaran.btn_bayardiTempat
import kotlinx.android.synthetic.main.activity_metode_pembayaran_dis.*

class MetodePembayaranDisActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_metode_pembayaran_dis)

        val data = intent.getParcelableExtra<Diskon>("data")

        btn_bayardiTempatt.setOnClickListener {
            val intent = Intent(this, BayarDitempatDisActivity::class.java)
                .putExtra("data", data)
            startActivity(intent)
        }

        btn_bayarBankk.setOnClickListener {
            val intent = Intent(this, BayarDibankActivity::class.java)
                .putExtra("data", data)
            startActivity(intent)
        }
    }
}
