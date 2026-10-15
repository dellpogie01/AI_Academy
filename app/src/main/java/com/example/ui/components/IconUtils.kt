package com.example.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.MenuBook
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

fun getCategoryIcon(iconName: String): ImageVector {
    return when (iconName) {
        "Psychology" -> Icons.Default.Psychology
        "AccountTree" -> Icons.Default.AccountTree
        "MenuBook" -> Icons.AutoMirrored.Filled.MenuBook
        "Hub" -> Icons.Default.Hub
        "Extension" -> Icons.Default.Extension
        "Shield" -> Icons.Default.Shield
        "Analytics" -> Icons.Default.Analytics
        "Memory" -> Icons.Default.Memory
        "Code" -> Icons.Default.Code
        "AutoMode" -> Icons.Default.AutoMode
        "Storage" -> Icons.Default.Storage
        else -> Icons.Default.Category
    }
}
