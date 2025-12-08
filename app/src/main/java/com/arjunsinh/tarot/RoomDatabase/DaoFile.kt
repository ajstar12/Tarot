package com.arjunsinh.tarot.RoomDatabase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.arjunsinh.tarot.RoomDatabase.Model.CardModel

@Dao
interface DaoFile {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(model: CardModel) : Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(models: List<CardModel>) : List<Long>

    @Query("SELECT * FROM mst_card ORDER BY id ASC")
    fun getAllCard(): LiveData<List<CardModel>>
/*

    @Query("SELECT * FROM mst_character ORDER BY id DESC")
    fun getAllCharacter(): MutableList<CharacterModel>

    @Query("SELECT * FROM mst_choosed_character ORDER BY id DESC")
    fun getChoosedCharacter(): MutableList<ChoosedModel>

    @Query("SELECT * FROM mst_chat where character_id = :character_id ORDER BY id DESC")
    fun getChatByCharacter(character_id : String): LiveData<List<ChatModel>>

    @Query("SELECT * FROM mst_memory where character_id = :character_id ORDER BY id ASC")
    fun getMemory(character_id : String): LiveData<List<MemoryModel>>

    @Query("DELETE FROM mst_character where id = :character_id")
    fun deleteCharacter(character_id : String)

    @Query("DELETE FROM mst_chat where character_id = :character_id")
    fun deleteChatByCharacter(character_id : String)

    @Query("DELETE FROM mst_chat where id = :id")
    fun deleteChatById(id : String)

    @Query("DELETE FROM mst_memory where character_id = :character_id")
    fun deleteMemoryByCharacter(character_id : String)*/
}