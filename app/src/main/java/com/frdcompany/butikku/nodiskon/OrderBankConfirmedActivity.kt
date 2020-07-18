package com.frdcompany.butikku.nodiskon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.frdcompany.butikku.MainActivity
import com.frdcompany.butikku.R
import kotlinx.android.synthetic.main.activity_order_bank_confirmed.*

class OrderBankConfirmedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_bank_confirmed)

        back_to_home.setOnClickListener {
            val intent = Intent (this, MainActivity::class.java)
            startActivity(intent)
        }

        button2.setOnClickListener {
            finish()
        }
    }
}
