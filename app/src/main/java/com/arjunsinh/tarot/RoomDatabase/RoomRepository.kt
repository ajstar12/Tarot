package com.arjunsinh.tarot.RoomDatabase

import android.app.Activity
import android.app.Application
import com.arjunsinh.tarot.RoomDatabase.Model.CardModel

class RoomRepository(application: Application, activity: Activity?) {

    private var dao: DaoFile? = null
    var activity: Activity? = null

    val database: LocalDatabase? = LocalDatabase.getInstance(application)
    init {
        dao = database!!.Dao()
        this.activity = activity
    }

    fun insert(model: CardModel) {
        Thread(object : Runnable {
            override fun run() {
                dao!!.insert(model)
            }
        }).start()
    }

    fun insertAll(model: List<CardModel>) {
        Thread(object : Runnable {
            override fun run() {
                dao!!.insertAll(model)
            }
        }).start()
    }

    /*

    // below method is to read all the courses.
    fun getAllCharacter(mycallbackClass: MycallbackClass) {
        Thread(object : Runnable {
            override fun run() {
                val list: MutableList<CharacterModel> = dao!!.getAllCharacter()
                activity!!.runOnUiThread(object : Runnable {
                    override fun run() {
                        mycallbackClass.listAllCharacterCallBack(list)
                    }
                })
            }
        }).start()
    }

    fun getChatByCharacter(character_id : String) : LiveData<List<ChatModel>> {
        return dao!!.getChatByCharacter(character_id)
    }*/
}