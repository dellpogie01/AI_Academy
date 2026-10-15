package com.example.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.ui.viewmodel.ThemeMode

@Composable
fun SettingsScreen(
    currentTheme: ThemeMode,
    onThemeSelect: (ThemeMode) -> Unit,
    onClearHistory: () -> Unit,
    onClearBookmarks: () -> Unit,
    modifier: Modifier = Modifier
) {
    var showClearHistoryDialog by remember { mutableStateOf(false) }
    var showClearBookmarksDialog by remember { mutableStateOf(false) }

    if (showClearHistoryDialog) {
        AlertDialog(
            onDismissRequest = { showClearHistoryDialog = false },
            title = { Text("Clear Viewing History?") },
            text = { Text("This will reset your list of recently viewed technologies.") },
            confirmButton = {
                TextButton(
                    onClick = {
                        onClearHistory()
                        showClearHistoryDialog = false
                    }
                ) {
                    Text("Clear")
                }
            },
            dismissButton = {
                TextButton(onClick = { showClearHistoryDialog = false }) {
                    Text("Cancel")
                }
            }
        )
    }

    if (showClearBookmarksDialog) {
        AlertDialog(
            onDismissRequest = { showClearBookmarksDialog = false },
            title = { Text("Clear All Bookmarks?") },
            text = { Text("This will remove all saved technologies from your bookmarks list.") },
            confirmButton = {
                TextButton(
                    onClick = {
                        onClearBookmarks()
                        showClearBookmarksDialog = false
                    }
                ) {
                    Text("Clear All")
                }
            },
            dismissButton = {
                TextButton(onClick = { showClearBookmarksDialog = false }) {
                    Text("Cancel")
                }
            }
        )
    }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .testTag("settings_screen_column"),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Text(
                text = "App Preferences",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground
            )
        }

        // Appearance Theme Settings
        item {
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                ),
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .border(
                        1.dp,
                        MaterialTheme.colorScheme.outline.copy(alpha = 0.35f),
                        RoundedCornerShape(16.dp)
                    )
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.Palette,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = "Theme Selection",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    // Three identical options: same weight (width), height, padding, icon size and text style.
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        ThemeOptionButton(
                            label = "Light",
                            icon = Icons.Default.LightMode,
                            selected = currentTheme == ThemeMode.LIGHT,
                            onClick = { onThemeSelect(ThemeMode.LIGHT) },
                            modifier = Modifier
                                .weight(1f)
                                .testTag("theme_light_chip")
                        )
                        ThemeOptionButton(
                            label = "Dark",
                            icon = Icons.Default.DarkMode,
                            selected = currentTheme == ThemeMode.DARK,
                            onClick = { onThemeSelect(ThemeMode.DARK) },
                            modifier = Modifier
                                .weight(1f)
                                .testTag("theme_dark_chip")
                        )
                        ThemeOptionButton(
                            label = "System",
                            icon = Icons.Default.BrightnessAuto,
                            selected = currentTheme == ThemeMode.SYSTEM,
                            onClick = { onThemeSelect(ThemeMode.SYSTEM) },
                            modifier = Modifier
                                .weight(1f)
                                .testTag("theme_system_chip")
                        )
                    }
                }
            }
        }

        // Storage & Cache Reset
        item {
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface
                ),
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .border(
                        1.dp,
                        MaterialTheme.colorScheme.outline.copy(alpha = 0.35f),
                        RoundedCornerShape(16.dp)
                    )
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Data & Local Persistence",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.padding(bottom = 12.dp)
                    )

                    OutlinedButton(
                        onClick = { showClearHistoryDialog = true },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Icon(Icons.Default.History, contentDescription = null)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Clear Viewing History")
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    // Uses the same default button colors as "Clear Viewing History".
                    OutlinedButton(
                        onClick = { showClearBookmarksDialog = true },
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("clear_bookmarks_button")
                    ) {
                        Icon(Icons.Default.BookmarkRemove, contentDescription = null)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Clear All Saved Bookmarks")
                    }
                }
            }
        }
    }
}

/**
 * A single theme choice. All three options share this composable so their size,
 * typography, icon size and styling are guaranteed to be identical.
 */
@Composable
private fun ThemeOptionButton(
    label: String,
    icon: ImageVector,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val contentColor = if (selected) {
        MaterialTheme.colorScheme.primary
    } else {
        MaterialTheme.colorScheme.onSurfaceVariant
    }
    val containerColor = if (selected) {
        MaterialTheme.colorScheme.primary.copy(alpha = 0.15f)
    } else {
        Color.Transparent
    }
    val borderColor = if (selected) {
        MaterialTheme.colorScheme.primary
    } else {
        MaterialTheme.colorScheme.outline
    }

    Surface(
        shape = RoundedCornerShape(8.dp),
        color = containerColor,
        contentColor = contentColor,
        border = BorderStroke(1.dp, borderColor),
        modifier = modifier
            .height(40.dp)
            .clip(RoundedCornerShape(8.dp))
            .selectable(
                selected = selected,
                onClick = onClick,
                role = Role.RadioButton
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                modifier = Modifier.size(18.dp)
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                text = label,
                style = MaterialTheme.typography.labelLarge,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}
