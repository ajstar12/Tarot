package com.arjunsinh.tarot.RoomDatabase

import android.content.Context
import android.os.AsyncTask
import androidx.room.Database
import androidx.room.DatabaseConfiguration
import androidx.room.InvalidationTracker
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.arjunsinh.tarot.RoomDatabase.Model.CardModel

@Database(entities = [CardModel::class
                     ],
    version = 2)
abstract class LocalDatabase  : RoomDatabase() {

    // below line is to create
    // abstract variable for dao.
    abstract fun Dao(): DaoFile?
    companion object{

        // below line is to create instance
        // for our database class.
        var instance: LocalDatabase? = null

        // on below line we are getting instance for our database.
        @Synchronized
        fun getInstance(context: Context): LocalDatabase { // below line is to check if
            // the instance is null or not.
            if (instance == null) { // if the instance is null we
                // are creating a new instance
                instance =  // for creating a instance for our database
                        // we are creating a database builder and passing
                        // our database class with our database name.
                    databaseBuilder<LocalDatabase>(context.getApplicationContext()!!, LocalDatabase::class.java, "order_database") // below line is use to add fall back to
                        // destructive migration to our database.
                        .fallbackToDestructiveMigration() // below line is to add callback
                        // to our database.
                        .addCallback(roomCallback) //below line is for migrate old data in new version database
//                        .addMigrations(MIGRATION_1_2) // below line is to
                        // build our database.
                        .build()
            } // after creating an instance
            // we are returning our instance
            return instance!!
        }

        // below line is to create a callback for our room database.
        val roomCallback: RoomDatabase.Callback = object : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db) // this method is called when database is created
                // and below line is to populate our data.
                PopulateDbAsyncTask(instance).execute()
            }
        }

        // we are creating an async task class to perform task in background.
        private class PopulateDbAsyncTask internal constructor(instance: LocalDatabase?) : AsyncTask<Void?, Void?, Void?>() {
            init {
                val dao: DaoFile? = instance!!.Dao()
            }

            override fun doInBackground(vararg voids: Void?): Void? {
                return null
            }
        }

        /*val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("""
            CREATE TABLE IF NOT EXISTS mst_memory (
                id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
                memory TEXT NOT NULL,
                character_id TEXT NOT NULL
            )
        """.trimIndent())
            }
        }*/
    }
    protected override fun createOpenHelper(config: DatabaseConfiguration): SupportSQLiteOpenHelper {
        return null!!
    }

    protected override fun createInvalidationTracker(): InvalidationTracker {
        return null!!
    }

    public override fun clearAllTables() {
    }

}