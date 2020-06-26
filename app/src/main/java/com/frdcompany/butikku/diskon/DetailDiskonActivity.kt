package com.frdcompany.butikku.diskon

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.frdcompany.butikku.nodiskon.DetailActivity
import com.frdcompany.butikku.R
import com.frdcompany.butikku.fragment.home.Diskon
import com.frdcompany.butikku.fragment.home.Item
import com.frdcompany.butikku.fragment.home.PopularAdapter
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_detail_diskon.*

class DetailDiskonActivity : AppCompatActivity() {

    lateinit var mDatabase: DatabaseReference
    private var dataList = ArrayList<Item>()

    private val TAG = "Message"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_diskon)

        mDatabase = FirebaseDatabase.getInstance().getReference("Item")
        val data = intent.getParcelableExtra<Diskon>("data")

        tv_detail_title.text = data.title
        tv_harga.text = data.diskon
        tv_kategori.text = data.katagori

        Glide.with(this)
            .load(data.gambar)
            .into(img_gambar)

        rv_pilihan.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        getData()


        btn_back_diskon.setOnClickListener {
            finish()
        }

        btn_message_diskon.setOnClickListener {
            val uri = Uri.parse("https://api.whatsapp.com/send?phone=6287848491962&text=Permisi%20min%20saya%20mau%20pesan")
            val intent = Intent(Intent.ACTION_VIEW,uri)
            startActivity(intent)
        }

        btn_buy.setOnClickListener {
            val intent = Intent(this, PengirimanDiskonActivity::class.java)
                .putExtra("datadiskon", data)
            startActivity(intent)
        }

    }

    private fun getData(){
        mDatabase.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                dataList.clear()
                for (getdataSnapshot in dataSnapshot.getChildren()){

                    val item = getdataSnapshot.getValue(Item::class.java!!)
                    dataList.add(item!!)
                }

                if (dataList.isNotEmpty()){
                    rv_pilihan.adapter = PopularAdapter(dataList){
                        val intent = Intent(this@DetailDiskonActivity,
                            DetailActivity::class.java)
                            .putExtra("data",it)
                        startActivity(intent)
                    }

                }
            }

            override fun onCancelled(error: DatabaseError) {
                Log.w(TAG, "Failed to read value.", error.toException())
            }

        })
    }
}
