package com.frdcompany.butikku

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_order_confirmed.*

class OrderConfirmedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_confirmed)

        back_to_home.setOnClickListener {
            finishAffinity()

            val intent = Intent(this@OrderConfirmedActivity,
                MainActivity::class.java)
            startActivity(intent)
        }
    }
}
