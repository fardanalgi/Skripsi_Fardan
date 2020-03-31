package com.frdcompany.butikku.onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.frdcompany.butikku.R
import com.frdcompany.butikku.sign.SignInActivity
import kotlinx.android.synthetic.main.activity_onboarding_tree.*

class OnboardingTreeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding_tree)

        btn_next.setOnClickListener {
            finishAffinity()

            val intent = Intent(this@OnboardingTreeActivity,
                SignInActivity::class.java)
            startActivity(intent)
        }
    }
}
