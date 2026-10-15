package com.example.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Explore
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material.icons.outlined.Explore
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import com.example.ui.viewmodel.NavTab

data class BottomNavItem(
    val tab: NavTab,
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector
)

val navItems = listOf(
    BottomNavItem(
        tab = NavTab.HOME,
        title = "Home",
        selectedIcon = Icons.Default.Home,
        unselectedIcon = Icons.Outlined.Home
    ),
    BottomNavItem(
        tab = NavTab.EXPLORE,
        title = "Explore",
        selectedIcon = Icons.Default.Explore,
        unselectedIcon = Icons.Outlined.Explore
    ),
    BottomNavItem(
        tab = NavTab.SEARCH,
        title = "Search",
        selectedIcon = Icons.Default.Search,
        unselectedIcon = Icons.Outlined.Search
    ),
    BottomNavItem(
        tab = NavTab.BOOKMARKS,
        title = "Bookmarks",
        selectedIcon = Icons.Default.Bookmark,
        unselectedIcon = Icons.Outlined.BookmarkBorder
    ),
    BottomNavItem(
        tab = NavTab.SETTINGS,
        title = "Settings",
        selectedIcon = Icons.Default.Settings,
        unselectedIcon = Icons.Outlined.Settings
    )
)

@Composable
fun AppBottomNavigationBar(
    currentTab: NavTab,
    onTabSelected: (NavTab) -> Unit,
    modifier: Modifier = Modifier
) {
    NavigationBar(
        modifier = modifier.testTag("bottom_navigation_bar"),
        containerColor = MaterialTheme.colorScheme.surface,
        contentColor = MaterialTheme.colorScheme.onSurface
    ) {
        navItems.forEach { item ->
            val isSelected = currentTab == item.tab
            NavigationBarItem(
                selected = isSelected,
                onClick = { onTabSelected(item.tab) },
                icon = {
                    Icon(
                        imageVector = if (isSelected) item.selectedIcon else item.unselectedIcon,
                        contentDescription = item.title
                    )
                },
                label = { Text(item.title) },
                modifier = Modifier.testTag("nav_tab_${item.tab.name.lowercase()}")
            )
        }
    }
}
