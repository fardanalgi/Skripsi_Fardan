package com.frdcompany.butikku.diskon

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import com.frdcompany.butikku.R
import com.frdcompany.butikku.fragment.home.Diskon
import com.frdcompany.butikku.fragment.home.Item
import com.frdcompany.butikku.nodiskon.DetailActivity
import com.frdcompany.butikku.nodiskon.OrderBankConfirmedActivity
import kotlinx.android.synthetic.main.activity_bayar_ditempat.*
import kotlinx.android.synthetic.main.activity_bayar_ditempat.tv_total
import kotlinx.android.synthetic.main.activity_checkout.*

class CheckoutDisActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout_dis)

        val data = intent.getParcelableExtra<Diskon>("data")

        tv_total.text = data.harga
        tv_total2.text = data.harga

        btn_next.setOnClickListener {
            val intent = Intent (this, OrderBankConfirmedActivity::class.java)
            startActivity(intent)

            showNotif(data)
        }
    }

    private fun showNotif(datas: Diskon) {
        val NOTIFICATION_CHANNEL_ID = "channel_bwa_notif"
        val context = this.applicationContext
        var notificationManager =
            context.getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            val channelName = "BWAMOV Notif Channel"
            val importance = NotificationManager.IMPORTANCE_HIGH

            val mChannel = NotificationChannel(NOTIFICATION_CHANNEL_ID, channelName, importance)
            notificationManager.createNotificationChannel(mChannel)
        }

//        val mIntent = Intent(this, CheckoutSuccessActivity::class.java)
//        val bundle = Bundle()
//        bundle.putString("id", "id_film")
//        mIntent.putExtras(bundle)

        val mIntent = Intent(this, CheckoutDisActivity::class.java)
        val bundle = Bundle()
        bundle.putParcelable("data", datas)
        mIntent.putExtras(bundle)

        val pendingIntent =
            PendingIntent.getActivity(this, 0, mIntent, PendingIntent.FLAG_UPDATE_CURRENT)

        val builder = NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID)
        builder.setContentIntent(pendingIntent)
            .setSmallIcon(R.drawable.logo_new)
            .setLargeIcon(
                BitmapFactory.decodeResource(
                    this.resources,
                    R.drawable.logo
                )
            )
            .setTicker("notif bwa starting")
            .setAutoCancel(true)
            .setVibrate(longArrayOf(1000, 1000, 1000, 1000, 1000))
            .setLights(Color.RED, 3000, 3000)
            .setDefaults(Notification.DEFAULT_SOUND)
            .setContentTitle("Menunggu Pembayaran")
            .setContentText(datas.title+" Lakukan pembayaran sebelum 24 jam")

        notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(115, builder.build())
    }
}
