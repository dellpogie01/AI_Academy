package com.example.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.ui.components.AppBottomNavigationBar
import com.example.ui.viewmodel.MainViewModel
import com.example.ui.viewmodel.NavTab

/** Route constants for the app's Jetpack Navigation graph. */
object Routes {
    const val HOME = "home"
    const val EXPLORE = "explore"
    const val SEARCH = "search"
    const val BOOKMARKS = "bookmarks"
    const val SETTINGS = "settings"
    const val CATEGORY_DETAIL = "category_detail/{categoryId}"
    const val TECH_DETAIL = "tech_detail/{technologyId}"
    const val COMPARE = "compare?techId1={techId1}&techId2={techId2}"

    fun categoryDetail(categoryId: String) = "category_detail/$categoryId"
    fun techDetail(technologyId: String) = "tech_detail/$technologyId"
    fun compare(techId1: String? = null): String =
        if (techId1 == null) "compare" else "compare?techId1=$techId1"

    val topLevel = setOf(HOME, EXPLORE, SEARCH, BOOKMARKS, SETTINGS)

    fun forTab(tab: NavTab): String = when (tab) {
        NavTab.HOME -> HOME
        NavTab.EXPLORE -> EXPLORE
        NavTab.SEARCH -> SEARCH
        NavTab.BOOKMARKS -> BOOKMARKS
        NavTab.SETTINGS -> SETTINGS
    }
}

