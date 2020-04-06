package com.frdcompany.butikku.fragment.home


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.frdcompany.butikku.DetailActivity
import com.frdcompany.butikku.R
import com.frdcompany.butikku.baner.Banner
import com.frdcompany.butikku.baner.BannerAdapter
import com.frdcompany.butikku.utils.Preferences
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    private lateinit var preferences: Preferences
    lateinit var mDatabase : DatabaseReference

    private var mList = ArrayList<Banner>()
    private var dataList = ArrayList<Item>()

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
        mDatabase = FirebaseDatabase.getInstance().getReference("Item")
        tv_hello2.setText(preferences.getValues("nama"))


        rv_popular.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        rv_bestPrice.layoutManager = LinearLayoutManager(context!!.applicationContext)


        rv_banner.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        getData()

        rv_banner.adapter = BannerAdapter(mList){
        }

        mList.add(Banner(R.drawable.baner2))
        mList.add(Banner(R.drawable.baner1))
        mList.add(Banner(R.drawable.baner3))

    }

    private fun getData(){
        mDatabase.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                dataList.clear()
                for (getdataSnapshot in dataSnapshot.getChildren()){

                    val item = getdataSnapshot.getValue(Item::class.java!!)
                    dataList.add(item!!)
                }

                if (dataList.isNotEmpty()){
                    rv_popular.adapter = PopularAdapter(dataList){
                        val intent = Intent(context,DetailActivity::class.java)
                            .putExtra("data",it)
                        startActivity(intent)
                    }
                    rv_bestPrice.adapter = DiskonAdapter(dataList){
                        val intent = Intent(context,DetailActivity::class.java)
                            .putExtra("data",it)
                        startActivity(intent)
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context,""+error.message, Toast.LENGTH_LONG).show()
            }

        })
    }

}
