package com.example.week3challenge.database

import androidx.room.*
import com.example.week3challenge.networking.Comments
import com.example.week3challenge.networking.Posts


@Dao
interface PostsDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(post: Posts)

    @Update
    fun update(post: Posts)

    @Query("SELECT * from post_table WHERE id = :key")
    fun get(key: Long): Posts?

    @Query("DELETE FROM post_table")
    fun clear()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(comments: Comments)

    @Update
    fun update(comments: Comments)

  /*  @Transaction
    @Query("SELECT * FROM comments_table")
    fun getUsersWithPlaylists(): List<PostsWithComments>
*/
}