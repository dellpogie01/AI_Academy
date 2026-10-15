package com.example.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.SearchOff
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.data.model.Category
import com.example.data.model.Technology
import com.example.ui.components.SearchBarComponent
import com.example.ui.components.TechnologyCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    query: String,
    onQueryChange: (String) -> Unit,
    categories: List<Category>,
    selectedCategoryFilter: String?,
    onCategoryFilterSelect: (String?) -> Unit,
    searchResults: List<Technology>,
    bookmarkedIds: Set<String>,
    onBookmarkToggle: (String) -> Unit,
    onTechnologyClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 12.dp)
            .testTag("search_screen_column")
    ) {
        Text(
            text = "Search Technologies",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        SearchBarComponent(
            query = query,
            onQueryChange = onQueryChange,
            placeholder = "Search name, purpose, or capability..."
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Category Filter Chips
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(bottom = 12.dp)
        ) {
            item {
                FilterChip(
                    selected = selectedCategoryFilter == null,
                    onClick = { onCategoryFilterSelect(null) },
                    label = { Text("All Categories") },
                    modifier = Modifier.testTag("category_filter_chip_all")
                )
            }
            items(categories) { category ->
                FilterChip(
                    selected = selectedCategoryFilter == category.id,
                    onClick = { onCategoryFilterSelect(category.id) },
                    label = { Text(category.name) },
                    modifier = Modifier.testTag("category_filter_chip_${category.id}")
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Results (${searchResults.size})",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        if (searchResults.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(
                        imageVector = Icons.Default.SearchOff,
                        contentDescription = "No results",
                        tint = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.size(64.dp)
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = "No technologies found",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Try searching for a different keyword or clear category filters.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        } else {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.weight(1f)
            ) {
                items(searchResults) { tech ->
                    TechnologyCard(
                        technology = tech,
                        isBookmarked = bookmarkedIds.contains(tech.id),
                        onBookmarkToggle = { onBookmarkToggle(tech.id) },
                        onClick = { onTechnologyClick(tech.id) }
                    )
                }
            }
        }
    }
}
