package com.arjunsinh.tarot.RoomDatabase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.arjunsinh.tarot.RoomDatabase.Model.CardModel

@Dao
interface DaoFile {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(model: CardModel) : Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(models: List<CardModel>) : List<Long>
/*
    @Insert
    fun insertChoosenCharacter(model: ChoosedModel)

    @Insert
    fun insertChat(model: ChatModel)

    @Insert
    fun insertMemory(model: MemoryModel)

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