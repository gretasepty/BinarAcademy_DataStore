package binar.greta.datastore_pertemuan6.latihan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.asLiveData
import binar.greta.datastore_pertemuan6.R
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HomeActivity : AppCompatActivity() {

    lateinit var  userLatihan: UserLatihan

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        userLatihan = UserLatihan(this)

        userLatihan.userNama.asLiveData().observe(this, {
            txt_welcome.text = it.toString()
        })

        btn_keluar.setOnClickListener {

            GlobalScope.launch {
                userLatihan.hapusData()
                startActivity(Intent(this@HomeActivity, LoginActivity::class.java))
            }
        }
    }
}