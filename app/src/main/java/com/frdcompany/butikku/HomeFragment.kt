package com.frdcompany.butikku


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.frdcompany.butikku.baner.Banner
import com.frdcompany.butikku.baner.BannerAdapter
import com.frdcompany.butikku.utils.Preferences
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    private lateinit var preferences: Preferences
    private var dataList = ArrayList<Banner>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)


    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        preferences = Preferences(activity!!.applicationContext)

        tv_hello2.setText(preferences.getValues("nama"))

        rv_banner.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        rv_banner.adapter = BannerAdapter(dataList){

        }

        dataList.add(Banner(R.drawable.baner2))
        dataList.add(Banner(R.drawable.baner1))
        dataList.add(Banner(R.drawable.baner3))

    }

}
