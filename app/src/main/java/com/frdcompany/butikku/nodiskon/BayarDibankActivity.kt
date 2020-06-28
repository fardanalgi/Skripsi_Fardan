package com.frdcompany.butikku.nodiskon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.frdcompany.butikku.R
import com.frdcompany.butikku.fragment.home.Item
import kotlinx.android.synthetic.main.activity_bayar_dibank.*

class BayarDibankActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bayar_dibank)

        val data = intent.getParcelableExtra<Item>("data")

        btn_bca.setOnClickListener {
            val intent = Intent (this, CheckoutActivity::class.java)
                .putExtra("data", data)
            startActivity(intent)
        }

        btn_mandiri.setOnClickListener {
            Toast.makeText(getApplicationContext(),"Maaf untuk saat ini Butik-Ku hanya menerima pembayaran melalui Bank BCA", Toast.LENGTH_SHORT).show()
        }

        btn_bni.setOnClickListener {
            Toast.makeText(getApplicationContext(),"Maaf untuk saat ini Butik-Ku hanya menerima pembayaran melalui Bank BCA", Toast.LENGTH_SHORT).show()
        }
    }
}
