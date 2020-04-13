package com.frdcompany.butikku.sign

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.frdcompany.butikku.MainActivity
import com.frdcompany.butikku.R
import com.frdcompany.butikku.utils.Preferences
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

    lateinit var sUsername : String
    lateinit var sPassword : String
    lateinit var sNama : String
    lateinit var sEmail : String
    lateinit var sAddress: String
    lateinit var sPhone: String

    private lateinit var mFirebaseDatabase: DatabaseReference
    private lateinit var mFirebaseInstance: FirebaseDatabase
    private lateinit var mDatabase: DatabaseReference

    private lateinit var preference: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        mFirebaseInstance = FirebaseDatabase.getInstance()
        mDatabase = FirebaseDatabase.getInstance().getReference()
        mFirebaseDatabase = mFirebaseInstance.getReference("User")

        preference = Preferences(this)

        btn_daftar.setOnClickListener {
            sUsername = et_username.text.toString()
            sPassword = et_password.text.toString()
            sNama = et_nama.text.toString()
            sEmail = et_email.text.toString()
            sAddress = et_address.text.toString()
            sPhone = et_phone.text.toString()

            if (sUsername.equals("")) {
                et_username.error = "Silakan isi Username"
                et_username.requestFocus()
            } else if (sPassword.equals("")) {
                et_password.error = "Silakan isi Password"
                et_password.requestFocus()
            } else if (sNama.equals("")) {
                et_nama.error = "Silakan isi Nama"
                et_nama.requestFocus()
            } else if (sEmail.equals("")) {
                et_email.error = "Silakan isi Email"
                et_email.requestFocus()
            } else if (sAddress.equals("")) {
                et_address.error = "Silakan isi Address"
                et_address.requestFocus()
            } else if (sPhone.equals("")) {
                et_phone.error = "Silakan isi Phone Number"
                et_phone.requestFocus()
            } else {
                saveUser(sUsername, sPassword, sNama, sEmail, sAddress, sPhone)
            }
        }
    }

    private fun saveUser(sUsername: String, sPassword: String, sNama: String, sEmail: String, sAddress: String, sPhone: String){

        val user = User()
        user.email = sEmail
        user.username = sUsername
        user.nama = sNama
        user.password = sPassword
        user.alamat = sAddress
        user.telp = sPhone

        if (sUsername != null){
            chackingUsername(sUsername, user)
        }
    }

    private fun chackingUsername(iUsername: String, data: User){
        mFirebaseDatabase.child(iUsername).addValueEventListener(object : ValueEventListener{
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                val user = dataSnapshot.getValue(User::class.java)
                if (user == null){
                    mFirebaseDatabase.child(iUsername).setValue(data)

                    preference.setValues("nama", data.nama.toString())
                    preference.setValues("user", data.username.toString())
                    preference.setValues("url", "")
                    preference.setValues("email", data.email.toString())
                    preference.setValues("alamat", data.alamat.toString())
                    preference.setValues("telp", data.telp.toString())
                    preference.setValues("status", "1")

                    val intent = Intent(this@SignUpActivity,MainActivity::class.java)
                        .putExtra("nama",data.nama)
                    startActivity(intent)
                }else{
                    Toast.makeText(this@SignUpActivity,"User sudah digunakan", Toast.LENGTH_LONG).show()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@SignUpActivity,""+error.message, Toast.LENGTH_LONG).show()
            }
        })
    }
}
