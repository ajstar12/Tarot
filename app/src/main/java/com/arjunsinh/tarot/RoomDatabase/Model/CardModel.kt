package com.arjunsinh.tarot.RoomDatabase.Model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "mst_card")
class CardModel(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var image: String = "",
    var arcana: String = "",
    var card_name: String = "",
    var career_reversed: String = "",
    var career_upright: String = "",
    var core_reversed: String = "",
    var core_upright: String = "",
    var element: String = "",
    var keywords_reversed: String = "",
    var keywords_upright: String = "",
    var love_reversed: String = "",
    var love_upright: String = "",
    var number: Int = 0,
    var number_or_rank_meaning: String = "",
    var rank: String = "",
    var spiritual_reversed: String = "",
    var spiritual_upright: String = "",
    var suit: String = "",
    var suit_meaning: String = "",
    var summary_reversed: String = "",
    var summary_upright: String = ""
) : Parcelable