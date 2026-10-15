package com.example.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bookmarks")
data class BookmarkEntity(
    @PrimaryKey val technologyId: String,
    val bookmarkedAt: Long = System.currentTimeMillis()
)

@Entity(tableName = "recent_views")
data class RecentViewEntity(
    @PrimaryKey val technologyId: String,
    val viewedAt: Long = System.currentTimeMillis()
)
