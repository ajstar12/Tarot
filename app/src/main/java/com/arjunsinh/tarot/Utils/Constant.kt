package com.arjunsinh.tarot.Utils

import android.app.Activity
import android.content.Context
import android.util.Log
import com.arjunsinh.tarot.R
import com.arjunsinh.tarot.RoomDatabase.Model.CardModel
import com.arjunsinh.tarot.RoomDatabase.ViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object Constant {

    const val tag: String = "Arjun_Test"

    object keyWords {
        val All = "All"
        val MajorArcana = "MajorArcana"
        val MinorArcana = "MinorArcana"
        val Wands = "Wands"
        val Swords = "Swords"
        val Pentacles = "Pentacles"
        val Cups = "Cups"
        val Pages = "Pages"
        val Queens = "Queens"
        val Knights = "Knights"
        val Kings = "Kings"
        val Number1 = "Number1"
        val Number2 = "Number2"
        val Number3 = "Number3"
        val Number4 = "Number4"
        val Number5 = "Number5"
        val Number6 = "Number6"
        val Number7 = "Number7"
        val Number8 = "Number8"
        val Number9 = "Number9"
        val Number10 = "Number10"
    }

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

    val cardImages = mapOf(
        "aaa_00_the_fool" to R.drawable.aaa_00_the_fool,
        "aaa_01_the__magician" to R.drawable.aaa_01_the__magician,
        "aaa_02_high_priestess" to R.drawable.aaa_02_high_priestess,
        "aaa_03_empress" to R.drawable.aaa_03_empress,
        "aaa_04_emperor" to R.drawable.aaa_04_emperor,
        "aaa_05_hierophant" to R.drawable.aaa_05_hierophant,
        "aaa_06_lovers" to R.drawable.aaa_06_lovers,
        "aaa_07_chariot" to R.drawable.aaa_07_chariot,
        "aaa_08_strength" to R.drawable.aaa_08_strength,
        "aaa_09_hermit" to R.drawable.aaa_09_hermit,
        "aaa_10_wheel_of_fortune" to R.drawable.aaa_10_wheel_of_fortune,
        "aaa_11_justice" to R.drawable.aaa_11_justice,
        "aaa_12_hanged_man" to R.drawable.aaa_12_hanged_man,
        "aaa_13_death" to R.drawable.aaa_13_death,
        "aaa_14_temperance" to R.drawable.aaa_14_temperance,
        "aaa_15_devil" to R.drawable.aaa_15_devil,
        "aaa_16_tower" to R.drawable.aaa_16_tower,
        "aaa_17_star" to R.drawable.aaa_17_star,
        "aaa_18_moon" to R.drawable.aaa_18_moon,
        "aaa_19_sun" to R.drawable.aaa_19_sun,
        "aaa_20_judgement" to R.drawable.aaa_20_judgement,
        "aaa_21_world" to R.drawable.aaa_21_world,
        "aaa_cups01" to R.drawable.aaa_cups01,
        "aaa_cups02" to R.drawable.aaa_cups02,
        "aaa_cups03" to R.drawable.aaa_cups03,
        "aaa_cups04" to R.drawable.aaa_cups04,
        "aaa_cups05" to R.drawable.aaa_cups05,
        "aaa_cups06" to R.drawable.aaa_cups06,
        "aaa_cups07" to R.drawable.aaa_cups07,
        "aaa_cups08" to R.drawable.aaa_cups08,
        "aaa_cups09" to R.drawable.aaa_cups09,
        "aaa_cups10" to R.drawable.aaa_cups10,
        "aaa_cups11" to R.drawable.aaa_cups11,
        "aaa_cups12" to R.drawable.aaa_cups12,
        "aaa_cups13" to R.drawable.aaa_cups13,
        "aaa_cups14" to R.drawable.aaa_cups14,
        "aaa_pents01" to R.drawable.aaa_pents01,
        "aaa_pents02" to R.drawable.aaa_pents02,
        "aaa_pents03" to R.drawable.aaa_pents03,
        "aaa_pents04" to R.drawable.aaa_pents04,
        "aaa_pents05" to R.drawable.aaa_pents05,
        "aaa_pents06" to R.drawable.aaa_pents06,
        "aaa_pents07" to R.drawable.aaa_pents07,
        "aaa_pents08" to R.drawable.aaa_pents08,
        "aaa_pents09" to R.drawable.aaa_pents09,
        "aaa_pents10" to R.drawable.aaa_pents10,
        "aaa_pents11" to R.drawable.aaa_pents11,
        "aaa_pents12" to R.drawable.aaa_pents12,
        "aaa_pents13" to R.drawable.aaa_pents13,
        "aaa_pents14" to R.drawable.aaa_pents14,
        "aaa_swords01" to R.drawable.aaa_swords01,
        "aaa_swords02" to R.drawable.aaa_swords02,
        "aaa_swords03" to R.drawable.aaa_swords03,
        "aaa_swords04" to R.drawable.aaa_swords04,
        "aaa_swords05" to R.drawable.aaa_swords05,
        "aaa_swords06" to R.drawable.aaa_swords06,
        "aaa_swords07" to R.drawable.aaa_swords07,
        "aaa_swords08" to R.drawable.aaa_swords08,
        "aaa_swords09" to R.drawable.aaa_swords09,
        "aaa_swords10" to R.drawable.aaa_swords10,
        "aaa_swords11" to R.drawable.aaa_swords11,
        "aaa_swords12" to R.drawable.aaa_swords12,
        "aaa_swords13" to R.drawable.aaa_swords13,
        "aaa_swords14" to R.drawable.aaa_swords14,
        "aaa_wands01" to R.drawable.aaa_wands01,
        "aaa_wands02" to R.drawable.aaa_wands02,
        "aaa_wands03" to R.drawable.aaa_wands03,
        "aaa_wands04" to R.drawable.aaa_wands04,
        "aaa_wands05" to R.drawable.aaa_wands05,
        "aaa_wands06" to R.drawable.aaa_wands06,
        "aaa_wands07" to R.drawable.aaa_wands07,
        "aaa_wands08" to R.drawable.aaa_wands08,
        "aaa_wands09" to R.drawable.aaa_wands09,
        "aaa_wands10" to R.drawable.aaa_wands10,
        "aaa_wands11" to R.drawable.aaa_wands11,
        "aaa_wands12" to R.drawable.aaa_wands12,
        "aaa_wands13" to R.drawable.aaa_wands13,
        "aaa_wands14" to R.drawable.aaa_wands14,
    )
}