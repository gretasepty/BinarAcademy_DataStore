package binar.greta.datastore_pertemuan6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.asLiveData
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var userManager: UserManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userManager = UserManager(this)

        btn_tampil.setOnClickListener {
            val nama = edt_nama.text.toString()
            val umur = edt_umur.text.toString().toInt()

            GlobalScope.launch {
                userManager.saveData(nama, umur)
            }
        }
        userManager.userNama.asLiveData().observe(this,{
            txt_nama.text = it.toString()
        })
        userManager.userUmur.asLiveData().observe(this,{
            txt_umur.text = it.toString()
        })

        btn_clear.setOnClickListener {
            GlobalScope.launch {
                userManager.hapusData()
            }
        }

    }
}
