package com.alexismoraportal.grupojambeeapp.state

import com.alexismoraportal.grupojambeeapp.model.LocationInfo
import com.alexismoraportal.grupojambeeapp.model.Operation
import com.alexismoraportal.grupojambeeapp.model.PropertyImage

data class PropertyState(
    val publicId: String = "",
    val title: String = "",
    val description: String = "",
    val bedrooms: Float = 0f,
    val bathrooms: Float = 0f,
    val halfBathrooms: Float = 0f,
    val parkingSpaces: Float = 0f,
    val lotSize: Float = 0f,
    val constructionSize: Float = 0f,
    val lotLength: Float? = null,
    val lotWidth: Float? = null,
    val propertyType: String = "",
    val createdAt: String = "",
    val updatedAt: String = "",
    val publishedAt: String = "",
    val location: LocationInfo? = null, // Propiedad location agregada
    val operations: List<Operation>? = emptyList(), // Propiedad operations agregada
    val propertyImages: List<PropertyImage>? = emptyList()
)

