package com.example.matchmate.data.Local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class UserEntity(
    @PrimaryKey val email: String,
    val fullName: String,
    val imageUrl: String,
    val age: Int,
    val location: String,
    val status: String // Accepted / Declined / Pending
)