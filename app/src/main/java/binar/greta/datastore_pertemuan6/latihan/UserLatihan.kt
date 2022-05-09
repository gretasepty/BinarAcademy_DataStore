package binar.greta.datastore_pertemuan6.latihan

import android.content.Context
import androidx.datastore.DataStore
import androidx.datastore.preferences.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserLatihan(context : Context) {

    private val dataUser : DataStore<Preferences> = context.createDataStore(name = "user_prefs")

    companion object{
        val USERNAME = preferencesKey<String>("USER_USERNAME")
        val PASSWORD = preferencesKey<String>("USER_PASSWORD")
    }

    suspend fun saveData(username : String, password : String){
        dataUser.edit {
            it[USERNAME] = username
            it[PASSWORD] = password
        }
    }

    val userNama : Flow<String> = dataUser.data.map {
        it[USERNAME] ?: ""
    }
    val passWord : Flow<String> = dataUser.data.map {
        it[PASSWORD] ?: ""
    }

    suspend fun hapusData(){
        dataUser.edit {
            it.clear()
        }
    }
}