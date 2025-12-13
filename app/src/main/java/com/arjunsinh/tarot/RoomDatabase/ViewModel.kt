package com.arjunsinh.tarot.RoomDatabase

import android.app.Activity
import android.app.Application
import androidx.lifecycle.LiveData
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
    fun getAllCard() : LiveData<List<CardModel>> {
        return repository!!.getAllCard()
    }
    fun getCardByArcana(arcana : String) : LiveData<List<CardModel>> {
        return repository!!.getCardByArcana(arcana)
    }
    fun getCardBySuit(suit : String) : LiveData<List<CardModel>> {
        return repository!!.getCardBySuit(suit)
    }
    fun getCardByRank(rank : String) : LiveData<List<CardModel>> {
        return repository!!.getCardByRank(rank)
    }

}