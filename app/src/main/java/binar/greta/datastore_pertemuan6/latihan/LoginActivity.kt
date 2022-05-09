package binar.greta.datastore_pertemuan6.latihan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.asLiveData
import binar.greta.datastore_pertemuan6.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    lateinit var userLatihan: UserLatihan
    lateinit var usernameLogin : String
    lateinit var passwordLogin : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        userLatihan = UserLatihan(this)

        btn_login.setOnClickListener {
            val usernameLog = edt_username.text.toString()
            val passwordLog = edt_password.text.toString()

            if (usernameLog == usernameLogin && passwordLog == passwordLogin){
                Toast.makeText(this, "Sukses Login", Toast.LENGTH_LONG).show()
                startActivity(Intent(this, HomeActivity::class.java))
            }else{
                Toast.makeText(this, "Gagal", Toast.LENGTH_LONG).show()
            }
        }

        userLatihan.userNama.asLiveData().observe(this,{
            usernameLogin = it.toString()
        })

        userLatihan.passWord.asLiveData().observe(this,{
            passwordLogin = it.toString()
        })


        txt_register.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}