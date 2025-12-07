package com.arjunsinh.tarot.Utils

import android.app.Activity
import android.content.Context
import com.arjunsinh.tarot.RoomDatabase.Model.CardModel
import com.arjunsinh.tarot.RoomDatabase.ViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object Constant {
    fun saveData(viewModel: ViewModel, list : List<CardModel>){
        viewModel.insertAll(list)
    }
}