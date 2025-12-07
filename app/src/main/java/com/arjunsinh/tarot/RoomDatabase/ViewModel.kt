package com.arjunsinh.tarot.RoomDatabase

import android.app.Activity
import android.app.Application
import com.arjunsinh.tarot.RoomDatabase.Model.CardModel

class ViewModel(application: Application, activity: Activity?) {

    // creating a new variable for course repository.
    private var repository: RoomRepository? = RoomRepository(application, activity)

    fun insert(model: CardModel) {
//        viewModelScope.launch(Dispatchers.IO) {
            repository!!.insert(model)
//        }
    }
    fun insertAll(model: List<CardModel>) {
        repository!!.insertAll(model)
    }

}