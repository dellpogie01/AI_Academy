package com.example

import com.example.data.data.AiAcademyData
import org.junit.Assert.*
import org.junit.Test

class ExampleUnitTest {

    @Test
    fun testAllElevenCategoriesCount() {
        assertEquals("Should have exactly 11 categories", 11, AiAcademyData.categories.size)
    }

    @Test
    fun testTotalTechnologiesCount() {
        val total = AiAcademyData.technologies.size
        assertTrue("Should have at least 87 technologies, found $total", total >= 87)
    }

    @Test
    fun testSearchEmptyReturnsAll() {
        val all = AiAcademyData.searchTechnologies("")
        assertEquals(AiAcademyData.technologies.size, all.size)

        val whitespaceOnly = AiAcademyData.searchTechnologies("   ")
        assertEquals(AiAcademyData.technologies.size, whitespaceOnly.size)
    }

    @Test
    fun testSearchFilteringBySingleAndMultipleTokens() {
        // Single term
        val claudeResults = AiAcademyData.searchTechnologies("claude")
        assertTrue("Should find Claude", claudeResults.any { it.name.contains("Claude") })

        // Multiple terms
        val promptSecurityResults = AiAcademyData.searchTechnologies("prompt security")
        assertTrue("Should find Prompt Security", promptSecurityResults.any { it.name.equals("Prompt Security", ignoreCase = true) })

        // Category filter
        val ragOnly = AiAcademyData.searchTechnologies("lang", "rag")
        assertTrue("All results should belong to rag category", ragOnly.all { it.categoryId == "rag" })
    }

    @Test
    fun testSearchRelevanceRanking() {
        val results = AiAcademyData.searchTechnologies("redis")
        assertTrue("Results should not be empty", results.isNotEmpty())
        // Exact name match or starting with name should be at the top
        assertTrue("Top result should be Redis", results.first().name.contains("Redis", ignoreCase = true))
    }

    @Test
    fun testSearchCategoryNameFindsMemberTechnologies() {
        val mcpResults = AiAcademyData.searchTechnologies("Model Context Protocol")
        assertTrue("Should find technologies under Model Context Protocol", mcpResults.size >= 8)
    }
}
