package com.frdcompany.butikku

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.frdcompany.butikku.onboarding.OnboardingOneActivity

class SplashscreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

        var handler = Handler()
        handler.postDelayed({
            val intent = Intent(this, OnboardingOneActivity::class.java)
            startActivity(intent)
            finish()
        }, 1500)

    }
}
