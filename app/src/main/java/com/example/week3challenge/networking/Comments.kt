package com.example.week3challenge.networking

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName="comments_table")
data class Comments(
    @ColumnInfo(name="post_id")
    val postId: Int,
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "email")
    val email: String,
    @ColumnInfo(name="body")
    val body: String
)
