package com.example.data.model

data class Category(
    val id: String,
    val name: String,
    val shortDescription: String,
    val fullPurpose: String,
    val iconName: String, // Material icon mapping key
    val colorHex: String,
    val technologyCount: Int = 0
)

data class Technology(
    val id: String,
    val categoryId: String,
    val name: String,
    val overview: String,
    val mainPurpose: String,
    val keyFeatures: List<String>,
    val commonUses: List<String>,
    val advantages: List<String>,
    val limitations: List<String>,
    val relatedTechIds: List<String>,
    val officialUrl: String
)
