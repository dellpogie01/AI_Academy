package com.example.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.CompareArrows
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.model.Technology

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CompareScreen(
    initialTechId1: String?,
    initialTechId2: String?,
    allTechnologies: List<Technology>,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    BackHandler { onBackClick() }

    var selectedTech1Id by remember {
        mutableStateOf(initialTechId1 ?: allTechnologies.firstOrNull()?.id ?: "")
    }

    var selectedTech2Id by remember {
        mutableStateOf(initialTechId2 ?: allTechnologies.getOrNull(1)?.id ?: "")
    }

    val tech1 = remember(selectedTech1Id, allTechnologies) {
        allTechnologies.find { it.id == selectedTech1Id }
    }

    val tech2 = remember(selectedTech2Id, allTechnologies) {
        allTechnologies.find { it.id == selectedTech2Id }
    }

    var expandedDropdown1 by remember { mutableStateOf(false) }
    var expandedDropdown2 by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Side-by-Side Comparison",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background
                )
            )
        },
        modifier = modifier.testTag("compare_screen")
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Technology Picker Row
            item {
                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surface
                    ),
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.CompareArrows,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "Select Technologies to Contrast",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Spacer(modifier = Modifier.height(14.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            // Selector 1
                            Box(modifier = Modifier.weight(1f)) {
                                OutlinedButton(
                                    onClick = { expandedDropdown1 = true },
                                    modifier = Modifier.fillMaxWidth(),
                                    shape = RoundedCornerShape(12.dp),
                                    contentPadding = PaddingValues(horizontal = 12.dp, vertical = 8.dp)
                                ) {
                                    Text(
                                        text = tech1?.name ?: "Select Tech 1",
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis,
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }

                                DropdownMenu(
                                    expanded = expandedDropdown1,
                                    onDismissRequest = { expandedDropdown1 = false }
                                ) {
                                    allTechnologies.forEach { t ->
                                        DropdownMenuItem(
                                            text = { Text(t.name) },
                                            onClick = {
                                                selectedTech1Id = t.id
                                                expandedDropdown1 = false
                                            }
                                        )
                                    }
                                }
                            }

                            // "VS" divider between the two selectors
                            Box(
                                modifier = Modifier
                                    .size(36.dp)
                                    .clip(RoundedCornerShape(50))
                                    .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.15f))
                                    .testTag("compare_vs_label"),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "VS",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = MaterialTheme.colorScheme.primary
                                )
                            }

                            // Selector 2
                            Box(modifier = Modifier.weight(1f)) {
                                OutlinedButton(
                                    onClick = { expandedDropdown2 = true },
                                    modifier = Modifier.fillMaxWidth(),
                                    shape = RoundedCornerShape(12.dp),
                                    contentPadding = PaddingValues(horizontal = 12.dp, vertical = 8.dp)
                                ) {
                                    Text(
                                        text = tech2?.name ?: "Select Tech 2",
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis,
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }

                                DropdownMenu(
                                    expanded = expandedDropdown2,
                                    onDismissRequest = { expandedDropdown2 = false }
                                ) {
                                    allTechnologies.forEach { t ->
                                        DropdownMenuItem(
                                            text = { Text(t.name) },
                                            onClick = {
                                                selectedTech2Id = t.id
                                                expandedDropdown2 = false
                                            }
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }

            if (tech1 != null && tech2 != null) {
                // Overview & Purpose Row
                item {
                    ComparisonSection(title = "Overview & Purpose") {
                        Row(modifier = Modifier.fillMaxWidth()) {
                            ComparisonColumn(
                                modifier = Modifier.weight(1f),
                                name = tech1.name,
                                content = tech1.overview
                            )
                            Spacer(modifier = Modifier.width(12.dp))
                            ComparisonColumn(
                                modifier = Modifier.weight(1f),
                                name = tech2.name,
                                content = tech2.overview
                            )
                        }
                    }
                }

                // Key Features Row
                item {
                    ComparisonSection(title = "Key Features") {
                        Row(modifier = Modifier.fillMaxWidth()) {
                            ComparisonBulletColumn(
                                modifier = Modifier.weight(1f),
                                name = tech1.name,
                                list = tech1.keyFeatures
                            )
                            Spacer(modifier = Modifier.width(12.dp))
                            ComparisonBulletColumn(
                                modifier = Modifier.weight(1f),
                                name = tech2.name,
                                list = tech2.keyFeatures
                            )
                        }
                    }
                }

                // Common Uses Row
                item {
                    ComparisonSection(title = "Common Uses") {
                        Row(modifier = Modifier.fillMaxWidth()) {
                            ComparisonBulletColumn(
                                modifier = Modifier.weight(1f),
                                name = tech1.name,
                                list = tech1.commonUses
                            )
                            Spacer(modifier = Modifier.width(12.dp))
                            ComparisonBulletColumn(
                                modifier = Modifier.weight(1f),
                                name = tech2.name,
                                list = tech2.commonUses
                            )
                        }
                    }
                }

                // Advantages Row
                item {
                    ComparisonSection(title = "Main Advantages") {
                        Row(modifier = Modifier.fillMaxWidth()) {
                            ComparisonBulletColumn(
                                modifier = Modifier.weight(1f),
                                name = tech1.name,
                                list = tech1.advantages,
                                isPositive = true
                            )
                            Spacer(modifier = Modifier.width(12.dp))
                            ComparisonBulletColumn(
                                modifier = Modifier.weight(1f),
                                name = tech2.name,
                                list = tech2.advantages,
                                isPositive = true
                            )
                        }
                    }
                }

                // Limitations Row
                item {
                    ComparisonSection(title = "Trade-offs & Limitations") {
                        Row(modifier = Modifier.fillMaxWidth()) {
                            ComparisonBulletColumn(
                                modifier = Modifier.weight(1f),
                                name = tech1.name,
                                list = tech1.limitations,
                                isNegative = true
                            )
                            Spacer(modifier = Modifier.width(12.dp))
                            ComparisonBulletColumn(
                                modifier = Modifier.weight(1f),
                                name = tech2.name,
                                list = tech2.limitations,
                                isNegative = true
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ComparisonSection(
    title: String,
    content: @Composable () -> Unit
) {
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
                text = title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(bottom = 12.dp)
            )
            content()
        }
    }
}

@Composable
fun ComparisonColumn(
    modifier: Modifier = Modifier,
    name: String,
    content: String
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f))
            .padding(12.dp)
    ) {
        Text(
            text = name,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(bottom = 4.dp)
        )
        Text(
            text = content,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}

@Composable
fun ComparisonBulletColumn(
    modifier: Modifier = Modifier,
    name: String,
    list: List<String>,
    isPositive: Boolean = false,
    isNegative: Boolean = false
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f))
            .padding(12.dp)
    ) {
        Text(
            text = name,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(bottom = 6.dp)
        )
        list.forEach { item ->
            BulletPointItem(text = item, isPositive = isPositive, isNegative = isNegative)
            Spacer(modifier = Modifier.height(4.dp))
        }
    }
}