/** Switches bottom-nav tabs without stacking duplicate destinations, preserving tab state. */
private fun NavHostController.navigateToTab(tab: NavTab) {
    navigate(Routes.forTab(tab)) {
        popUpTo(graph.findStartDestination().id) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
}

@Composable
fun MainScreen(
    viewModel: MainViewModel
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    val navController = rememberNavController()

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val showBottomBar = currentRoute == null || currentRoute in Routes.topLevel

    val currentTab = when (currentRoute) {
        Routes.EXPLORE -> NavTab.EXPLORE
        Routes.SEARCH -> NavTab.SEARCH
        Routes.BOOKMARKS -> NavTab.BOOKMARKS
        Routes.SETTINGS -> NavTab.SETTINGS
        else -> NavTab.HOME
    }

    Scaffold(
        bottomBar = {
            if (showBottomBar) {
                AppBottomNavigationBar(
                    currentTab = currentTab,
                    onTabSelected = { tab -> navController.navigateToTab(tab) }
                )
            }
        }
    ) { padding ->
        Box(modifier = Modifier.padding(padding)) {
            NavHost(
                navController = navController,
                startDestination = Routes.HOME
            ) {
                composable(Routes.HOME) {
                    HomeScreen(
                        categories = state.categories,
                        featuredTech = state.featuredTech,
                        recentlyViewed = state.recentViewedTechs,
                        bookmarkedIds = state.bookmarkedIds,
                        onCategoryClick = { catId ->
                            if (catId.isEmpty()) {
                                navController.navigateToTab(NavTab.EXPLORE)
                            } else {
                                navController.navigate(Routes.categoryDetail(catId))
                            }
                        },
                        onTechnologyClick = { techId ->
                            navController.navigate(Routes.techDetail(techId))
                        },
                        onBookmarkToggle = { viewModel.toggleBookmark(it) },
                        onCompareClick = { navController.navigate(Routes.compare()) }
                    )
                }

                composable(Routes.EXPLORE) {
                    ExploreScreen(
                        categories = state.categories,
                        bookmarkedIds = state.bookmarkedIds,
                        onSearchTechnologies = { query -> viewModel.searchTechnologies(query) },
                        onCategoryClick = { catId ->
                            navController.navigate(Routes.categoryDetail(catId))
                        },
                        onTechnologyClick = { techId ->
                            navController.navigate(Routes.techDetail(techId))
                        },
                        onBookmarkToggle = { viewModel.toggleBookmark(it) }
                    )
                }

                composable(Routes.SEARCH) {
                    // Read synchronously from Compose state so results track every keystroke.
                    val query = viewModel.searchQuery
                    val filter = viewModel.selectedCategoryFilter
                    val results = remember(query, filter) {
                        viewModel.searchTechnologies(query, filter)
                    }

                    SearchScreen(
                        query = query,
                        onQueryChange = { viewModel.updateSearchQuery(it) },
                        categories = state.categories,
                        selectedCategoryFilter = filter,
                        onCategoryFilterSelect = { viewModel.setCategoryFilter(it) },
                        searchResults = results,
                        bookmarkedIds = state.bookmarkedIds,
                        onBookmarkToggle = { viewModel.toggleBookmark(it) },
                        onTechnologyClick = { techId ->
                            navController.navigate(Routes.techDetail(techId))
                        }
                    )
                }

                composable(Routes.BOOKMARKS) {
                    BookmarksScreen(
                        bookmarkedTechs = state.bookmarkedTechs,
                        onBookmarkToggle = { viewModel.toggleBookmark(it) },
                        onTechnologyClick = { techId ->
                            navController.navigate(Routes.techDetail(techId))
                        },
                        onClearBookmarks = { viewModel.clearBookmarks() },
                        onExploreClick = { navController.navigateToTab(NavTab.EXPLORE) }
                    )
                }

                composable(Routes.SETTINGS) {
                    SettingsScreen(
                        currentTheme = state.themeMode,
                        onThemeSelect = { viewModel.setThemeMode(it) },
                        onClearHistory = { viewModel.clearHistory() },
                        onClearBookmarks = { viewModel.clearBookmarks() }
                    )
                }

                composable(
                    route = Routes.CATEGORY_DETAIL,
                    arguments = listOf(navArgument("categoryId") { type = NavType.StringType })
                ) { backStackEntry ->
                    val categoryId = backStackEntry.arguments?.getString("categoryId").orEmpty()
                    val category = viewModel.getCategoryById(categoryId)
                    if (category != null) {
                        CategoryDetailScreen(
                            category = category,
                            technologies = viewModel.getTechnologiesForCategory(categoryId),
                            bookmarkedIds = state.bookmarkedIds,
                            onBookmarkToggle = { viewModel.toggleBookmark(it) },
                            onTechnologyClick = { techId ->
                                navController.navigate(Routes.techDetail(techId))
                            },
                            onBackClick = { navController.popBackStack() }
                        )
                    }
                }

                composable(
                    route = Routes.TECH_DETAIL,
                    arguments = listOf(navArgument("technologyId") { type = NavType.StringType })
                ) { backStackEntry ->
                    val techId = backStackEntry.arguments?.getString("technologyId").orEmpty()
                    LaunchedEffect(techId) {
                        // Records the view in Room for "Recently Viewed".
                        viewModel.openTechnology(techId)
                    }
                    val tech = viewModel.getTechnologyById(techId)
                    if (tech != null) {
                        val category = viewModel.getCategoryById(tech.categoryId)
                        val related = tech.relatedTechIds.mapNotNull { viewModel.getTechnologyById(it) }

                        TechnologyDetailScreen(
                            technology = tech,
                            categoryName = category?.name,
                            relatedTechnologies = related,
                            isBookmarked = state.bookmarkedIds.contains(tech.id),
                            onBookmarkToggle = { viewModel.toggleBookmark(tech.id) },
                            onTechnologyClick = { relatedId ->
                                navController.navigate(Routes.techDetail(relatedId))
                            },
                            onCompareClick = { compareId ->
                                navController.navigate(Routes.compare(compareId))
                            },
                            onBackClick = { navController.popBackStack() }
                        )
                    }
                }

                composable(
                    route = Routes.COMPARE,
                    arguments = listOf(
                        navArgument("techId1") {
                            type = NavType.StringType
                            nullable = true
                            defaultValue = null
                        },
                        navArgument("techId2") {
                            type = NavType.StringType
                            nullable = true
                            defaultValue = null
                        }
                    )
                ) { backStackEntry ->
                    CompareScreen(
                        initialTechId1 = backStackEntry.arguments?.getString("techId1"),
                        initialTechId2 = backStackEntry.arguments?.getString("techId2"),
                        // Always offer the full catalogue, independent of any active search.
                        allTechnologies = viewModel.getAllTechnologies(),
                        onBackClick = { navController.popBackStack() }
                    )
                }
            }
        }
    }
}
