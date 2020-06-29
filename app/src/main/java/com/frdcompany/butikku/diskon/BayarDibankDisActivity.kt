package com.frdcompany.butikku.diskon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.frdcompany.butikku.R
import com.frdcompany.butikku.fragment.home.Diskon
import com.frdcompany.butikku.fragment.home.Item
import com.frdcompany.butikku.nodiskon.CheckoutActivity
import kotlinx.android.synthetic.main.activity_bayar_dibank.*
import kotlinx.android.synthetic.main.activity_bayar_dibank_dis.*

class BayarDibankDisActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bayar_dibank_dis)

        val data = intent.getParcelableExtra<Diskon>("data")

        btn_bcaa.setOnClickListener {
            val intent = Intent (this, CheckoutDisActivity::class.java)
                .putExtra("data", data)
            startActivity(intent)
        }

        btn_mandirii.setOnClickListener {
            Toast.makeText(getApplicationContext(),"Maaf untuk saat ini Butik-Ku hanya menerima pembayaran melalui Bank BCA", Toast.LENGTH_SHORT).show()
        }

        btn_bnii.setOnClickListener {
            Toast.makeText(getApplicationContext(),"Maaf untuk saat ini Butik-Ku hanya menerima pembayaran melalui Bank BCA", Toast.LENGTH_SHORT).show()
        }

    }
}
