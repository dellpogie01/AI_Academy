package com.example.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface BookmarkDao {
    @Query("SELECT * FROM bookmarks ORDER BY bookmarkedAt DESC")
    fun getAllBookmarks(): Flow<List<BookmarkEntity>>

    @Query("SELECT EXISTS(SELECT 1 FROM bookmarks WHERE technologyId = :techId)")
    fun isBookmarkedFlow(techId: String): Flow<Boolean>

    @Query("SELECT EXISTS(SELECT 1 FROM bookmarks WHERE technologyId = :techId)")
    suspend fun isBookmarked(techId: String): Boolean

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBookmark(bookmark: BookmarkEntity)

    @Query("DELETE FROM bookmarks WHERE technologyId = :techId")
    suspend fun deleteBookmark(techId: String)

    @Query("DELETE FROM bookmarks")
    suspend fun clearAllBookmarks()
}

@Dao
interface RecentViewDao {
    @Query("SELECT * FROM recent_views ORDER BY viewedAt DESC LIMIT 20")
    fun getRecentViews(): Flow<List<RecentViewEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun recordView(view: RecentViewEntity)

    @Query("DELETE FROM recent_views")
    suspend fun clearRecentViews()
}
