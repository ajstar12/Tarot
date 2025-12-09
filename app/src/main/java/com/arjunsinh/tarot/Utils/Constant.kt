package com.arjunsinh.tarot.Utils

import android.app.Activity
import android.content.Context
import android.util.Log
import com.arjunsinh.tarot.RoomDatabase.Model.CardModel
import com.arjunsinh.tarot.RoomDatabase.ViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object Constant {

    const val tag: String = "Arjun_Test"

    fun log(type: String, data: String, e: Throwable) {
        Log.e(tag, "$tag $type : $data", e)
    }

    fun log(type: String, data: String) {
        val maxLogSize = 1000
        for (i in 0..data.length / maxLogSize) {
            val start = i * maxLogSize
            var end = (i + 1) * maxLogSize
            end = if (end > data.length) data.length else end
            Log.e(tag, tag + " " + type + " : " + data.substring(start, end))
        }
    }

    fun log(type: String, params: Map<String, String>) {
        var result = ""
        for (entry in params.entries) {
            result = result + "\n" + entry.key + ":" + entry.value
        }
        Log.e(tag, tag + " " + type + " : " + result)
    }

    fun saveData(viewModel: ViewModel, list : List<CardModel>){
        viewModel.insertAll(list)
    }
}