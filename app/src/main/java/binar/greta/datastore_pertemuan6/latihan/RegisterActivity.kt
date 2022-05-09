package binar.greta.datastore_pertemuan6.latihan

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import binar.greta.datastore_pertemuan6.R
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RegisterActivity : AppCompatActivity() {
    lateinit var userLatihan: UserLatihan

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        userLatihan = UserLatihan(this)

        btn_register.setOnClickListener {
            val username = edt_usernameRegis.text.toString()
            val password = edt_passwordRegis.text.toString()


            GlobalScope.launch {
                userLatihan.saveData(username, password)
                startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))
            }


            }


        }



}