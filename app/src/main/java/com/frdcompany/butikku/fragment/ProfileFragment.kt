package com.frdcompany.butikku.fragment


import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.frdcompany.butikku.AboutActivity
import com.frdcompany.butikku.R
import com.frdcompany.butikku.SplashscreenActivity
import com.frdcompany.butikku.utils.Preferences
import kotlinx.android.synthetic.main.fragment_profile.*

/**
 * A simple [Fragment] subclass.
 */
class ProfileFragment : Fragment() {

    lateinit var preferences: Preferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        preferences = Preferences(context!!.applicationContext)

        Glide.with(this)
            .load(preferences.getValues("url"))
            .apply(RequestOptions.circleCropTransform())
            .into(iv_profilee)

        iv_nama.text = preferences.getValues("nama")
        tv_email.text = preferences.getValues("email")
        tv_user.text = preferences.getValues("user")
        tv_phonee.text = preferences.getValues("telp")

        tv_edit_profile.setOnClickListener {
            val intent = Intent (context, AboutActivity::class.java)
            startActivity(intent)
        }

        tv_my_wallet.setOnClickListener {
            val intent = Intent(Settings.ACTION_LOCALE_SETTINGS)
            startActivity(intent)
        }

    }

}
