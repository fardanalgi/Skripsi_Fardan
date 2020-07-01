package com.frdcompany.butikku

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.frdcompany.butikku.baner.Banner
import com.frdcompany.butikku.baner.BannerAdapter
import com.frdcompany.butikku.baner.ScrenshootAdapter
import kotlinx.android.synthetic.main.activity_about.*
import kotlinx.android.synthetic.main.fragment_home.*

class AboutActivity : AppCompatActivity() {

    private var mList = ArrayList<Banner>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)


        rv_about.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        rv_about.adapter = ScrenshootAdapter(mList){
        }

        mList.add(Banner(R.drawable.ss1))
        mList.add(Banner(R.drawable.ss2))
        mList.add(Banner(R.drawable.ss3))
    }
}
