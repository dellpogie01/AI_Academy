package com.example

import com.example.data.data.AiAcademyData
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class ExampleRobolectricTest {

    @Test
    fun testAllElevenCategoriesPresent() {
        val categories = AiAcademyData.categories
        assertEquals("Must have exactly 11 categories", 11, categories.size)

        val categoryIds = categories.map { it.id }.toSet()
        val expectedCategories = setOf(
            "llm", "agentic", "rag", "embedding", "mcp",
            "security", "observability", "memory", "agent_sdk", "workflow", "vector_db"
        )
        assertEquals("All 11 category IDs must be present", expectedCategories, categoryIds)
    }

    @Test
    fun testTechnologyDatasetCompleteness() {
        val techs = AiAcademyData.technologies
        assertTrue("Must have at least 87 technologies defined", techs.size >= 87)

        techs.forEach { tech ->
            assertNotNull("Technology ID must not be null", tech.id)
            assertTrue("Name must not be empty", tech.name.isNotBlank())
            assertTrue("Overview must not be empty", tech.overview.isNotBlank())
            assertTrue("Main purpose must not be empty", tech.mainPurpose.isNotBlank())
            assertTrue("Key features must not be empty", tech.keyFeatures.isNotEmpty())
            assertTrue("Common uses must not be empty", tech.commonUses.isNotEmpty())
            assertTrue("Advantages must not be empty", tech.advantages.isNotEmpty())
            assertTrue("Limitations must not be empty", tech.limitations.isNotEmpty())
            assertTrue("Official URL must be valid", tech.officialUrl.startsWith("http"))
        }
    }

    @Test
    fun testSearchFunctionality() {
        val searchResults = AiAcademyData.searchTechnologies("LlamaIndex")
        assertTrue("Search for LlamaIndex must return results", searchResults.isNotEmpty())
        assertTrue("Result should contain LlamaIndex", searchResults.any { it.name.contains("LlamaIndex") })

        val llmResults = AiAcademyData.searchTechnologies("", "llm")
        assertEquals("LLM category filter should return 9 items", 9, llmResults.size)
    }
}
