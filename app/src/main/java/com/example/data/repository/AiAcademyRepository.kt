package com.example.data.repository

import com.example.data.data.AiAcademyData
import com.example.data.local.BookmarkDao
import com.example.data.local.BookmarkEntity
import com.example.data.local.RecentViewDao
import com.example.data.local.RecentViewEntity
import com.example.data.model.Category
import com.example.data.model.Technology
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AiAcademyRepository(
    private val bookmarkDao: BookmarkDao,
    private val recentViewDao: RecentViewDao
) {
    fun getCategories(): List<Category> {
        return AiAcademyData.categories.map { category ->
            val count = AiAcademyData.getTechnologiesForCategory(category.id).size
            category.copy(technologyCount = count)
        }
    }

    fun getCategoryById(id: String): Category? = AiAcademyData.getCategoryById(id)

    fun getAllTechnologies(): List<Technology> = AiAcademyData.technologies

    fun getTechnologyById(id: String): Technology? = AiAcademyData.getTechnologyById(id)

    fun getTechnologiesForCategory(categoryId: String): List<Technology> =
        AiAcademyData.getTechnologiesForCategory(categoryId)

    fun searchTechnologies(query: String, categoryIdFilter: String? = null): List<Technology> =
        AiAcademyData.searchTechnologies(query, categoryIdFilter)

    val bookmarkedTechnologyIds: Flow<Set<String>> = bookmarkDao.getAllBookmarks()
        .map { list -> list.map { it.technologyId }.toSet() }

    val bookmarkedTechnologies: Flow<List<Technology>> = bookmarkDao.getAllBookmarks()
        .map { list ->
            list.mapNotNull { AiAcademyData.getTechnologyById(it.technologyId) }
        }

    val recentViewedTechnologies: Flow<List<Technology>> = recentViewDao.getRecentViews()
        .map { list ->
            list.mapNotNull { AiAcademyData.getTechnologyById(it.technologyId) }
        }

    fun isBookmarkedFlow(techId: String): Flow<Boolean> = bookmarkDao.isBookmarkedFlow(techId)

    suspend fun toggleBookmark(techId: String) {
        val isBookmarked = bookmarkDao.isBookmarked(techId)
        if (isBookmarked) {
            bookmarkDao.deleteBookmark(techId)
        } else {
            bookmarkDao.insertBookmark(BookmarkEntity(technologyId = techId))
        }
    }

    suspend fun recordView(techId: String) {
        recentViewDao.recordView(RecentViewEntity(technologyId = techId))
    }

    suspend fun clearHistory() {
        recentViewDao.clearRecentViews()
    }

    suspend fun clearBookmarks() {
        bookmarkDao.clearAllBookmarks()
    }
}
