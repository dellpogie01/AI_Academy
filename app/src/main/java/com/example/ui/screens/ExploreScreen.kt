package com.example.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.isSpecified
import androidx.compose.ui.unit.sp
import com.example.data.model.Category
import com.example.data.model.Technology
import com.example.ui.components.CategoryCard

@Composable
fun ExploreScreen(
    categories: List<Category>,
    onCategoryClick: (String) -> Unit,
    modifier: Modifier = Modifier,
    bookmarkedIds: Set<String> = emptySet(),
    onSearchTechnologies: ((String) -> List<Technology>)? = null,
    onTechnologyClick: ((String) -> Unit)? = null,
    onBookmarkToggle: ((String) -> Unit)? = null
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .testTag("explore_screen_column")
    ) {
        // Fixed header: title and subtitle stay stationary at the top while scrolling.
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 12.dp)
        ) {
            Text(
                text = "Explore AI Technologies",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground
            )
            Spacer(modifier = Modifier.height(4.dp))
            SingleLineAutoFitText(
                text = "Explore 87 frameworks, tools, and platforms across 11 domains.",
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("explore_subtitle")
            )
        }

        // Scrollable list of categories
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .testTag("explore_results_list"),
            contentPadding = PaddingValues(start = 16.dp, end = 16.dp, top = 4.dp, bottom = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(categories, key = { "cat_${it.id}" }) { category ->
                CategoryCard(
                    category = category,
                    onClick = { onCategoryClick(category.id) }
                )
            }
        }
    }
}

/**
 * Renders [text] on exactly one line, reducing the font size (down to [minFontSize])
 * until the whole string fits the available width, so it never wraps or truncates.
 */
@Composable
private fun SingleLineAutoFitText(
    text: String,
    style: TextStyle,
    modifier: Modifier = Modifier,
    minFontSize: TextUnit = 8.sp
) {
    val textMeasurer = rememberTextMeasurer()
    val density = LocalDensity.current

    BoxWithConstraints(modifier = modifier) {
        val maxWidthPx = constraints.maxWidth
        val baseSize = if (style.fontSize.isSpecified) style.fontSize else 14.sp

        val fittedSize = remember(text, style, maxWidthPx, density) {
            if (maxWidthPx <= 0 || maxWidthPx == Constraints.Infinity) {
                baseSize
            } else {
                var low = minFontSize.value
                var high = baseSize.value
                var best = low
                // Fast binary search for maximum font size that fits within maxWidthPx
                for (step in 0..14) {
                    val mid = (low + high) / 2f
                    val width = textMeasurer.measure(
                        text = text,
                        style = style.copy(fontSize = mid.sp),
                        maxLines = 1,
                        softWrap = false,
                        constraints = Constraints()
                    ).size.width
                    if (width <= maxWidthPx) {
                        best = mid
                        low = mid
                    } else {
                        high = mid
                    }
                    if (high - low < 0.2f) break
                }
                best.sp
            }
        }

        Text(
            text = text,
            style = style.copy(fontSize = fittedSize, lineHeight = fittedSize * 1.35f),
            maxLines = 1,
            softWrap = false
        )
    }
}
