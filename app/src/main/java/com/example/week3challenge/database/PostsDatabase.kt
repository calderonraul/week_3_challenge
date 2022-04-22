package com.example.week3challenge.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.week3challenge.networking.Comments
import com.example.week3challenge.networking.Posts


@Database(entities = [Posts::class,Comments::class], version = 1, exportSchema = false)
abstract class PostsDatabase : RoomDatabase() {

    abstract val postsDatabase: PostsDAO

    companion object {
        @Volatile
        private var INSTANCE: PostsDatabase? = null
        fun getInstance(context: Context): PostsDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        PostsDatabase::class.java,
                        "posts_database"
                    ).allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()

                    INSTANCE = instance
                }
                return instance
            }

        }
    }

}