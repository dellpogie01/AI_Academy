package com.example.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.data.model.Technology
import com.example.ui.components.SearchBarComponent
import com.example.ui.components.TechnologyCard

@Composable
fun BookmarksScreen(
    bookmarkedTechs: List<Technology>,
    onBookmarkToggle: (String) -> Unit,
    onTechnologyClick: (String) -> Unit,
    onClearBookmarks: () -> Unit,
    onExploreClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    var query by remember { mutableStateOf("") }
    var showClearDialog by remember { mutableStateOf(false) }

    val filteredTechs = remember(query, bookmarkedTechs) {
        if (query.isBlank()) {
            bookmarkedTechs
        } else {
            bookmarkedTechs.filter {
                it.name.contains(query, ignoreCase = true) ||
                it.mainPurpose.contains(query, ignoreCase = true)
            }
        }
    }

    if (showClearDialog) {
        AlertDialog(
            onDismissRequest = { showClearDialog = false },
            title = { Text("Clear All Bookmarks?") },
            text = { Text("This will remove all saved technologies from your bookmarks list.") },
            confirmButton = {
                TextButton(
                    onClick = {
                        onClearBookmarks()
                        showClearDialog = false
                    }
                ) {
                    Text("Clear All")
                }
            },
            dismissButton = {
                TextButton(onClick = { showClearDialog = false }) {
                    Text("Cancel")
                }
            }
        )
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .testTag("bookmarks_screen_column")
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "Saved Bookmarks",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Text(
                    text = "${bookmarkedTechs.size} technologies saved",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            if (bookmarkedTechs.isNotEmpty()) {
                IconButton(onClick = { showClearDialog = true }) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "Clear all bookmarks",
                        tint = MaterialTheme.colorScheme.error
                    )
                }
            }
        }

        if (bookmarkedTechs.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(
                        imageVector = Icons.Default.BookmarkBorder,
                        contentDescription = "No bookmarks",
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(64.dp)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "No Bookmarks Saved Yet",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = "Tap the bookmark icon on any technology card to save it for offline reading.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.padding(horizontal = 24.dp)
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Button(onClick = onExploreClick) {
                        Text("Explore Technologies")
                    }
                }
            }
        } else {
            SearchBarComponent(
                query = query,
                onQueryChange = { query = it },
                placeholder = "Search saved bookmarks..."
            )

            Spacer(modifier = Modifier.height(12.dp))

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.weight(1f)
            ) {
                items(filteredTechs) { tech ->
                    TechnologyCard(
                        technology = tech,
                        isBookmarked = true,
                        onBookmarkToggle = { onBookmarkToggle(tech.id) },
                        onClick = { onTechnologyClick(tech.id) }
                    )
                }
            }
        }
    }
}
