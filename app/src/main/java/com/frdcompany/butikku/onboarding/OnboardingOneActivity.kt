package com.frdcompany.butikku.onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.frdcompany.butikku.R
import com.frdcompany.butikku.sign.SignInActivity
import com.frdcompany.butikku.utils.Preferences
import kotlinx.android.synthetic.main.activity_onboarding_one.*

class OnboardingOneActivity : AppCompatActivity() {

    lateinit var preferences: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding_one)

        preferences = Preferences(this)
        if (preferences.getValues("onboarding").equals("1")){
            finishAffinity()

            val intent = Intent(this@OnboardingOneActivity,
                SignInActivity::class.java)
            startActivity(intent)
        }

        btn_next.setOnClickListener {
            val intent = Intent(this@OnboardingOneActivity,
                OnboardingTwoActivity::class.java)
            startActivity(intent)
        }

        btn_skip.setOnClickListener {
            val intent = Intent( this@OnboardingOneActivity,
                SignInActivity::class.java)
            startActivity(intent)
        }
    }
}
