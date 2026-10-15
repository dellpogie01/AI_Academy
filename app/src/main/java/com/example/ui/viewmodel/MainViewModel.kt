package com.example.ui.viewmodel

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.local.AppDatabase
import com.example.data.model.Category
import com.example.data.model.Technology
import com.example.data.repository.AiAcademyRepository
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

enum class NavTab {
    HOME, EXPLORE, SEARCH, BOOKMARKS, SETTINGS
}

sealed class Screen {
    data class Tab(val tab: NavTab) : Screen()
    data class CategoryDetail(val categoryId: String) : Screen()
    data class TechnologyDetail(val technologyId: String) : Screen()
    data class Compare(val techId1: String? = null, val techId2: String? = null) : Screen()
}

data class UiState(
    val currentScreen: Screen = Screen.Tab(NavTab.HOME),
    val activeTab: NavTab = NavTab.HOME,
    val categories: List<Category> = emptyList(),
    val bookmarkedIds: Set<String> = emptySet(),
    val bookmarkedTechs: List<Technology> = emptyList(),
    val recentViewedTechs: List<Technology> = emptyList(),
    val featuredTech: Technology? = null,
    val themeMode: ThemeMode = ThemeMode.SYSTEM
)

enum class ThemeMode {
    SYSTEM, DARK, LIGHT
}

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val db = AppDatabase.getDatabase(application)
    private val repository = AiAcademyRepository(
        bookmarkDao = db.bookmarkDao(),
        recentViewDao = db.recentViewDao()
    )

    private val _currentScreen = MutableStateFlow<Screen>(Screen.Tab(NavTab.HOME))
    private val _activeTab = MutableStateFlow(NavTab.HOME)
    private val _themeMode = MutableStateFlow(ThemeMode.DARK)

    /**
     * Search input is held in synchronous Compose state (not routed through the combined
     * StateFlow) so the text field and results update in the same frame on every keystroke,
     * with no dropped characters or stale results.
     */
    var searchQuery by mutableStateOf("")
        private set

    var selectedCategoryFilter by mutableStateOf<String?>(null)
        private set

    private val userNavState = combine(
        _currentScreen,
        _activeTab,
        _themeMode
    ) { screen, tab, theme ->
        NavState(screen, tab, theme)
    }

    private val dbState = combine(
        repository.bookmarkedTechnologyIds,
        repository.bookmarkedTechnologies,
        repository.recentViewedTechnologies
    ) { bookmarkedIds, bookmarkedTechs, recents ->
        DbData(bookmarkedIds, bookmarkedTechs, recents)
    }

    val uiState: StateFlow<UiState> = combine(
        userNavState,
        dbState
    ) { nav, dbData ->
        val categories = repository.getCategories()
        val featured = repository.getAllTechnologies().find { it.id == "openai_gpt" }
            ?: repository.getAllTechnologies().firstOrNull()

        UiState(
            currentScreen = nav.screen,
            activeTab = nav.tab,
            categories = categories,
            bookmarkedIds = dbData.bookmarkedIds,
            bookmarkedTechs = dbData.bookmarkedTechs,
            recentViewedTechs = dbData.recents,
            featuredTech = featured,
            themeMode = nav.theme
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = UiState()
    )

    fun selectTab(tab: NavTab) {
        _activeTab.value = tab
        _currentScreen.value = Screen.Tab(tab)
    }

    fun openCategory(categoryId: String) {
        _currentScreen.value = Screen.CategoryDetail(categoryId)
    }

    fun openTechnology(technologyId: String) {
        viewModelScope.launch {
            repository.recordView(technologyId)
        }
        _currentScreen.value = Screen.TechnologyDetail(technologyId)
    }

    fun openCompare(techId1: String? = null, techId2: String? = null) {
        _currentScreen.value = Screen.Compare(techId1, techId2)
    }

    fun updateSearchQuery(query: String) {
        searchQuery = query
    }

    fun setCategoryFilter(categoryId: String?) {
        selectedCategoryFilter = when {
            categoryId == null -> null
            selectedCategoryFilter == categoryId -> null
            else -> categoryId
        }
    }

    fun searchTechnologies(query: String, categoryIdFilter: String? = null): List<Technology> =
        repository.searchTechnologies(query, categoryIdFilter)

    fun toggleBookmark(techId: String) {
        viewModelScope.launch {
            repository.toggleBookmark(techId)
        }
    }

    fun setThemeMode(mode: ThemeMode) {
        _themeMode.value = mode
    }

    fun clearHistory() {
        viewModelScope.launch {
            repository.clearHistory()
        }
    }

    fun clearBookmarks() {
        viewModelScope.launch {
            repository.clearBookmarks()
        }
    }

    fun navigateBack(): Boolean {
        val current = _currentScreen.value
        return if (current !is Screen.Tab) {
            _currentScreen.value = Screen.Tab(_activeTab.value)
            true
        } else {
            false
        }
    }

    fun getCategoryById(id: String): Category? = repository.getCategoryById(id)

    fun getTechnologyById(id: String): Technology? = repository.getTechnologyById(id)

    fun getAllTechnologies(): List<Technology> = repository.getAllTechnologies()

    fun getTechnologiesForCategory(categoryId: String): List<Technology> =
        repository.getTechnologiesForCategory(categoryId)
}

private data class NavState(
    val screen: Screen,
    val tab: NavTab,
    val theme: ThemeMode
)

private data class DbData(
    val bookmarkedIds: Set<String>,
    val bookmarkedTechs: List<Technology>,
    val recents: List<Technology>
)
