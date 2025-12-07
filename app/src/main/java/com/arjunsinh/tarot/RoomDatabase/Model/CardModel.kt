package com.arjunsinh.tarot.RoomDatabase.Model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "mst_card")
class CardModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val arcana: String,
    val card_name: String,
    val career_reversed: String,
    val career_upright: String,
    val core_reversed: String,
    val core_upright: String,
    val element: String,
    val keywords_reversed: String,
    val keywords_upright: String,
    val love_reversed: String,
    val love_upright: String,
    val number: Int,
    val number_or_rank_meaning: String,
    val rank: String,
    val spiritual_reversed: String,
    val spiritual_upright: String,
    val suit: String,
    val suit_meaning: String,
    val summary_reversed: String,
    val summary_upright: String
)